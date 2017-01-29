package game;

import game.Location;
import java.util.ArrayList;
import game.Items;

public class Player {
	private String name;
	private int health = 10;
	private Location currentlocation;
	private int Gold = 100;
	private boolean Jacket;
	private boolean Ring;
	private ArrayList<Items> currentItems = new ArrayList<Items>();
	private Boolean TorchLit;

	public Player(String newName) {
		this.name = newName;
	}
	

	 public Items getPlayerWears(String item){
		for(int i =0; i < currentItems.size(); i++) {
			if (this.currentItems.get(i).getItemName(currentItems.get(i)).equals(item)) {
				return this.currentItems.get(i);
			}
		} 
		return null;
	}
	 
	
	public void LightTorch() {
		this.TorchLit = true;
	}
	
	public void setJacket() {
		this.Jacket=true;
	}
	
	public void setRing() {
		this.Ring=true;
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
	public Items getItem(){
		Items testitem = new Tools("spaden",23.0, 0);
		return testitem;
	}
	public int getHealth() {
		return this.health;
	}

	/*
	 * vid �ndring av guld. ex r�n eller shopping
	 */
	public void changeGold(int change) {
		this.Gold = this.Gold + change;
		
	}
	public void doCommand(String command,Player spelare){
		if (command.equals("items")){
			System.out.print("These are your precious items: ");
			for(int i=0;i<spelare.currentItems.size();i++){
				System.out.println(spelare.currentItems.get(i).getItemName(spelare.currentItems.get(i)));				
			}
	
		}
	}
	

}


