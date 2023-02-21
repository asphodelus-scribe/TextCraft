package inventory;
import java.util.HashMap;
import java.util.Map;

import Item.Item;


public class Inventory {

	Slot[] inv;
	int size;
	
	public Inventory(int size){
		this.size = size;
		inv = new Slot[size];
		for(int i = 0; i < size; i++){
			inv[i] = new Slot();
		}
	}
	
	public void putInSpecificSlot(Item item, int index){
		inv[index].place(item);
	}
	
	public void putInNextEmptySlot(Item item){
		for(int i = 0; i < size; i++){
			System.out.println(i);
			if(inv[i].contents() == null){
				inv[i].place(item);
				break;
			}
		}
	}
	
	public void removeItem(Item item) {
		for(int i = 0; i < size; i++) {
			if(inv[i].contents() != null) { 
				if(inv[i].contents().equals(item)) inv[i].empty();;
			}
		}
	}
	
	public Item getSlotContents(int index){
		return inv[index].contents();
	}
	
	public String getSlotContentsName(int index){
		if(inv[index].contents() != null){
			return inv[index].contents().getName();
		}else{
			return "";
		}
	}
	
	public boolean isFull(){
		for(int i = 0; i < size; i++){
			if(inv[i].contents() == null){
				return false;
			}
		}
		return true;
	}
	
	public int getSize(){
		return size;
	}
	
}
