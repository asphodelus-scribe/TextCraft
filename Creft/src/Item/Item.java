package Item;

public enum Item {

	LOG("log"), COPPERORE("copper ore"), TINORE("tin ore"), IRONORE("tin ore"), STICK("stick"),
	REFINEDTIN("refined tin"), REFINEDCOPPER("refined copper"), REFINEDIRON("refined iron"), 
	COPPERSHOVEL("copper shovel"), IRONSHOVEL("iron shovel"), COPPERPICKAXE("copper pickaxe"), IRONPICKAXE("iron pickaxe");
	
	private String name;
	
	private Item(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}
