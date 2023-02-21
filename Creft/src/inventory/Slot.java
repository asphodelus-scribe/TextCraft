package inventory;

import Item.Item;

public class Slot {

	Item contents = null;
	
	public Item contents(){
		return contents;
	}
	
	public void place(Item i){
		contents = i;
	}
	
	public void empty() {
		contents = null;
	}
	
}
