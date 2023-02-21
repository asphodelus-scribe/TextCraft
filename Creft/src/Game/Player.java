package Game;
import inventory.Inventory;

import java.util.ArrayList;
import java.util.Random;

import Item.*;
import crafting.RecipeManager;


public class Player {

	String name;
	int level;
	Inventory inv;
	
	public Player(){
		name = "User";
		level = 0;
		inv = new Inventory(10);		
	}
	
	public void move(){
		
	}
	
	public Inventory getInventory(){
		return inv;
	}
	
	public void printInventory(){
		System.out.println("Inventory:");
		for(int i = 0; i < inv.getSize(); i++){
			System.out.println("["+inv.getSlotContentsName(i)+"]");
		}
	}
	
	public boolean hasItemInInventory(Item item){
		for(int i = 0; i < inv.getSize(); i++){
			if(inv.getSlotContents(i).equals(item)){
				return true;
			}
		}
		return false;
	}
	
	public boolean hasAmountOfItemInInventory(Item item, int amount){
		int count = 0;
		for(int i = 0; i < inv.getSize(); i++){
			if(inv.getSlotContents(i).equals(item)){
				count++;
			}
		}
		if(count >= amount){
			return true;
		}else{
			return false;
		}
	}
	
	//TODO
	//public int getAmountCraftable(Item item){
		
	//}
	
	public ArrayList<Item> getItemsInInventory(){
		ArrayList<Item> invItems = new ArrayList<Item>();
		for(int i = 0; i < inv.getSize(); i++){
			invItems.add(inv.getSlotContents(i));
		}
		return invItems;
	}
	
	public int getAmountOfItemInInventory(Item item){
		int count = 0;
		for(int i = 0; i < inv.getSize(); i++){
			if(inv.getSlotContents(i).equals(item)){
				count++;
			}
		}
		return count;
	}
	
	public void craftItem(Item result, ArrayList<Item> ingr) {
		for(int i = 0; i < ingr.size(); i++) {
			inv.removeItem(ingr.get(i));
		}
		inv.putInNextEmptySlot(result);
	}
	
	public void mineMineral(MapSpace ms){
		if(ms.hasMinerals()){
			if(!(inv.isFull())){
				Random r = new Random();
				int temp = r.nextInt(3);
				
				switch(temp){
					case 0:
						inv.putInNextEmptySlot(Item.TINORE);
						ms.depleteMineral();
						System.out.println("You mine a chunk of raw tin");
						break;
					case 1:
						inv.putInNextEmptySlot(Item.COPPERORE);
						ms.depleteMineral();
						System.out.println("You mine a chunk of raw copper");
						break;
					case 2:
						inv.putInNextEmptySlot(Item.IRONORE);
						ms.depleteMineral();
						System.out.println("You mine a chunk of raw iron");
						break;
				}
			}else{
				System.out.println("Your inventory is too full!");
			}
		}else{
			System.out.println("There are no minerals to mine!");
		}
	}
	
	public void chopTree(MapSpace ms){
		if(ms.hasTrees()){
			if(!(inv.isFull())){
				inv.putInNextEmptySlot(Item.LOG);
				ms.removeTree();
				System.out.println("You chop down the tree and collect a log");
				
			}else{
				System.out.println("Your inventory is too full!");
			}
		}else{
			System.out.println("There are no trees to chop!");
		}
	}
	
}
