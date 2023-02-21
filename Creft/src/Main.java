import java.util.ArrayList;
import java.util.Arrays;

import crafting.Recipe;
import crafting.RecipeManager;
import Game.Game;
import Item.Item;


public class Main {
	
	public static void main(String[] args) {
		//Window login = new Window(WindowType.LOGIN);
		//login.setVisible(true);
		
		Recipe stick = new Recipe(Item.STICK, 4, new ArrayList<Item>(Arrays.asList(Item.LOG)));
		RecipeManager.registerRecipe(stick);
		
		Recipe refinedCopper = new Recipe(Item.REFINEDCOPPER, 1, new ArrayList<Item>(Arrays.asList(Item.COPPERORE,Item.COPPERORE,Item.COPPERORE)));
		RecipeManager.registerRecipe(refinedCopper);
		
		Recipe refinedIron = new Recipe(Item.REFINEDIRON, 1, new ArrayList<Item>(Arrays.asList(Item.IRONORE,Item.IRONORE,Item.IRONORE)));
		RecipeManager.registerRecipe(refinedIron);
		
		Recipe copperShovel = new Recipe(Item.COPPERSHOVEL, 1, new ArrayList<Item>(Arrays.asList(Item.STICK,Item.STICK,Item.REFINEDCOPPER)));
		RecipeManager.registerRecipe(copperShovel);
		
		Recipe ironShovel = new Recipe(Item.IRONSHOVEL, 1, new ArrayList<Item>(Arrays.asList(Item.STICK,Item.STICK,Item.REFINEDIRON)));
		RecipeManager.registerRecipe(ironShovel);
		
		Recipe copperPickaxe = new Recipe(Item.COPPERPICKAXE, 1, new ArrayList<Item>(Arrays.asList(Item.STICK,Item.STICK,Item.REFINEDCOPPER,Item.REFINEDCOPPER,Item.REFINEDCOPPER)));
		RecipeManager.registerRecipe(copperPickaxe);
		
		Recipe ironPickaxe = new Recipe(Item.IRONPICKAXE, 1, new ArrayList<Item>(Arrays.asList(Item.STICK,Item.STICK,Item.REFINEDIRON,Item.REFINEDIRON,Item.REFINEDIRON)));
		RecipeManager.registerRecipe(ironPickaxe);
		
		new Game();
	}

}
