
package traffic.data.analysator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public enum City {
	
	Pittsburgh (1, "US/Eastern"),
	Madison (2, "US/Central"),
	Asheville (3, "US/Eastern"),
	AnnArbor (4, "US/Eastern"),
	Seattle (5, "US/Pacific"),
	SantaBarbara (6, "US/Pacific"),
	Winchester (7, "Etc/GMT-1"),
	SantaMonica (8, "US/Pacific");
	
	private int id;
	
	private String timeZone;
	
	City (int id, String timeZone) {
		this.id = id;
		this.timeZone = timeZone;
	}
	
	public int getId() {
		return this.id; 
	}
	
	public String getCurrentDate () {
		Date date = new Date();  

		DateFormat formatter = new SimpleDateFormat("yyyyddMM");
		formatter.setTimeZone(TimeZone.getTimeZone(this.timeZone)); 
		return formatter.format(date); 
	}
	public String getCurrentTime() {
		Date date = new Date();  

		DateFormat formatter = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		formatter.setTimeZone(TimeZone.getTimeZone(this.timeZone)); 
		return formatter.format(date); 
	}

	public static City getCity(int id) {
	      for (City l : City.values()) {
	          if (l.id == id) return l;
	      }
	      throw new IllegalArgumentException("City not found");
	   }
}
