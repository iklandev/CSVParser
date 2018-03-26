package traffic.data.analysator.view;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Callback;
import traffic.data.analysator.LotItem;
import traffic.data.analysator.Main;
import traffic.data.analysator.Util;

public class MainScreenController {

	@FXML
	private Button btnChoose;

	@FXML
	private Button btnValidate;

	@FXML
	private Button btnFinalMerge;

	@FXML
	private Label infoLabel;

	@FXML
	private TextArea logTextArea;

	@FXML
	private ComboBox<LotItem> comboBox;

	@FXML
	private CheckBox forAllGarages;

	private File directory;

	private boolean forAllLots = false;

	private ResourceBundle resourceBundle;

	ObservableList<LotItem> lotList = FXCollections.observableArrayList(LotItem.getAllLots());

	// Reference to the main application.
	private Main mainApp;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public MainScreenController() {
		resourceBundle = Main.loadLang("en");
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		btnChoose.setText(resourceBundle.getString("choose.btn"));
		infoLabel.setText(resourceBundle.getString("noFileSelected"));
		btnFinalMerge.setText(resourceBundle.getString("btnFinalMerge"));

		this.comboBox.setItems(lotList);
		this.comboBox.getSelectionModel().selectFirst(); // select the first
															// element

		this.comboBox.setCellFactory(new Callback<ListView<LotItem>, ListCell<LotItem>>() {

			public ListCell<LotItem> call(ListView<LotItem> p) {

				final ListCell<LotItem> cell = new ListCell<LotItem>() {

					@Override
					protected void updateItem(LotItem t, boolean bln) {
						super.updateItem(t, bln);

						if (t != null) {
							setText(t.getName());
						} else {
							setText(null);
						}
					}

				};

				return cell;
			}
		});

		forAllGarages.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				comboBox.setDisable(newValue);
				forAllLots = newValue;

			}
		});
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	private void showChooseDialog(ActionEvent event) {

		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Choose resource directory");

		File selectedDirectory = directoryChooser.showDialog(this.mainApp.getPrimaryStage());

		if (selectedDirectory != null) {
			directory = selectedDirectory;
			String infoString = resourceBundle.getString("selectedFile") + " " + directory.getAbsolutePath();
			infoLabel.setText(infoString);
		}
	}

	@FXML
	private void merge(ActionEvent event) {

		if (directory != null) {
			logTextArea.appendText("Start merging csv traffic files ...\n");
			new Thread(() -> {

				String id = comboBox.getSelectionModel().getSelectedItem().getId();

				ArrayList<File> fileDir = new ArrayList<File>();
				Util.listDirectory(directory, fileDir);
				File[] files = fileDir.toArray(new File[fileDir.size()]);

				Arrays.sort(files, new Comparator<File>() {
					@Override
					public int compare(File o1, File o2) {
						int n1 = extractNumber(o1.getName());
						int n2 = extractNumber(o2.getName());
						return n1 - n2;
					}

					private int extractNumber(String name) {
						int i = 0;
						try {
							int s = name.indexOf('_') + 1;
							int e = name.lastIndexOf('.');
							String number = name.substring(s, e);
							i = Integer.parseInt(number);
						} catch (Exception e) {
							i = 0; // if filename does not match the format
									// then default to 0
						}
						return i;
					}
				});
				int currentFile = 0;
				final int totalFiles = files.length;
				final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
				for (File file : files) {
					currentFile++;

					final String currentFileName = file.getName();
					final int currentFileTemp = currentFile;

					if (currentFileName.contains(".csv")) {
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								logTextArea.appendText(String.format("%s: Processing %s/%s, file %s ...\n",
										dateFormat.format(new Date()), currentFileTemp, totalFiles, currentFileName));
							}
						});
						try {
							FileReader fr = new FileReader(file);
							BufferedReader br = new BufferedReader(fr);

							String line;
							while ((line = br.readLine()) != null) {
								String[] csvParts = line.split(";");
								if (forAllLots) {
									Path filePath = Paths.get(directory.getAbsolutePath(), csvParts[4] + ".csv");
									Files.write(filePath, (line + "\n").getBytes(), CREATE, APPEND);
								} else {
									if (csvParts[4].equals(id)) {
										Path filePath = Paths.get(directory.getAbsolutePath(), id + ".csv");
										Files.write(filePath, (line + "\n").getBytes(), CREATE, APPEND);
									}
								}

							}

							if (currentFile == totalFiles) {
								Platform.runLater(new Runnable() {
									@Override
									public void run() {
										logTextArea.appendText(
												String.format("%s:Finsih...\n", dateFormat.format(new Date())));
									}
								});
							}

						} catch (Exception e) {
							Platform.runLater(new Runnable() {
								@Override
								public void run() {
									logTextArea.appendText(String.format("ERROR %s: Merging %s/%s, file %s. Error %s",
											dateFormat.format(new Date()), currentFileTemp, totalFiles, currentFileName,
											e.getMessage()));
								}
							});
						}

					} else {
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								logTextArea.appendText(String.format(
										"%s: Merging %s/%s, file %s don't match the template \n",
										dateFormat.format(new Date()), currentFileTemp, totalFiles, currentFileName));
							}
						});
					}

				}
			}).start();
		}
	}

	@FXML
	private void validate(ActionEvent event) {
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("CSV Files", "*.csv"));
		File selectedFile = fileChooser.showOpenDialog(this.mainApp.getPrimaryStage());

		
		if (selectedFile != null) {
			new Thread(() -> {

				final DateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");

				try {
					FileReader fr = new FileReader(selectedFile);
					BufferedReader br = new BufferedReader(fr);

					String line;
					int i = 1;
					Calendar calCom = Calendar.getInstance();
					while ((line = br.readLine()) != null) {
						String[] csvParts = line.split(";");
						Calendar cal = Calendar.getInstance();
						cal.setTime(dateFormat.parse(csvParts[2]+" "+csvParts[0]));
						if (i==1){
							calCom.setTime(cal.getTime());
						}
						
						if (!calCom.equals(cal)){
							Platform.runLater(new Runnable() {
								@Override
								public void run() {
									logTextArea.appendText(String.format("Expected %s but  found %s\n",
											dateFormat.format(calCom.getTime()),dateFormat.format(cal.getTime())));
								}
							});
							
							calCom.setTime(cal.getTime());
							calCom.add(Calendar.MINUTE, 4);
						} else {
							calCom.add(Calendar.MINUTE, 4);
						}
						i++;
						
					}

				} catch (Exception e) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							logTextArea.appendText(String.format("ERROR %s",
									e.getMessage()));
						}
					});
				}

			}).start();
		}
	}
}
