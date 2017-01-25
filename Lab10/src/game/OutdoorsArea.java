package game;
import game.Location;

public class OutdoorsArea extends Location {
	private String weather;	
	
	public OutdoorsArea(String name, String description, String description2, String weather) {
		super(name, description, description2);
		this.weather=weather;
		
	}	
}
