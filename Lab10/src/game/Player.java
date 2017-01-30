package game;

import game.Location;
import java.util.ArrayList;
import game.Items;

public class Player {
	private String name;
	private int health = 10;
	private Location currentlocation;
	private int Gold = 100;
	private boolean Jacket=false;
	private boolean Ring=false;
	private ArrayList<Items> currentItems = new ArrayList<Items>();
	private Boolean TorchLit=false;

	public Player(String newName) {
		this.name = newName;
		Items shovel = new Tools("shovel", 10.0, 0);
		Items torch = new Tools("torch", 2.0, 0);
		currentItems.add(torch);
		currentItems.add(shovel);
	}
	
	 public Items getPlayerItems(String item){
		for(int i =0; i < currentItems.size(); i++) {
			if (this.currentItems.get(i).getItemName(currentItems.get(i)).equals(item)) {
				return this.currentItems.get(i);
			}
		} 
		return null;
	}
	 
	 public boolean itemExist(String item){
			for(int i =0; i < currentItems.size(); i++) {
				if (this.currentItems.get(i).getItemName(currentItems.get(i)).equals(item)) {
					return true;
				}
			} 
			return false;
		}
	 
	
	public void LightTorch(Boolean val) {
		this.TorchLit = val;
	}

	public boolean isLit() {
		return this.TorchLit;
	}

	public void setJacket() {
		this.Jacket = true;
		}
	
	public boolean isJacketOn() {
		return this.Jacket;
	}

	public void setRing() {
		this.Ring = true;
	}
	
	public boolean isRingOn() {
		return this.Ring;
	}
	 
	/*
	 * �ndrar heatlh
	 * 
	 */
	public void changeHealth(int difference) {
		this.health = this.health + difference;
		if (health < 0) {
			health = 0;
		}
	}
	public int getGold(){
		return this.Gold;
	}
	
	public Items getCurrentItems(int i){
		return currentItems.get(i);
	}
	
	public int getListLength() {
		return currentItems.size();
	}
	

	public String getName() {
		return this.name;
	}

	/*
	 * �ndrar spelarens location
	 */
	public void setLoc(Location newLocation) {
		this.currentlocation = newLocation;
	}
	

	/*
	 * skriver ut spelarens location
	 */
	public void printLoc() {
		Location Test = this.currentlocation;
		Test.getLocname();
	}

	/*
	 * returnar spelarens
	 */
	public Location getLoc() {
		return this.currentlocation;
	}

	/*
	 * 
	 */

	
	public int getHealth() {
		return this.health;
	}
	
	

	/*
	 * vid �ndring av guld. ex r�n eller shopping
	 */
	public void changeGold(int change) {
		this.Gold = this.Gold + change;	
	}
	public boolean doCommand(String command,Player spelare){
		if (command.equals("items")){
			System.out.println("These are your precious items: ");
			for(int i=0;i<spelare.currentItems.size();i++){
				System.out.println(spelare.currentItems.get(i).getItemName(spelare.currentItems.get(i)));				
			}
			return true;
			}else if (command.equals("gold")){
				System.out.println("You have got " + spelare.getGold() + " gold!");
				return true;			
			}else if(command.equals("health")){
				System.out.println("Right now you have got " + spelare.getHealth()+" health");
				return true;
			}else if(command.contains("take")){
				String[] Split = command.split("\\ ");
				if (Split.length==2 && Split[0].equals("take") && spelare.getLoc().itemExist(Split[1])){
					if (Split[1].equals("The_Ring")){
						System.out.println("you have found The one and only ring in this game. Great job");
					}else if(Split[1].equals("elven_robe")){
						System.out.println("You now own a robe");
					}else if(Split[1].equals("medic_kit")){
						System.out.println("It is a medic kit, wohooooo o o");
					}
					spelare.currentItems.add(spelare.currentlocation.getItem());
					spelare.getLoc().removeItemFromLoc();
					return true;				
				}
				return false;
		}else{
			return false;
	}
	}

}


