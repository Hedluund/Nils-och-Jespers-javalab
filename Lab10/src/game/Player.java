package game;

import game.Location;

public class Player {
	private String name;
	private int health = 10;
	private Location currentlocation;
	private int Gold = 100;

	public Player(String newName) {
		this.name = newName;
	}

	public String getName() {
		return this.name;
	}

	/*
	 * �ndrar heatlh
	 * 
	 */
	public void changeHealth(int dmg) {
		this.health = this.health + dmg;
		if (health < 0) {
			health = 0;
		}
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

}


