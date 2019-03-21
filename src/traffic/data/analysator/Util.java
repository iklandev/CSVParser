package traffic.data.analysator;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.apache.log4j.Logger;

public class Util {

	static Logger logger = Logger.getLogger(Util.class.getName());
	
	public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	public static final DateFormat HOURS_MINUTES = new SimpleDateFormat("HH:mm");

	public static void listDirectory(File directory, ArrayList<File> files) {

		// get all the files from a directory
		File[] fList = directory.listFiles();
		for (File file : fList) {
			if (file.isFile()) {
				files.add(file);
			} else if (file.isDirectory()) {
				listDirectory(file, files);
			}
		}
	}

	public static String mapToString(LinkedHashMap<String, Integer> hmap) {
		StringBuilder sb = new StringBuilder();

		Set set = hmap.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			sb.append(mentry.getKey());
			sb.append(";");
			sb.append(mentry.getValue());
			sb.append("\n");
		}

		return sb.toString();
	}

	public static String listToString(List<CSVRecord> records) {
		
		StringBuilder sb = new StringBuilder();
		for (CSVRecord rec : records) {
			if(rec!=null){
				sb.append(rec.toString());
			}
		}
		return sb.toString();
	}
	
	public static CSVRecord findRecordForTimeID(CSVRecord record, Calendar calendar){
		
		String timeId = HOURS_MINUTES.format(calendar.getTime());
		int dayType = calendar.get(Calendar.DAY_OF_WEEK)-1;
		if (dayType == 0){
			dayType = 7;
		}
		
		//final int dt = dayType;
		//logger.info("Get regord for: "+timeId+" - "+dayType);
		//Optional<AverageRecord> rec = records.stream().filter(x->x.getTimeId().equals(timeId) && x.getDayType() == dt).findFirst();
		
		//if(!rec.isPresent()){
			//logger.info("RECORD NOT FOUND");
			//return null;
		//}
		
		//return new CSVRecord(DATE_FORMAT.format(calendar.getTime()), record.getLotId(), record.getCityId(), record.getLotName(), timeId, dayType, null);
		return null;
	}

}
