package game;

import game.Location;
import game.Player;

public class Room extends Location {
	private boolean canDigHere = false;
	private boolean haveDugHere = false;
	private String Brightness;
	private String torchDescription;
	private static String directions[] = { "north", "east", "south", "west" };

	public Room(String name, String description, String description2, String Brightness, String torchDescription) {
		super(name, description, description2);
		this.Brightness = Brightness;
		this.torchDescription=torchDescription;
	}
	public boolean possibleCommandDig(){
		if (this.canDigHere){
			return true;
		}else{
				return false;		
		}
	} 
	

	public void describeYourself(Player user) {
		if (user.isLit() && Brightness.equals("dark")) {
			System.out.println("The torch lights up the room. " + this.torchDescription);
		} else {
			if (getBeenhere()) {
				System.out.println(getDescription() + "Sight: " + Brightness);
			} else {
				System.out.println(getDescription2() + "Sight: " + Brightness);
			}
		}
		
		for (int i = 0; i < getPaths().length; i++) {
			if (getPaths()[i] != null) {
				System.out.println("There is a door leading " + directions[i]);
			}
		}

	}
}
