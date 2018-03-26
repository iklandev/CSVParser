package traffic.data.analysator;

import java.util.ArrayList;
import java.util.List;

public class LotItem {

	private String id;
	
	private String name;
	
	public LotItem (Lot lot) {
		this.id = lot.getId();
		this.name = lot.getCityLotName();
	}
	
	public static List<LotItem> getAllLots(){
		
		List <LotItem> res = new ArrayList<LotItem>();
		
		for(Lot l : Lot.values()){
			res.add(new LotItem(l));
		}
		return res;
	}
	
	public static List<String> getAllLotIDs(){
		List <String> res = new ArrayList<String>();
		
		for(LotItem i : LotItem.getAllLots()){
			res.add(i.getId());
		}
		
		return res;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}
