package crafting;

import java.util.ArrayList;

import Game.Player;
import Item.Item;

public class RecipeManager {
	
	private static ArrayList<Recipe> registry = new ArrayList<Recipe>();
	
	public static void registerRecipe(Recipe r){
		registry.add(r);
	}
	
	public static Recipe getRecipesFor(Item it){
		for(int i = 0; i < registry.size(); i++){
			if(registry.get(i).isRecipeFor(it)){
				return registry.get(i);
			}
		}
		return null;
	}
	
	public static void getAndPrintAllCraftableRecipes(Player p){
		for(int i = 0; i < registry.size(); i++){
			if(registry.get(i).doItemsMatchAnyRecipe(p.getItemsInInventory())){
				System.out.println(registry.get(i).getResult().getName()+"("+registry.get(i).getNumCreated()+")");
			}
		}
	}
	
	public static void tryCraft(String s, Player p) {
		for(int i = 0; i < registry.size(); i++){
			if(registry.get(i).getResult().getName().equals(s) ) {
				if(p.getItemsInInventory().containsAll(registry.get(i).getIngredients())){
					p.craftItem(registry.get(i).getResult(), registry.get(i).getIngredients());
				}
			}
		}
	}
}
