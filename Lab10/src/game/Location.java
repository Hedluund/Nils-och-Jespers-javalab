package game;

public class Location {
	
	private String name;
	private String description;
	private Location[] paths; 
	
	public Location(String name) {
		this.name = name;
	}
	
	public void introduceYourself() {
		System.out.println(description);
	}
	
	
			
	
	public void setLocation(Location north, Location east, Location south, Location west) {
		this.paths[0]=north;
		this.paths[1]=east;
		this.paths[2]=south;
		this.paths[3]=west;
	}
	
	
	
}
