package game;

import java.util.ArrayList;

public abstract class Location {

	private static String directions[] = { "north", "east", "south", "west" };
	private String name;
	private String description;
	private String description2;
	private Location[] paths = new Location[4];
	private ArrayList<Items> LocationItems = new ArrayList<Items>();
	private ArrayList<NPC> LocationNPC = new ArrayList<NPC>();
	private boolean notbeenhere = true;
	private boolean canDigHere;
	private boolean haveDugHere;
	private boolean NPCexist = false;

	/*
	 * konstruktorn
	 */

	public Location(String name, String description, String description2) {
		this.name = name;
		this.description = description;
		this.description2 = description2;
	}

	/*
	 * undersöker möjligheten att gräva här
	 */

	public abstract boolean possibleCommandDig();
	
	/*
	 * presentation av plats
	 */
	
	public abstract void describeYourself(Player user);

	/*
	 * setter för items på platsen
	 */

	public void setLocationItem(Items item) {
		this.LocationItems.add(item);
	}

	/*
	 * sätter en plats grannar
	 */

	public void setPaths(Location north, Location east, Location south, Location west) {
		this.paths[0] = north;
		this.paths[1] = east;
		this.paths[2] = south;
		this.paths[3] = west;
	}

	/*
	 * returnear grannarna
	 */

	public Location[] getPaths() {
		return paths;
	}

	/*
	 * Lägger till NPC på platsen
	 */

	public void setLocationNPC(NPC npc) {
		LocationNPC.add(npc);
	}

	/*
	 * returnar värde om det finns NPC på platsen
	 */

	public boolean doNPCexist() {
		return this.NPCexist;
	}

	/*
	 * undersöker om man kan gå åt ett visst håll
	 */

	public int checkPaths(String answer, Location location) {
		int i = 0;
		while (i < 4) {
			if (answer.equals(directions[i]) && location.paths[i] != null) {
				return i;
			}
			i++;
		}
		return 4;
	}

	/*
	 * returnerar nästa plats man går till
	 */
	public Location getNextloc(int pathNumber) {
		return this.paths[pathNumber];
	}

	/*
	 * anger att man grävt på platsen
	 */

	public void digHere() {
		haveDugHere = true;
	}

	/*
	 * anger om man har grävt på platsen
	 */

	public boolean haveIDugHere() {
		return this.haveDugHere;
	}

	/*
	 * anger om man kan gräva här från början
	 */

	public boolean canIDigHere() {
		return this.canDigHere;
	}

	/*
	 * sätter om man varit på platsen
	 */

	public void setBeenhere() {
		this.notbeenhere = false;
	}

	/*
	 * returnerar om man redan varit på platsen
	 */

	public boolean getBeenhere() {
		return notbeenhere;
	}

	/*
	 * hämtar platsens beskrivning för fallet där man inte varit där
	 */

	public String getDescription() {
		return description;
	}

	/*
	 * hämtar platsens beskrivning för fallet där man redan varit där
	 */

	public String getDescription2() {
		return description2;
	}

	/*
	 * skriver platsens namn
	 */

	public void getLocname() {
		System.out.println(name);
	}

	/*
	 * hämtar platsen namn
	 */

	public String getStringName() {
		return name;
	}

	/*
	 * tar bort ett item från platsen
	 */

	public void removeItemFromLoc(Items item) {
		this.LocationItems.remove(item);
	}

	/*
	 * hämtar platsens items
	 */

	public Items getLocationItems(String item) {
		for (int i = 0; i < LocationItems.size(); i++) {
			if (this.LocationItems.get(i).getItemName(LocationItems.get(i)).equals(item)) {
				return this.LocationItems.get(i);
			}
		}
		return null;
	}

	/*
	 * returnear om ett item existerar på platsen
	 */

	public boolean itemExist(String item) {
		for (int i = 0; i < LocationItems.size(); i++) {
			if (this.LocationItems.get(i).getItemName(getLocationItems(item)).equals(item)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * returnerar vilket nummer ett item har i listan
	 */

	public int itemNr(String item) {
		for (int i = 0; i < LocationItems.size(); i++) {
			if (this.LocationItems.get(i).getItemName(LocationItems.get(i)).equals(item)) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * returnear ett item
	 */
	
	public Items getItem(int i) {
		return this.LocationItems.get(i);
	}
	
	/*
	 * returnear NPC:erna på platsen
	 */
	
	public ArrayList<NPC> getNPC() {
		return LocationNPC;
	}	
	
	/*
	 * returnear items på platsen
	 */
	
	public ArrayList<Items> getLocItemList() {
		return this.LocationItems;
	}
	
	/*
	 * returnear ett specifikt item på platsen
	 */
	
	public Items getSpecLocItem(int i) {
		return this.LocationItems.get(i);
	}
	
	/*
	 * hantering av kommandon på platser
	 */
	
	public boolean doCommand(String command, Player spelare) {
		if (command.equals("help")) {
			System.out.println("These are the directions you can travel in: ");
			for (int i = 0; i < 4; i++) {
				if (this.paths[i] != null) {
					System.out.println(directions[i]);
				}
			}
			System.out.println("Other possible commands: \nitems\ngold\nhealth\nlook");
			System.out.println("wear + (youritem)  if you got any wearables");
			if (spelare.getLoc().possibleCommandDig()){
				System.out.println("dig");
			}
			System.out.println("If there is a monster and you want to kill it \ntype: kill and the name of your monster");
			System.out.println("To equip your weapon, type equip");
			return true;
			
		} else if (command.equals("look")) {
			describeYourself(spelare);
			return true;
		} else if (command.equals("dig") && spelare.getLoc().possibleCommandDig()) {
			if (spelare.getLoc().getStringName().equals("Forbidden Forest")) {
				System.out.println("You found a treasure, you found 13 goldcoins");
				spelare.getLoc().digHere();
				spelare.changeGold(13);
			} else if (spelare.getLoc().getStringName().equals("Mount Doom")) {
				System.out.println("Only a fool would try to dig in Mount Doom, you lost 1 health!");
				spelare.getLoc().digHere();
				spelare.changeHealth(-1);
			} else {
				System.out.println("You dug a hole,it's empty but you burned 666 calories. One hell of a workout");
				spelare.getLoc().digHere();
			}
			return true;
		} else {

			return false;
		}
	}

}
