package traffic.data.analysator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public enum Lot {
	
	//Pittsburgh (19)
	Theater_Square ("1_2", 1, new BigDecimal(40.443869), new BigDecimal(-80.00061), 580), //Checked
	ConventionCenter ("1_4", 1, new BigDecimal(40.445537), new BigDecimal(-79.995132), 676), //Checked
	Sixth_and_Penn ("1_5", 1, new BigDecimal(40.44256246), new BigDecimal(-80.00246286), 442), //Checked
	//Town_Place ("1_6", 1, new BigDecimal(40.440533), new BigDecimal(-80.004394), 200), 
	//Gateway_Center_Garage ("1_10", 1, new BigDecimal(40.4410305), new BigDecimal(-80.0060234), 544),
	//1_11
	US_Steel_Tower ("1_12", 1, new BigDecimal(40.441355), new BigDecimal(-79.994853), 641), //Checked
	//1_13
	Market_Square ("1_14", 1, new BigDecimal(40.4401962), new BigDecimal(-80.0011212), 224), //Checked for weekends there are zeros
	Three_PNC_Plaza ("1_25", 1, new BigDecimal(40.44123151), new BigDecimal(-80.0011754), 170), //Checked
	Ft_Duquesne_and_Sixth ("1_26", 1, new BigDecimal(40.44360761), new BigDecimal(-80.00285983), 845), //Checked it seems like form 01.01 they increase the spaces
	Smithfield_and_Liberty ("1_27", 1, new BigDecimal(40.4427176), new BigDecimal(-79.99783874), 530), //Checked
	Grant_Street_Center ("1_28", 1, new BigDecimal(40.44537942), new BigDecimal(-79.99277472), 888), //Checked
	Ninth_and_Penn ("1_30", 1, new BigDecimal(40.44408526), new BigDecimal(-79.99856293), 460), //Checked
	General_Robinson_Garage ("1_33", 1, new BigDecimal(40.44747776), new BigDecimal(-80.00951171), 1265), //Checked
	//1_34
	PPG_Garage ("1_35", 1, new BigDecimal(40.43968823), new BigDecimal(-80.00261307), 620), //Checked
	Eleven_Stanwix ("1_36", 1, new BigDecimal(40.43910031), new BigDecimal(-80.00560641), 400), //Checked
	Manor_Garage ("1_37", 1, new BigDecimal(40.43718135), new BigDecimal(-79.9960953), 870),//Checked for Sundays there is always 0
	Third_Avenue ("1_38", 1, new BigDecimal(40.43946776), new BigDecimal(-80.00235558), 480), //Checked
	Mellon_Square ("1_39", 1, new BigDecimal(40.44088856), new BigDecimal(-79.99746323), 730),  //Checked
	Wood_Allies ("1_40", 1, new BigDecimal(40.43842255), new BigDecimal(-80.00282764), 355), //Checked
	Oliver ("1_41", 1, new BigDecimal(40.44089673), new BigDecimal(-79.99906182), 485), //Checked
	First_Avenue ("1_42", 1, new BigDecimal(40.43505001), new BigDecimal(-79.99605775), 1260), //Checked
	
	//Madison (6)
	Overture_Center_Garage ("2_1", 2, new BigDecimal(43.073356), new BigDecimal(-89.389362), 650), //Checked
	State_Street_Capitol_Garage ("2_2", 2, new BigDecimal(43.075482), new BigDecimal(-89.388118), 625), //Checked
	Government_East_Garage ("2_3", 2, new BigDecimal(43.073936), new BigDecimal(-89.380267), 500), //Checked
	State_Street_Campus_Garage ("2_5", 2, new BigDecimal(43.074067), new BigDecimal(-89.3966), 950),//Checked
	Capitol_Square_North_Garage ("2_6", 2, new BigDecimal(43.07764), new BigDecimal(-89.38326), 560),//Checked
	Brayton_Lot ("2_9", 2, new BigDecimal(43.076751), new BigDecimal(-89.38022), 245), //Checked
	
	//Asheville (4)
	Biltmore_Ave ("3_BI", 3, new BigDecimal(35.592445), new BigDecimal(-82.551773), 325), //Checked
	Civic_Center ("3_CI", 3, new BigDecimal(35.596867), new BigDecimal(-82.554126), 500), //Checked
	Rankin_Ave ("3_RA", 3, new BigDecimal(35.596133), new BigDecimal(-82.554072), 210), //Checked
	Wall_Street ("3_WA", 3, new BigDecimal(35.594614), new BigDecimal(-82.557025), 205), //Checked
	
	//AnnArbor (10)
	Ann_Ashley_Structure ("4_AN7", 4, new BigDecimal(42.2826333), new BigDecimal(-83.7496376), 800), //Checked
	First_and_Washington_Structure ("4_FI2", 4, new BigDecimal(42.2804774), new BigDecimal(-83.7500788), 250), //Checked
	First_and_Huron_Lot ("4_FI10", 4, new BigDecimal(42.281444), new BigDecimal(-83.749812), 58), //Checked
	Fourth_and_Washington_Structure ("4_FO1", 4, new BigDecimal(42.2805163), new BigDecimal(-83.7481832), 300), //Checked
	Forest_Structure ("4_FO4", 4, new BigDecimal(42.2743915), new BigDecimal(-83.733201), 850), //Checked
	Fourth_and_William_Structure ("4_FO5", 4, new BigDecimal(42.2784615), new BigDecimal(-83.7477646), 1150), //Checked
	Liberty_Square_Structure ("4_LI6", 4, new BigDecimal(42.280283), new BigDecimal(-83.7428007), 510), //Checked 
	Library_Lane_Structure ("4_LI8", 4, new BigDecimal(42.2787552), new BigDecimal(-83.7455673), 780), //Checked 
	Maynard_Structure ("4_MA3", 4, new BigDecimal(42.2789278), new BigDecimal(-83.7421086), 950), //Checked 
	South_Ashley_Lot ("4_SO9", 4, new BigDecimal(42.2793726), new BigDecimal(-83.7498497), 55), //Checked 
	
	//Seattle (8)
	//Pike_Place ("5_G2", 5, new BigDecimal(47.608848), new BigDecimal(-122.341942)), no data
	Third_and_Stewart ("5_G3", 5, new BigDecimal(47.611310), new BigDecimal(-122.339771), 1092), //Checked  non working all day
	Pacific_Place ("5_G4", 5, new BigDecimal(47.613155), new BigDecimal(-122.335458), 2000), //Checked  non working all day
	PSP_Cobb ("5_G7", 5, new BigDecimal(47.608978), new BigDecimal(-122.336138), 578), //Checked  non working all day
	Convention_Center ("5_G9", 5, new BigDecimal(47.611518), new BigDecimal(-122.332894), 1260), //Checked
	WAC_Parking ("5_G11", 5, new BigDecimal(47.610327), new BigDecimal(-122.334067), 305), //Checked
	//Bell_Street_Pier ("5_G13", 5, new BigDecimal(47.613033), new BigDecimal(-122.350684)), Strange data
	Hillclimb_Garage ("5_G14", 5, new BigDecimal(47.607690), new BigDecimal(-122.341156), 135), //Checked
	//Stadium_Place ("5_G15", 5, new BigDecimal(47.597644), new BigDecimal(-122.333049)), Strange data
	First_and_Columbia ("5_G16", 5, new BigDecimal(47.602749), new BigDecimal(-122.334931), 735), //Checked
	Butler_Garage ("5_G17", 5, new BigDecimal(47.602265), new BigDecimal(-122.333070), 290), //Checked
	//Watermark_Garage ("5_G18", 5, new BigDecimal(47.605427), new BigDecimal(-122.338199)), Strange data
	//Waterfront_Place ("5_G19", 5, new BigDecimal(47.604246), new BigDecimal(-122.337949)),
	//West_Edge ("5_G22", 5, new BigDecimal(47.609566), new BigDecimal(-122.338821), ),
	
	//SantaBarbara (13)
	Lot_6 ("6_0", 6, new BigDecimal(34.424597), new BigDecimal(-119.704160), 570), //Checked
	Lot_7 ("6_1", 6, new BigDecimal(34.423415), new BigDecimal(-119.702723), 260), //Checked
	Lot_8 ("6_2", 6, new BigDecimal(34.422448), new BigDecimal(-119.702037), 120), //Checked
	Lot_9 ("6_3", 6, new BigDecimal(34.421312), new BigDecimal(-119.700680), 115), //Checked
	Lot9_2_Roof ("6_5", 6, new BigDecimal(34.421312), new BigDecimal(-119.700680), 125), //Checked
	Lot_2 ("6_7", 6, new BigDecimal(34.420250), new BigDecimal(-119.701937), 565), //Checked posle opredelen datum ima pogolem broj na mesta
	Lot_10 ("6_8", 6, new BigDecimal(34.419143), new BigDecimal(-119.696836), 555), //Checked
	Lot_3 ("6_9", 6, new BigDecimal(34.421356), new BigDecimal(-119.703367), 170), //Checked
	Lot_12 ("6_10", 6, new BigDecimal(34.415290), new BigDecimal(-119.694084), 90), //Checked
	Lot_11 ("6_11", 6, new BigDecimal(34.417955), new BigDecimal(-119.695401), 185), //Checked
	Lot_13 ("6_12", 6, new BigDecimal(34.414033), new BigDecimal(-119.692946), 195), //Checked
	Lot_4 ("6_13", 6, new BigDecimal(34.422139), new BigDecimal(-119.704554), 120), //Checked
	Lot_5 ("6_14", 6, new BigDecimal(34.423078), new BigDecimal(-119.705953), 195), //Checked

	//Winchester (8)
	Chesil_St_MSCP ("7_1", 7, new BigDecimal(51.060328), new BigDecimal(-1.305676), 572), //Checked not working all day
	South_Winchester_PandR ("7_2", 7, new BigDecimal(51.032660), new BigDecimal(-1.328583), 850), //Checked not working all day
	Tower_St ("7_3", 7, new BigDecimal(51.064961), new BigDecimal(-1.318118), 509), //Checked not working all day
	The_Brooks ("7_7", 7, new BigDecimal(51.063278), new BigDecimal(-1.311710), 314), //Checked not working all day
	Barfield_PandR ("7_8", 7, new BigDecimal(51.054308), new BigDecimal(-1.306820), 194), //Checked not working all day
	St_Catherines_PandR ("7_9", 7, new BigDecimal(51.050560), new BigDecimal(-1.305766), 573), //Checked not working all day
	Middlebrook_St ("7_10", 7, new BigDecimal(51.063438), new BigDecimal(-1.311099), 141), //Checked not working all day
	Pitt_PandR ("7_12", 7, new BigDecimal(51.053344), new BigDecimal(-1.348075), 185), //Checked not working all day
	
	//SantaMonica (18)
	Library ("8_76", 8, new BigDecimal(34.01900), new BigDecimal(-118.49361), 532), //Checked not working all day
	CivicCenter ("8_6767", 8, new BigDecimal(34.01158), new BigDecimal(-118.48997), 705), //Checked 
	Pier_Deck ("8_8068", 8, new BigDecimal(34.009333), new BigDecimal(-118.496389), 250),  //Checked posle opredelen datum ima pomal broj na mesta
	Structure_1 ("8_8349", 8, new BigDecimal(34.018203), new BigDecimal(-118.497761), 338), //Checked 
	Structure_2 ("8_8350", 8, new BigDecimal(34.016861), new BigDecimal(-118.498889), 697), //Checked
	Structure_3 ("8_8351", 8, new BigDecimal(34.017061), new BigDecimal(-118.496456), 355), //Checked
	Structure_4 ("8_8352", 8, new BigDecimal(34.015967), new BigDecimal(-118.497917), 655), //Checked
	Structure_5 ("8_8353", 8, new BigDecimal(34.015231), new BigDecimal(-118.494303), 667), //Checked
	Structure_6 ("8_8354", 8, new BigDecimal(34.014328), new BigDecimal(-118.495875), 743), //Checked
	Structure_7 ("8_8355", 8, new BigDecimal(34.01444), new BigDecimal(-118.49372), 811), //Checked maybe not working all day
	Structure_8 ("8_8356", 8, new BigDecimal(34.01289), new BigDecimal(-118.49372), 1002), //Checked not working all day
	Structure_9 ("8_8357", 8, new BigDecimal(34.019575), new BigDecimal(-118.499378), 293), //Checked
	Beach_House_Lot ("8_667276", 8, new BigDecimal(34.023972), new BigDecimal(-118.512472), 270), //Checked not working all day
	Lot_1_North ("8_764978", 8, new BigDecimal(34.010806), new BigDecimal(-118.497361), 1060), //Checked
	Lot_3_North ("8_765178", 8, new BigDecimal(34.016806), new BigDecimal(-118.502750), 463), //Checked
	Lot_4_South ("8_765283", 8, new BigDecimal(34.003028), new BigDecimal(-118.488639), 827), //Checked
	Lot_5_South ("8_765383", 8, new BigDecimal(33.998833), new BigDecimal(-118.484722), 787), //Checked
	Lot_8_North ("8_765678", 8, new BigDecimal(34.021000), new BigDecimal(-118.508333), 215); //Checked not working all day
	
	
	
	
	
	private int cityId;
	
	private String id;
	
	private BigDecimal latitude;

	private BigDecimal longitude;
	
	private String cityLotName;
	
	private int maxSpaces;
	
	Lot (String id, int cityId, BigDecimal latitude, BigDecimal longitude, int maxSpaces) {
		this.id = id;
		this.cityId = cityId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.cityLotName = City.getCity(cityId).name()+" - "+this.name()+" - "+this.id;
		this.maxSpaces = maxSpaces;
	}

	public int getCityId() {
		return cityId;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}
	
	
	public String getCityLotName() {
		return cityLotName;
	}
	
	public static List<Lot> getLotsForCity(int cityId) {
		
		List<Lot> result = new ArrayList<Lot>();
		
		for (Lot lot : Lot.values()) {
			if (lot.cityId == cityId) {
				result.add(lot);
			}
		}
		
		return result;
	}
	
	public static Lot getLotForId(String id){
		
		for (Lot lot : Lot.values()) {
			if (lot.getId().equals(id)) {
				return lot;
			}
		}
		
		return null;
	}

	public int getMaxSpaces() {
		return maxSpaces;
	}

}
