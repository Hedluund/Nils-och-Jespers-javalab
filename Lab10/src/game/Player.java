package game;

public class Player {
	private String name;
	private int health=10;
	private Location currentlocation;
	
	public Player(String newName){
		this.name=newName;
	}
	public String getName(){
		return this.name;	
	}
	public void changeHealth(int dmg){
		this.health= this.health+dmg;
		if (health<0) {
			health=0;
		}
	public void setLoc(Location newLocation){
		This.Location=newLocation;	
	}
	
	}

}
