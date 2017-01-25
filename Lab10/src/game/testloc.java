package game;
import game.Location;

public class testloc {
	
	public static void main(String[] args) {
		
		Location Hell = new Location("Hell");
		Location Mount = new Location("Mount"); 
		
		Hell.setDescription("brinn", "hej");
		Hell.setPaths(Mount, null, Hell, null);
	
	
	Hell.describeYourself();
	
}
}