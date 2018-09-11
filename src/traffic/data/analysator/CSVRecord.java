package traffic.data.analysator;

import java.math.BigDecimal;
import java.text.ParseException;

public class CSVRecord {

	private String date;

	private String time;

	private String timeId;

	private int dayType;

	private String lotId;

	private String cityId;

	private String lotName;

	private BigDecimal totalJamINRadius_1;
	private BigDecimal totalJamOUTRadius_1;

	private BigDecimal totalJamINRadius_2;
	private BigDecimal totalJamOUTRadius_2;

	private BigDecimal totalJamINRadius_3;
	private BigDecimal totalJamOUTRadius_3;

	private BigDecimal avgINForRadius_1;
	private BigDecimal avgOUTForRadius_1;

	private BigDecimal avgINForRadius_2;
	private BigDecimal avgOUTForRadius_2;

	private BigDecimal avgINForRadius_3;
	private BigDecimal avgOUTForRadius_3;

	private Integer freeParkingSpaces;

	public CSVRecord(String[] csvParts) throws ParseException {

		this.date = csvParts[0];
		this.time = csvParts[1];
		this.timeId = csvParts[2];
		this.dayType = Integer.parseInt(csvParts[3]);
		this.lotId = csvParts[4];
		this.cityId = csvParts[5];
		this.lotName = csvParts[6];

		this.freeParkingSpaces = Integer.parseInt(csvParts[7]);

		this.totalJamINRadius_1 = new BigDecimal(csvParts[8]);
		this.totalJamOUTRadius_1 = new BigDecimal(csvParts[9]);

		this.totalJamINRadius_2 = new BigDecimal(csvParts[10]);
		this.totalJamOUTRadius_2 = new BigDecimal(csvParts[11]);

		this.totalJamINRadius_3 = new BigDecimal(csvParts[12]);
		this.totalJamOUTRadius_3 = new BigDecimal(csvParts[13]);

		this.avgINForRadius_1 = new BigDecimal(csvParts[14]);
		this.avgOUTForRadius_1 = new BigDecimal(csvParts[15]);

		this.avgINForRadius_2 = new BigDecimal(csvParts[16]);
		this.avgOUTForRadius_2 = new BigDecimal(csvParts[17]);

		this.avgINForRadius_3 = new BigDecimal(csvParts[18]);
		this.avgOUTForRadius_3 = new BigDecimal(csvParts[19]);
	}

	public CSVRecord(String date, String lotId, String cityId, String lotName, String timeId, int dayType, AverageRecord ar) {
		this.date = date;
		this.time = timeId;
		this.timeId = timeId;
		this.dayType = dayType;
		this.lotId = lotId;
		this.cityId = cityId;
		this.lotName = lotName;

		if (ar != null) {
			this.freeParkingSpaces = ar.getFreeParkingSpaces();

			this.totalJamINRadius_1 = ar.getTotalJamINRadius_1();
			this.totalJamOUTRadius_1 = ar.getTotalJamOUTRadius_1();

			this.totalJamINRadius_2 = ar.getTotalJamINRadius_2();
			this.totalJamOUTRadius_2 = ar.getTotalJamOUTRadius_2();

			this.totalJamINRadius_3 = ar.getTotalJamINRadius_3();
			this.totalJamOUTRadius_3 = ar.getTotalJamOUTRadius_3();

			this.avgINForRadius_1 = ar.getAvgINForRadius_1();
			this.avgOUTForRadius_1 = ar.getAvgOUTForRadius_1();

			this.avgINForRadius_2 = ar.getAvgINForRadius_2();
			this.avgOUTForRadius_2 = ar.getAvgOUTForRadius_2();

			this.avgINForRadius_3 = ar.getAvgINForRadius_3();
			this.avgOUTForRadius_3 = ar.getAvgOUTForRadius_3();
		}
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public String getTimeId() {
		return timeId;
	}

	public int getDayType() {
		return dayType;
	}

	public String getLotId() {
		return lotId;
	}

	public String getCityId() {
		return cityId;
	}

	public String getLotName() {
		return lotName;
	}

	public BigDecimal getTotalJamINRadius_1() {
		return totalJamINRadius_1;
	}

	public BigDecimal getTotalJamOUTRadius_1() {
		return totalJamOUTRadius_1;
	}

	public BigDecimal getTotalJamINRadius_2() {
		return totalJamINRadius_2;
	}

	public BigDecimal getTotalJamOUTRadius_2() {
		return totalJamOUTRadius_2;
	}

	public BigDecimal getTotalJamINRadius_3() {
		return totalJamINRadius_3;
	}

	public BigDecimal getTotalJamOUTRadius_3() {
		return totalJamOUTRadius_3;
	}

	public BigDecimal getAvgINForRadius_1() {
		return avgINForRadius_1;
	}

	public BigDecimal getAvgOUTForRadius_1() {
		return avgOUTForRadius_1;
	}

	public BigDecimal getAvgINForRadius_2() {
		return avgINForRadius_2;
	}

	public BigDecimal getAvgOUTForRadius_2() {
		return avgOUTForRadius_2;
	}

	public BigDecimal getAvgINForRadius_3() {
		return avgINForRadius_3;
	}

	public BigDecimal getAvgOUTForRadius_3() {
		return avgOUTForRadius_3;
	}

	public int getFreeParkingSpaces() {
		return freeParkingSpaces;
	}

	@Override
	public String toString() {
		return date + ";" + time + ";" + timeId + ";" + dayType + ";" + lotId + ";" + cityId + ";" + lotName + ";"
				+ (freeParkingSpaces != null ? freeParkingSpaces : "")   + ";" 
				+ (totalJamINRadius_1 != null ? totalJamINRadius_1 : "")    + ";" 
				+ (totalJamOUTRadius_1 != null ? totalJamOUTRadius_1 : "")   + ";" 
				+ (totalJamINRadius_2 != null ? totalJamINRadius_2 : "")   + ";" 
				+ (totalJamOUTRadius_2 != null ? totalJamOUTRadius_2 : "")    + ";" 
				+ (totalJamINRadius_3 != null ? totalJamINRadius_3 : "")    + ";" 
				+ (totalJamOUTRadius_3 != null ? totalJamOUTRadius_3 : "")    + ";"
				+ (avgINForRadius_1 != null ? avgINForRadius_1 : "")    + ";" 
				+ (avgOUTForRadius_1 != null ? avgOUTForRadius_1 : "")    + ";" 
				+ (avgINForRadius_2 != null ? avgINForRadius_2 : "")    + ";" 
				+ (avgOUTForRadius_2 != null ? avgOUTForRadius_2 : "")    + ";"
				+ (avgINForRadius_3 != null ? avgINForRadius_3 : "")    + ";" 
				+ (avgOUTForRadius_3 != null ? avgOUTForRadius_3 : "")    + "\n";
	}

}
