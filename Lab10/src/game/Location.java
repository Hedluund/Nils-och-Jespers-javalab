package game;

public class Location {

	private String name;
	private String description;
	private String description2;
	private Location[] paths = new Location[4];
	private static String directions[] = { "north", "east", "south", "west" };
	private boolean beenhere = false;

	public Location(String name) {
		this.name = name;
	}
	
	public void setDescription(String description, String description2) {
		this.description = description;
		this.description2 = description2;
	}

	public void setPaths(Location north, Location east, Location south, Location west) {
		this.paths[0] = north;
		this.paths[1] = east;
		this.paths[2] = south;
		this.paths[3] = west;
	}
	public int checkPaths(String answer, Location location){
		int i = 0;
		while (i < 4){
			if (answer == directions[i] && location.paths[i]!=null){
			return i;
		}
		i++;
		}
		return 4;	
	}
	public Location getNextloc(int pathNumber){
		return this.paths[pathNumber];
	}
	
	public void setBeenhere(Boolean beenhere) {
		this.beenhere = beenhere;
	}
	
	public void getLocname() {
		System.out.println(name);
	}

	public void describeYourself() {
		if (this.beenhere) {
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
