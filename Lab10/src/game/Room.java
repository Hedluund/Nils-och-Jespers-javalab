package game;
import game.Location;

public class Room extends Location {
	String Brightness;
	
	public Room(String name, String description, String description2, String Brightness ) {
		super(name, description, description2);
		this.Brightness = Brightness;
	}
}
