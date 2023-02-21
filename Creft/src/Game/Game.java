package Game;
import java.util.Scanner;

import crafting.RecipeManager;
import Item.*;


public class Game {

	boolean inputOpen = false;
	Player p;
	MapSpace current;
	int curDepth;
	Scanner s;
	
	public Game(){
		p = new Player();
		s = new Scanner(System.in);
		current = new MapSpace(false, 0);
		curDepth = 0;
		openInput();
	}
	
	public void openInput(){
		inputOpen = true;
		String temp;
		while(inputOpen){
			temp = s.nextLine();
			switch(temp){
				case "":
					System.out.println("Please enter a command");
					break;
				case "mine":
					p.mineMineral(current);
					break;
				case "walk":
					walk();
					break;
				case "inventory":
					p.printInventory();
					break;
				case "dig":
					dig();
					break;
				case "quit":
					inputOpen = false;
					break;
				case "ascend":
					ascend();
					break;
				case "chop":
					p.chopTree(current);
					break;
				case "dig up":
					dig(Direction.UP);
					break;
				case "dig down":
					dig(Direction.DOWN);
					break;
				case "depth":
					System.out.println(current.getDepth());
					break;
				case "craft":
					showCraftingMenu();
					break;
			}
		}
	}
	
	private void walk(){
		current = new MapSpace(false, curDepth);	
	}
	
	private void dig(){
		//TODO smart sense available directions
		String temp;
		System.out.println("Dig which direction: up, down, north, south, east, west");
		temp = s.nextLine();
		switch(temp){
			case "up":
				dig(Direction.UP);
				break;
			case "down":
				dig(Direction.DOWN);
				break;
			case "north":
				dig(Direction.NORTH);
				break;
			case "south":
				dig(Direction.SOUTH);
				break;
			case "east":
				dig(Direction.EAST);
				break;
			case "west":
				dig(Direction.WEST);
				break;
		}
	}
	
	private void dig(Direction d){
		if(d == Direction.DOWN){
			current = new MapSpace(true,curDepth-1);
			curDepth = current.getDepth();
		}else if(d == Direction.UP){
			if(current.getDepth() < 0){
				current = new MapSpace(true,curDepth+1);
				curDepth = current.getDepth();
			}else{
				System.out.println("Can't dig up here!");
			}
		}
	}
	
	private void ascend(){
		if(current.isAscendable()){
			current = new MapSpace(false, curDepth+1);
			curDepth = current.getDepth();
		}else{
			System.out.println("Cannot ascend!");
		}
	}
	
	public void showCraftingMenu(){
		String temp;
		p.printInventory();
		System.out.println();
		System.out.println("Crafting:");
		RecipeManager.getAndPrintAllCraftableRecipes(p);
		temp = s.nextLine();
		RecipeManager.tryCraft(temp, p);
		System.out.println("Dig which direction: up, down, north, south, east, west");
		
	}
}
