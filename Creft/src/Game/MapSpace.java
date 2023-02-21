package Game;
import java.util.Random;


public class MapSpace {

	int trees;
	boolean underGround;
	int minerals;
	int depth;
	boolean discovered = false;
	boolean ascendable = false;
	
	public MapSpace(boolean dugInto, int depth){
		Random r = new Random();
		this.depth = depth;
		if(!underGround){
			trees = r.nextInt(3);
		}
		if(this.depth < 0){
			underGround = true;
		}else{
			underGround = false;
		}
		if(underGround){
			 minerals = r.nextInt(3);
		}
		if(dugInto && depth<0){
			ascendable = true;
		}
		//temp?
		discover();
		
		
	}
	
	public int getDepth(){
		return depth;
	}
	
	public void setAscendable(boolean arg){
		ascendable = arg;
	}

	public boolean isAscendable(){
		return ascendable;
	}
	
	public boolean hasMinerals(){
		if(minerals > 0){
			return true;
		}
		return false;
	}
	
	public boolean hasTrees(){
		if(trees > 0){
			return true;
		}
		return false;
	}
	
	public boolean isUnderGround(){
		return underGround;
	}
	
	public boolean isDiscovered(){
		return discovered;
	}
	
	public void depleteMineral(){
		minerals--;
	}
	
	public void removeTree(){
		trees--;
	}
	
	public void discover(){
		discovered = true;
		if(!underGround){
			System.out.print("You enter a");
			if(trees > 0){
				System.out.println(" wooded area");
			}else{
				System.out.println(" flat plain");
			}
		}else{
			System.out.print("You enter");
			Random r = new Random();
			int temp = r.nextInt(100);
			if(temp > 50){
				System.out.print(" a cave containing");
				if(minerals > 0){
					System.out.print(" "+minerals+" mineral deposit");
					if(minerals > 1){
						System.out.print("s");
					}
				}else{
					System.out.print(" no minerals");
				}
			}else if(temp < 10){
				System.out.print(" an underground lake");
			}else{
				System.out.print(" solid stone, with");
				if(minerals > 0){
					System.out.print(" "+minerals+" mineral deposit");
					if(minerals > 1){
						System.out.print("s");
					}
				}else{
					System.out.print(" no minerals in sight");
				}
			}
		}
		if(ascendable){
			System.out.print(" and a hole overhead");
		}
		System.out.println();
	}
	
	public void describe(){
		System.out.println("");
	}	
	
	//TODO
	public String description(){
		return "";
	}
}
