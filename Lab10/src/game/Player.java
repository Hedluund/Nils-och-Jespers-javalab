package game;

import game.Location;
import java.util.ArrayList;
import game.Items;

public class Player {
	private String name;
	private int health = 10;
	private int Gold = 100;
	private int PlayerDmg = 0;
	private Boolean TorchLit = false;
	private boolean Jacket = false;
	private boolean dragon_glass = false;
	private boolean Ring = false;
	private ArrayList<Items> currentItems = new ArrayList<Items>();
	private Location currentlocation;

	
	/*
	 * konstruktorn
	 */

	public Player(String newName) {
		this.name = newName;
		Items shovel = new Tools("shovel", 10.0, 0);
		Items torch = new Tools("torch", 2.0, 0);
		currentItems.add(torch);
		currentItems.add(shovel);
	}
	
	/*
	 * returnerar ett specifik item hos spelaren
	 */
	
	public Items getPlayerItems(String item) {
		for (int i = 0; i < currentItems.size(); i++) {
			if (this.currentItems.get(i).getItemName(currentItems.get(i)).equals(item)) {
				return this.currentItems.get(i);
			}
		}
		return null;
	}
	
	/*
	 *  talar om om spelaren har ett item
	 */

	public boolean itemExist(String item) {
		for (int i = 0; i < currentItems.size(); i++) {
			if (this.currentItems.get(i).getItemName(currentItems.get(i)).equals(item)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * tänder facklan
	 */

	public void LightTorch(Boolean val) {
		this.TorchLit = val;
	}
	
	/*
	 * anger om man har dragonglass
	 */

	public boolean isDragonGlass() {
		return this.dragon_glass;
	}
	
	/*
	 * anger om facklan är tänd
	 */

	public boolean isLit() {
		return this.TorchLit;
	}
	
	/*
	 * sätter på sig en överdel
	 */

	public void setJacket() {
		this.Jacket = true;
	}
	
	/*
	 * anger om man har en överdel på sig
	 */

	public boolean isJacketOn() {
		return this.Jacket;
	}
	
	/*
	 * sätter spelarens damage
	 */

	public void setPlayerDmg(int dmg) {
		this.PlayerDmg = dmg;
	}
	
	/*
	 * sätter att man har dragonglass
	 */

	public void setDragonGlass() {
		this.dragon_glass = true;
	}
	
	/*
	 * sätter spelarens hälsa
	 */

	public void setHealth(int val) {
		this.health = val;
	}
	
	/*
	 * gettar spelarens dmg
	 */

	public int getPlayerDmg() {
		return this.PlayerDmg;
	}
	
	/*
	 * sätter på ringen på spelaren
	 */

	public void setRing() {
		this.Ring = true;
	}
	
	/*
	 * berättar om ringen är på
	 */

	public boolean isRingOn() {
		return this.Ring;
	}
	
	/*
	 * ändrar spelarens hälsa
	 */

	public void changeHealth(int difference) {
		this.health = this.health + difference;
		if (difference > 0) {
			System.out.println("Aah, your health rose");
		}
		if (health < 0) {
			health = 0;
		}
	}
	
	/*
	 * hämtar spelarens pengar
	 */

	public int getGold() {
		return this.Gold;
	}
	
	/*
	 * hämtar ett specifik item från spelaren
	 */

	public Items getCurrentItems(int i) {
		return currentItems.get(i);
	}
	
	/*
	 * hämtar längden på item-listan
	 */

	public int getListLength() {
		return currentItems.size();
	}
	
	/*
	 * lägger till ett item i item-listan
	 */

	public void setItem(Items item) {
		this.currentItems.add(item);
	}
	
	/*
	 * hämtar spelarens namn
	 */

	public String getName() {
		return this.name;
	}
	
	/*
	 * sätter ny plats till spelaren "går"
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
	 * returnar spelarens location
	 */

	public Location getLoc() {
		return this.currentlocation;
	}

	/*
	 * returnerar spelarnas hälsa
	 */

	public int getHealth() {
		return this.health;
	}

	/*
	 * vid ändring av guld
	 */
	public void changeGold(int change) {
		this.Gold = this.Gold + change;
	}

	public boolean doCommand(String command, Player spelare) {
		if (command.equals("items")) {
			System.out.println("These are your precious items: ");
			for (int i = 0; i < spelare.currentItems.size(); i++) {
				System.out.println(spelare.currentItems.get(i).getItemName(spelare.currentItems.get(i)));
			}
			return true;
		} else if (command.equals("gold")) {
			System.out.println("You have got " + spelare.getGold() + " gold!");
			System.out.println(PlayerDmg);
			return true;
		} else if (command.equals("health")) {
			System.out.println("Right now you have got " + spelare.getHealth() + " health");
			return true;
		} else if (command.equals("dmg")) {
			System.out.println(this.PlayerDmg);
			return true;
		} else if (command.contains("take")) {
			String[] Split = command.split("\\ ");
			if (Split.length == 2 && Split[0].equals("take") && spelare.getLoc().itemExist(Split[1])) {
				if (Split[1].equals("The_Ring")) {
					System.out.println("you have found The one and only ring in this game. Great job");
				} else if (Split[1].equals("elven_robe")) {
					System.out.println("You now own a robe");
				} else if (Split[1].equals("medic_kit")) {
					System.out.println("It is a medic kit, wohooooo o o");
				}

				spelare.currentItems.add(spelare.currentlocation.getItem(spelare.getLoc().itemNr(Split[1])));
				spelare.getLoc().removeItemFromLoc(spelare.getLoc().getItem(spelare.getLoc().itemNr(Split[1])));
				return true;
			}
			return false;
		} else {
			return false;
		}
	}

}
