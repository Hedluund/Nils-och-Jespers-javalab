package game;

import game.Location;

public class Room extends Location {
	private boolean canDigHere = false;
	String Brightness;
	private static String directions[] = { "north", "east", "south", "west" };

	public Room(String name, String description, String description2, String Brightness ) {
		super(name, description, description2);
		this.Brightness = Brightness;
	}

	public void describeYourself() {
		if (getBeenhere()) {
			System.out.println(getDescription() + "Sight: " + Brightness);
		} else {
			System.out.println(getDescription2() + "Sight: " + Brightness);
		}
		for (int i = 0; i < getPaths().length; i++) {
			if (getPaths()[i] != null) {
				System.out.println("There is a door leading " + directions[i]);
			}
		}

	}
}
