package traffic.data.analysator;

import java.io.File;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class Util {
	
	static Logger logger = Logger.getLogger(Util.class.getName());

	
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

}
