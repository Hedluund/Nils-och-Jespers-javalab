package game;
import game.Location;

public class Room extends Location {
	String Brightness;
	
	public Room(String name, String Brightness) {
		super(name);
		this.Brightness = Brightness;
	}
}
