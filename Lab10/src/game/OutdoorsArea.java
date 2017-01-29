package game;
import game.Location;

public class OutdoorsArea extends Location {
	private boolean canDigHere = true;
	private boolean haveDugHere = false;
	private String weather;
	private static String directions[] = { "north", "east", "south", "west" };

	public OutdoorsArea(String name, String description, String description2, String weather) {
		super(name, description, description2);
		this.weather=weather;
	}
	public boolean possibleCommandDig(){
		if (this.canDigHere && !this.haveDugHere){
			return true;
		}else{
				return false;		
		}
	}

	public void describeYourself() {
		if (getBeenhere()) {
			System.out.println(getDescription() + " Current weather: " + this.weather);
		} else {
			System.out.println(getDescription2() + " Current weather: " + this.weather);
		}
		for (int i = 0; i < getPaths().length; i++) {
			if (getPaths()[i] != null) {
				System.out.println("There is a road leading " + directions[i]);
			}
		}

	}
}
