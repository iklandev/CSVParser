package traffic.data.analysator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public enum Lot {
	
	Eleven_Stanwix ("1_36", 1, new BigDecimal(40.43910031), new BigDecimal(-80.00560641)),
	Sixth_and_Penn ("1_5", 1, new BigDecimal(40.44256246), new BigDecimal(-80.00246286)),
	Ninth_and_Penn ("1_30", 1, new BigDecimal(40.44408526), new BigDecimal(-79.99856293)),
	ConventionCenter ("1_4", 1, new BigDecimal(40.445537), new BigDecimal(-79.995132)),
	First_Avenue ("1_42", 1, new BigDecimal(40.43505001), new BigDecimal(-79.99605775)),
	Ft_Duquesne_and_Sixth ("1_26", 1, new BigDecimal(40.44360761), new BigDecimal(-80.00285983)),
	Gateway_Center_Garage ("1_10", 1, new BigDecimal(40.4410305), new BigDecimal(-80.0060234)),
	General_Robinson_Garage ("1_33", 1, new BigDecimal(40.44747776), new BigDecimal(-80.00951171)),
	Grant_Street_Center ("1_28", 1, new BigDecimal(40.44537942), new BigDecimal(-79.99277472)),
	Manor_Garage ("1_37", 1, new BigDecimal(40.43718135), new BigDecimal(-79.9960953)),
	Market_Square ("1_14", 1, new BigDecimal(40.4401962), new BigDecimal(-80.0011212)),
	Mellon_Square ("1_39", 1, new BigDecimal(40.44088856), new BigDecimal(-79.99746323)),
	Northshore_Garage ("1_34", 1, new BigDecimal(40.44889432), new BigDecimal(-80.00296712)),
	Nova_Place_Garage ("1_13", 1, new BigDecimal(40.45062936), new BigDecimal(-80.00481571)),
	Oliver ("1_41", 1, new BigDecimal(40.44089673), new BigDecimal(-79.99906182)),
	One_Oxford_Centre_Garage ("1_11", 1, new BigDecimal(40.43767958), new BigDecimal(-79.99816383)),
	PPG_Garage ("1_35", 1, new BigDecimal(40.43968823), new BigDecimal(-80.00261307)),
	Smithfield_and_Liberty ("1_27", 1, new BigDecimal(40.4427176), new BigDecimal(-79.99783874)),
	Theater_Square ("1_2", 1, new BigDecimal(40.443869), new BigDecimal(-80.00061)),
	Third_Avenue ("1_38", 1, new BigDecimal(40.43946776), new BigDecimal(-80.00235558)),
	Three_PNC_Plaza ("1_25", 1, new BigDecimal(40.44123151), new BigDecimal(-80.0011754)),
	Town_Place ("1_6", 1, new BigDecimal(40.440533), new BigDecimal(-80.004394)),
	US_Steel_Tower ("1_12", 1, new BigDecimal(40.441355), new BigDecimal(-79.994853)),
	Wood_Allies ("1_40", 1, new BigDecimal(40.43842255), new BigDecimal(-80.00282764)),
	Brayton_Lot ("2_9", 2, new BigDecimal(43.076751), new BigDecimal(-89.38022)),
	Capitol_Square_North_Garage ("2_6", 2, new BigDecimal(43.07764), new BigDecimal(-89.38326)),
	Government_East_Garage ("2_3", 2, new BigDecimal(43.073936), new BigDecimal(-89.380267)),
	Overture_Center_Garage ("2_1", 2, new BigDecimal(43.073356), new BigDecimal(-89.389362)),
	State_Street_Campus_Garage ("2_5", 2, new BigDecimal(43.074067), new BigDecimal(-89.3966)),
	State_Street_Capitol_Garage ("2_2", 2, new BigDecimal(43.075482), new BigDecimal(-89.388118)),
	Rankin_Ave ("3_RA", 3, new BigDecimal(35.596133), new BigDecimal(-82.554072)),
	Civic_Center ("3_CI", 3, new BigDecimal(35.596867), new BigDecimal(-82.554126)),
	Wall_Street ("3_WA", 3, new BigDecimal(35.594614), new BigDecimal(-82.557025)),
	Biltmore_Ave ("3_BI", 3, new BigDecimal(35.592445), new BigDecimal(-82.551773)),
	Fourth_and_Washington_Structure ("4_FO1", 4, new BigDecimal(42.2805163), new BigDecimal(-83.7481832)),
	First_and_Washington_Structure ("4_FI2", 4, new BigDecimal(42.2804774), new BigDecimal(-83.7500788)),
	Maynard_Structure ("4_MA3", 4, new BigDecimal(42.2789278), new BigDecimal(-83.7421086)),
	Forest_Structure ("4_FO4", 4, new BigDecimal(42.2743915), new BigDecimal(-83.733201)),
	Fourth_and_William_Structure ("4_FO5", 4, new BigDecimal(42.2784615), new BigDecimal(-83.7477646)),
	Liberty_Square_Structure ("4_LI6", 4, new BigDecimal(42.280283), new BigDecimal(-83.7428007)),
	Ann_Ashley_Structure ("4_AN7", 4, new BigDecimal(42.2826333), new BigDecimal(-83.7496376)),
	Library_Lane_Structure ("4_LI8", 4, new BigDecimal(42.2787552), new BigDecimal(-83.7455673)),
	South_Ashley_Lot ("4_SO9", 4, new BigDecimal(42.2793726), new BigDecimal(-83.7498497)),
	First_and_Huron_Lot ("4_FI10", 4, new BigDecimal(42.281444), new BigDecimal(-83.749812)),
	Pike_Place ("5_G2", 5, new BigDecimal(47.608848), new BigDecimal(-122.341942)),
	Butler_Garage ("5_G17", 5, new BigDecimal(47.602265), new BigDecimal(-122.333070)),
	First_and_Columbia ("5_G16", 5, new BigDecimal(47.602749), new BigDecimal(-122.334931)),
	Stadium_Place ("5_G15", 5, new BigDecimal(47.597644), new BigDecimal(-122.333049)),
	Pacific_Place ("5_G4", 5, new BigDecimal(47.613155), new BigDecimal(-122.335458)),
	PSP_Cobb ("5_G7", 5, new BigDecimal(47.608978), new BigDecimal(-122.336138)),
	Third_and_Stewart ("5_G3", 5, new BigDecimal(47.611310), new BigDecimal(-122.339771)),
	WAC_Parking ("5_G11", 5, new BigDecimal(47.610327), new BigDecimal(-122.334067)),
	Convention_Center ("5_G9", 5, new BigDecimal(47.611518), new BigDecimal(-122.332894)),
	West_Edge ("5_G22", 5, new BigDecimal(47.609566), new BigDecimal(-122.338821)),
	Bell_Street_Pier ("5_G13", 5, new BigDecimal(47.613033), new BigDecimal(-122.350684)),
	Hillclimb_Garage ("5_G14", 5, new BigDecimal(47.607690), new BigDecimal(-122.341156)),
	Waterfront_Place ("5_G19", 5, new BigDecimal(47.604246), new BigDecimal(-122.337949)),
	Watermark_Garage ("5_G18", 5, new BigDecimal(47.605427), new BigDecimal(-122.338199)),
	Lot_2 ("6_7", 6, new BigDecimal(34.420250), new BigDecimal(-119.701937)),
	Lot_3 ("6_9", 6, new BigDecimal(34.421356), new BigDecimal(-119.703367)),
	Lot_4 ("6_13", 6, new BigDecimal(34.422139), new BigDecimal(-119.704554)),
	Lot_5 ("6_14", 6, new BigDecimal(34.423078), new BigDecimal(-119.705953)),
	Lot_6 ("6_0", 6, new BigDecimal(34.424597), new BigDecimal(-119.704160)),
	Lot_7 ("6_1", 6, new BigDecimal(34.423415), new BigDecimal(-119.702723)),
	Lot_8 ("6_2", 6, new BigDecimal(34.422448), new BigDecimal(-119.702037)),
	Lot_9 ("6_3", 6, new BigDecimal(34.421312), new BigDecimal(-119.700680)),
	Lot9_2_Roof ("6_5", 6, new BigDecimal(34.421312), new BigDecimal(-119.700680)),
	Lot_10 ("6_8", 6, new BigDecimal(34.419143), new BigDecimal(-119.696836)),
	Lot_11 ("6_11", 6, new BigDecimal(34.417955), new BigDecimal(-119.695401)),
	Lot_12 ("6_10", 6, new BigDecimal(34.415290), new BigDecimal(-119.694084)),
	Lot_13 ("6_12", 6, new BigDecimal(34.414033), new BigDecimal(-119.692946)),
	Chesil_St_MSCP ("7_1", 7, new BigDecimal(51.060328), new BigDecimal(-1.305676)),
	Tower_St ("7_3", 7, new BigDecimal(51.064961), new BigDecimal(-1.318118)),
	The_Brooks ("7_7", 7, new BigDecimal(51.063278), new BigDecimal(-1.311710)),
	Middlebrook_St ("7_10", 7, new BigDecimal(51.063438), new BigDecimal(-1.311099)),
	South_Winchester_PandR ("7_2", 7, new BigDecimal(51.032660), new BigDecimal(-1.328583)),
	Barfield_PandR ("7_8", 7, new BigDecimal(51.054308), new BigDecimal(-1.306820)),
	St_Catherines_PandR ("7_9", 7, new BigDecimal(51.050560), new BigDecimal(-1.305766)),
	Pitt_PandR ("7_12", 7, new BigDecimal(51.053344), new BigDecimal(-1.348075)),
	Beach_House_Lot ("8_667276", 8, new BigDecimal(34.023972), new BigDecimal(-118.512472)),
	Structure_1 ("8_8349", 8, new BigDecimal(34.018203), new BigDecimal(-118.497761)),
	Structure_2 ("8_8350", 8, new BigDecimal(34.016861), new BigDecimal(-118.498889)),
	Structure_3 ("8_8351", 8, new BigDecimal(34.017061), new BigDecimal(-118.496456)),
	Structure_4 ("8_8352", 8, new BigDecimal(34.015967), new BigDecimal(-118.497917)),
	Structure_5 ("8_8353", 8, new BigDecimal(34.015231), new BigDecimal(-118.494303)),
	Structure_6 ("8_8354", 8, new BigDecimal(34.014328), new BigDecimal(-118.495875)),
	Structure_9 ("8_8357", 8, new BigDecimal(34.019575), new BigDecimal(-118.499378)),
	Lot_8_North ("8_765678", 8, new BigDecimal(34.021000), new BigDecimal(-118.508333)),
	Lot_3_North ("8_765178", 8, new BigDecimal(34.016806), new BigDecimal(-118.502750)),
	Lot_1_North ("8_764978", 8, new BigDecimal(34.010806), new BigDecimal(-118.497361)),
	Pier_Deck ("8_8068", 8, new BigDecimal(34.009333), new BigDecimal(-118.496389)),
	Lot_4_South ("8_765283", 8, new BigDecimal(34.003028), new BigDecimal(-118.488639)),
	Lot_5_South ("8_765383", 8, new BigDecimal(33.998833), new BigDecimal(-118.484722)),
	CivicCenter ("8_6767", 8, new BigDecimal(34.01158), new BigDecimal(-118.48997)),
	Library ("8_76", 8, new BigDecimal(34.01900), new BigDecimal(-118.49361)),
	Structure_7 ("8_8355", 8, new BigDecimal(34.01444), new BigDecimal(-118.49372)),
	Structure_8 ("8_8356", 8, new BigDecimal(34.01289), new BigDecimal(-118.49372));
	
	private int cityId;
	
	private String id;
	
	private BigDecimal latitude;

	private BigDecimal longitude;
	
	private String cityLotName;
	
	Lot (String id, int cityId, BigDecimal latitude, BigDecimal longitude) {
		this.id = id;
		this.cityId = cityId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.cityLotName = City.getCity(cityId).name()+" - "+this.name()+" - "+this.id;
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

}
