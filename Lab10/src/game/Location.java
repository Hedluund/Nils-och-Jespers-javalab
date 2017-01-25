package game;

public class Location {

	private String name;
	private String description;
	private String description2;
	private Location[] paths = new Location[4];
	private static String directions[] = { "north", "east", "south", "west" };
	private boolean notbeenhere = true;

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

	public void describeYourself() {
		if (this.notbeenhere) {
			System.out.println(this.description);
		} else {
			System.out.println(this.description2);
		}

		for (int i = 0; i < paths.length; i++) {
			if (paths[i] != null) {
				System.out.println("There is a path leading " + directions[i]);
			}
		}
	}
}
