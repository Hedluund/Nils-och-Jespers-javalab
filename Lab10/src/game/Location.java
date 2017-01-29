package game;
import java.util.ArrayList;

public abstract class Location {

	private String name;
	private String description;
	private String description2;
	private Location[] paths = new Location[4];
	private static String directions[] = { "north", "east", "south", "west" };
	private ArrayList<String> LocationCommands = new ArrayList<String>();
	private ArrayList<Items> LocationItems = new ArrayList<Items>();
	private boolean beenhere = true;
	private boolean canDigHere;
	private boolean haveDugHere;
	
	public abstract boolean possibleCommandDig();
	
	
	public Location(String name, String description, String description2) {
		this.name = name;
		this.description = description;
		this.description2 = description2;
	}
	

	public void setPaths(Location north, Location east, Location south, Location west) {
		this.paths[0] = north;
		this.paths[1] = east;
		this.paths[2] = south;
		this.paths[3] = west;
	}
	
	
	public Location[] getPaths() {
		return paths;
	}
	
	public int checkPaths(String answer, Location location){
		int i = 0;
		while (i < 4){
			if (answer.equals(directions[i]) && location.paths[i]!=null){
			return i;
		}
			i++;
		}
		return 4;	
	}
	public Location getNextloc(int pathNumber){
		return this.paths[pathNumber];
	}
	
	public void digHere() {
		this.haveDugHere=true;
	}
	
	public boolean haveIDugHere() {
		return this.haveDugHere;
	}
	
	public boolean canIDigHere() {
		return this.canDigHere;
	}
	
	public void setBeenhere() {
		this.beenhere = false;
	}
	
	public boolean getBeenhere(){
		return beenhere;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getDescription2() {
		return description2;
	}
	
	public void getLocname() {
		System.out.println(name);
	}
	
	
	public boolean doCommand(String command, Player spelare){
		if (command.equals("help")){
			System.out.println("These are the directions you can travel in: ");
			for (int i =0;i<4;i++){
				if (this.paths[i]!=null){
					System.out.println(directions[i]);
				}
			}
			System.out.println("Other possible commands: ");
			System.out.println("items");
			if (spelare.getLoc().possibleCommandDig()){
				System.out.println("dig");
			}
			return true;
		}else if (command.equals("look")) {
			System.out.println(this.description);
			return true;
		}else if (command.equals("dig") && spelare.getLoc().possibleCommandDig()){
			System.out.println("Du �r en gr�vling");
			spelare.getLoc().digHere();
			return true;
		}
		return false;
	}
	public void describeYourself() {
		if (this.beenhere !=true) {
			System.out.println(this.description2);
		} else {
			System.out.println(this.description);
		}

		for (int i = 0; i < paths.length; i++) {
			if (paths[i] != null) {
				System.out.println("There is a path leading " + directions[i]);
			}
		}
	}
}
