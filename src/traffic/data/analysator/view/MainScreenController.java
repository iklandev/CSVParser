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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

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
import javafx.util.Callback;
import traffic.data.analysator.AverageRecord;
import traffic.data.analysator.CSVRecord;
import traffic.data.analysator.Lot;
import traffic.data.analysator.LotItem;
import traffic.data.analysator.Main;
import traffic.data.analysator.Util;

public class MainScreenController {

	public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	public static final DateFormat DATE_FORMAT_WITH_HOURS = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	// static Logger logger =
	// Logger.getLogger(MainScreenController.class.getName());

	@FXML
	private Button btnChoose;

	@FXML
	private Button btnPercentageCalculation;

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
	private void calculateMaxes(ActionEvent event) {

		if (directory != null) {
			logTextArea.appendText("Start calculating ...\n");
			new Thread(() -> {
				ArrayList<File> fileDir = new ArrayList<File>();
				Util.listDirectory(directory, fileDir);
				File[] files = fileDir.toArray(new File[fileDir.size()]);

				int currentFile = 0;
				final int totalFiles = files.length;
				final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
				final DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
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
							Date prevDate = null;
							Date currentDate;
							List<Integer> maxes = new ArrayList<Integer>();
							LinkedHashMap<String, Integer> hmap = new LinkedHashMap<String, Integer>();
							while ((line = br.readLine()) != null) {
								String[] csvParts = line.split(";");
								if (csvParts.length > 7 && csvParts[0] != null && !csvParts[0].equals("")
										&& csvParts[7] != null && !csvParts[7].equals("")) {
									if (prevDate == null) {
										maxes.add(Integer.parseInt(csvParts[7]));
										prevDate = DATE_FORMAT.parse(csvParts[0]);
										continue;
									}
									currentDate = DATE_FORMAT.parse(csvParts[0]);
									if (prevDate.equals(currentDate)) {
										maxes.add(Integer.parseInt(csvParts[7]));
									} else {
										Integer max = maxes.stream().mapToInt(v -> v).max().getAsInt();
										hmap.put(dateFormat2.format(prevDate), max);
										maxes = new ArrayList<Integer>();
										maxes.add(Integer.parseInt(csvParts[7]));
									}
									prevDate = currentDate;
								}
							}

							Integer max = maxes.stream().mapToInt(v -> v).max().getAsInt();
							hmap.put(dateFormat2.format(prevDate), max);
							// Save the maxes in file
							Path filePath = Paths.get(directory.getAbsolutePath(), file.getName() + "-max.csv");
							Files.write(filePath, Util.mapToString(hmap).getBytes(), CREATE, APPEND);

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
									logTextArea.appendText(String.format("ERROR %s", e.getMessage()));
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
	private void calculateAverages(ActionEvent event) {

		if (directory != null) {
			logTextArea.appendText("Start calculating ...\n");
			new Thread(() -> {
				ArrayList<File> fileDir = new ArrayList<File>();
				Util.listDirectory(directory, fileDir);
				File[] files = fileDir.toArray(new File[fileDir.size()]);

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

							List<CSVRecord> records = new ArrayList<CSVRecord>();

							while ((line = br.readLine()) != null) {
								records.add(new CSVRecord(line.split(";"), 0));
							}

							// Map<Integer, Map<String, List<CSVRecord>>> map =
							// records.stream()
							// .collect(Collectors.groupingBy(CSVRecord::getDayType,
							// Collectors.groupingBy(CSVRecord::getTimeId)));

							// List<AverageRecord> result = new
							// ArrayList<AverageRecord>();
							// map.forEach((k, v) -> v.forEach ((k1, v1)->
							// result.add(new AverageRecord (k, k1, v1))));

							List<CSVRecord> finalRecords = new ArrayList<CSVRecord>();
							Calendar cal = Calendar.getInstance();
							cal.set(Calendar.YEAR, 2017);
							cal.set(Calendar.MONTH, 9);
							cal.set(Calendar.DAY_OF_MONTH, 1);
							cal.set(Calendar.HOUR_OF_DAY, 0);
							cal.set(Calendar.MINUTE, 0);
							cal.set(Calendar.SECOND, 0);
							cal.set(Calendar.MILLISECOND, 0);
							for (CSVRecord rec : records) {
								Calendar comp = Calendar.getInstance();
								comp.setTime(DATE_FORMAT_WITH_HOURS.parse(rec.getDate() + " " + rec.getTimeId()));
								comp.set(Calendar.SECOND, 0);
								comp.set(Calendar.MILLISECOND, 0);
								// logger.info("Comp
								// time:"+DATE_FORMAT_WITH_HOURS.format(comp.getTime()));
								// logger.info("Calendar
								// time:"+DATE_FORMAT_WITH_HOURS.format(cal.getTime()));
								if (comp.equals(cal)) {
									// logger.info("They are equal");
									finalRecords.add(rec);
									cal.add(Calendar.MINUTE, 4);
								} else {
									// logger.info("They are not equal");
									while (comp.after(cal)) {
										finalRecords.add(Util.findRecordForTimeID(rec, cal));
										cal.add(Calendar.MINUTE, 4);
										// logger.info("Comp
										// time:"+DATE_FORMAT_WITH_HOURS.format(comp.getTime()));
										// logger.info("Calendar
										// time:"+DATE_FORMAT_WITH_HOURS.format(cal.getTime()));
										if (comp.equals(cal)) {
											// logger.info("They are equal in
											// while");
											finalRecords.add(rec);
											cal.add(Calendar.MINUTE, 4);
											break;
										}

									}
								}
							}

							Path filePath = Paths.get(directory.getAbsolutePath(), file.getName() + "-final.csv");
							Files.write(filePath, Util.listToString(finalRecords).getBytes(), CREATE, APPEND);

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
									logTextArea.appendText(String.format("ERROR %s", e.getMessage()));
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
	private void calculatePercentage(ActionEvent event) {

		if (directory != null) {
			logTextArea.appendText("Start calculating ...\n");
			new Thread(() -> {
				ArrayList<File> fileDir = new ArrayList<File>();
				Util.listDirectory(directory, fileDir);
				File[] files = fileDir.toArray(new File[fileDir.size()]);

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
                            String cityId = currentFileName.replace(".csv", "");
                            Lot lot = Lot.getLotForId(cityId);
                            List<CSVRecord> records = new ArrayList<>();
                            
							while ((line = br.readLine()) != null) {
								String[] csvParts = line.split(";");
								records.add(new CSVRecord(csvParts, lot.getMaxSpaces()));
							}

							// Save the maxes in file
							Path filePath = Paths.get(file.getParentFile().getAbsolutePath(), file.getName() + "-percentage.csv");
							Files.write(filePath, Util.listToString(records).getBytes(), CREATE, APPEND);

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
									logTextArea.appendText(String.format("ERROR %s", e));
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

}
