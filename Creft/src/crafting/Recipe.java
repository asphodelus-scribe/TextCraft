package crafting;

import java.util.ArrayList;

import Item.Item;

public class Recipe {

	Item result;
	ArrayList<Item> ingredients;
	int numCreated;
	
	public Recipe(Item result, int numCreated, ArrayList<Item> ingr){
		this.result = result;
		this.numCreated = numCreated;
		ingredients = ingr;
	}
	
	public Item getResult(){
		return result;
	}
	
	public int getNumCreated(){
		return numCreated;
	}
	
	public ArrayList<Item> getIngredients(){
		return ingredients;
	}
	
	public boolean doItemsMatchAnyRecipe(ArrayList<Item> it){
		if(it.containsAll(ingredients)){
			return true;
		}
		/**
		for(int i = 0; i < ingredients.size(); i++){
			if(it.containsAll(ingredients.get(i))){
				return true;
			}
		}
		*/
		return false;
	}
	
	public boolean isRecipeFor(Item i){
		if(i.equals(result)){
			return true;
		}else{
			return false;
		}
	}
	
}
