package game;

import game.Location;
import game.Player;

public class Room extends Location {
	
	private static String directions[] = { "north", "east", "south", "west" };
	private String Brightness;
	private String torchDescription;
	private boolean canDigHere = false;


	/*
	 * konstruktorn
	 */

	public Room(String name, String description, String description2, String Brightness, String torchDescription) {
		super(name, description, description2);
		this.Brightness = Brightness;
		this.torchDescription = torchDescription;
	}

	/*
	 * går det att gräva här?
	 */

	public boolean possibleCommandDig() {
		if (this.canDigHere) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * beskriver platsen
	 */
	
	public void describeYourself(Player user) {
		if (user.isLit() && Brightness.equals("dark")) {
			if (getBeenhere()) {
				System.out.println(getDescription());
			} else {
				System.out.println(getDescription2());
			}
			System.out.println("The torch lights up the room. " + this.torchDescription);
		} else {
			if (getBeenhere()) {
				System.out.println(getDescription() + "Sight: " + Brightness);
			} else {
				System.out.println(getDescription2() + "Sight: " + Brightness);
			}
		}
		System.out.println("These items can be taken: ");
		for (int i = 0; i < user.getLoc().getLocItemList().size(); i++) {
			System.out.println(user.getLoc().getSpecLocItem(i).getItemName(getLocItemList().get(i)));
		}

		for (int i = 0; i < getPaths().length; i++) {
			if (getPaths()[i] != null) {
				System.out.println("There is a door leading " + directions[i]);
			}
		}

	}
}
