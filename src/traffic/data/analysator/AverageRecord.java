package traffic.data.analysator;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;

public class AverageRecord {
	
	private String timeId;
	
	private int dayType;
	
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
	
	private int freeParkingSpaces;
	
	public AverageRecord (int dayType, String timeId, List<CSVRecord> records) {
/*		
		this.dayType = dayType;
		this.timeId = timeId;
		
		IntSummaryStatistics statsInt = records.stream()
                .mapToInt((x) -> x.getFreeParkingSpaces())
                .summaryStatistics();
		this.freeParkingSpaces = (int) statsInt.getAverage();
		
		DoubleSummaryStatistics stats = records.stream()
                .mapToDouble((x) -> x.getTotalJamINRadius_1().doubleValue())
                .summaryStatistics();
		this.totalJamINRadius_1 = new BigDecimal(stats.getAverage()).setScale(2, BigDecimal.ROUND_HALF_UP);
		stats = records.stream()
                .mapToDouble((x) -> x.getTotalJamOUTRadius_1().doubleValue())
                .summaryStatistics();
		this.totalJamOUTRadius_1 = new BigDecimal(stats.getAverage()).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		stats = records.stream()
                .mapToDouble((x) -> x.getTotalJamINRadius_2().doubleValue())
                .summaryStatistics();
		this.totalJamINRadius_2 = new BigDecimal(stats.getAverage()).setScale(2, BigDecimal.ROUND_HALF_UP);
		stats = records.stream()
                .mapToDouble((x) -> x.getTotalJamOUTRadius_2().doubleValue())
                .summaryStatistics();
		this.totalJamOUTRadius_2 = new BigDecimal(stats.getAverage()).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		stats = records.stream()
                .mapToDouble((x) -> x.getTotalJamINRadius_3().doubleValue())
                .summaryStatistics();
		this.totalJamINRadius_3 = new BigDecimal(stats.getAverage()).setScale(2, BigDecimal.ROUND_HALF_UP);
		stats = records.stream()
                .mapToDouble((x) -> x.getTotalJamOUTRadius_3().doubleValue())
                .summaryStatistics();
		this.totalJamOUTRadius_3 = new BigDecimal(stats.getAverage()).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		stats = records.stream()
                .mapToDouble((x) -> x.getAvgINForRadius_1().doubleValue())
                .summaryStatistics();
		this.avgINForRadius_1 = new BigDecimal(stats.getAverage()).setScale(2, BigDecimal.ROUND_HALF_UP);
		stats = records.stream()
                .mapToDouble((x) -> x.getAvgOUTForRadius_1().doubleValue())
                .summaryStatistics();
		this.avgOUTForRadius_1 = new BigDecimal(stats.getAverage()).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		stats = records.stream()
                .mapToDouble((x) -> x.getAvgINForRadius_2().doubleValue())
                .summaryStatistics();
		this.avgINForRadius_2 = new BigDecimal(stats.getAverage()).setScale(2, BigDecimal.ROUND_HALF_UP);
		stats = records.stream()
                .mapToDouble((x) -> x.getAvgOUTForRadius_2().doubleValue())
                .summaryStatistics();
		this.avgOUTForRadius_2 = new BigDecimal(stats.getAverage()).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		stats = records.stream()
                .mapToDouble((x) -> x.getAvgINForRadius_3().doubleValue())
                .summaryStatistics();
		this.avgINForRadius_3 = new BigDecimal(stats.getAverage()).setScale(2, BigDecimal.ROUND_HALF_UP);
		stats = records.stream()
                .mapToDouble((x) -> x.getAvgOUTForRadius_3().doubleValue())
                .summaryStatistics();
		this.avgOUTForRadius_3 = new BigDecimal(stats.getAverage()).setScale(2, BigDecimal.ROUND_HALF_UP);*/
	}

	public String getTimeId() {
		return timeId;
	}

	public int getDayType() {
		return dayType;
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
		return dayType + ";" +timeId+";"
				+ freeParkingSpaces+";"+ totalJamINRadius_1
				+ ";" + totalJamOUTRadius_1 + ";" + totalJamINRadius_2
				+ ";" + totalJamOUTRadius_2 + ";" + totalJamINRadius_3
				+ ";" + totalJamOUTRadius_3 + ";" + avgINForRadius_1
				+ ";" + avgOUTForRadius_1 + ";" + avgINForRadius_2
				+ ";" + avgOUTForRadius_2 + ";" + avgINForRadius_3
				+ ";" + avgOUTForRadius_3
				+"\n";
	}
	
}
