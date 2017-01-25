package game;
import game.Location;

public class OutdoorsArea extends Location {
	private String weather;	
	
	public OutdoorsArea(String name, String weather) {
		super(name);
		this.weather=weather;
		
	}	
}
