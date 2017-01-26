package game;
import game.Location;

public class OutdoorsArea extends Location {
	private String weather;

	public OutdoorsArea(String name, String description, String description2, String weather) {
		super(name, description, description2);
		this.weather=weather;

	public void describeYourself() {
		if (getBeenhere()) {
			System.out.println(this.description2);
		} else {
			System.out.println(this.description);
		}
		for (int i = 0; i < paths.length; i++) {
			if (paths[i] != null) {
				System.out.println("There is a road leading " + directions[i]);
			}
		}

	}
}
