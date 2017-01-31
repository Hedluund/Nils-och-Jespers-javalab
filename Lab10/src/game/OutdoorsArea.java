package game;
import game.Location;

public class OutdoorsArea extends Location {
	
	private static String directions[] = { "north", "east", "south", "west" };
	private String weather;
	private boolean canDigHere = true;
	private boolean haveDugHere = false;
	
	/*
	 * konstruktorn
	 */
	
	public OutdoorsArea(String name, String description, String description2, String weather) {
		super(name, description, description2);
		this.weather=weather;
	}
	
	/*
	 * undersöker möjligheten att gräva
	 */
	
	public boolean possibleCommandDig(){
		if (this.canDigHere && !this.haveDugHere){
			return true;
		}else{
				return false;		
		}
	}
	
	/*
	 * gräver på platsen
	 */
	
	public void digHere() {
		this.haveDugHere=true;
	}
	
	/*
	 * beskriver sig själv
	 */

	public void describeYourself(Player user) {
		if (getBeenhere()) {
			System.out.println(getDescription() + " Current weather: " + this.weather);
		} else {
			System.out.println(getDescription2() + " Current weather: " + this.weather);
		}
		
		if (user.getLoc().getNPC().size() > 0){
		if(user.getLoc().getNPC().get(0).getNPCname().equals("Boar")){
		System.out.println("It is a huge Boar guarding some necessary equipment, hope you have something to kill it with.");
	
		}
		
		}else{
			System.out.println("These items can be taken: "); 
		for(int i=0;i< user.getLoc().getLocItemList().size();i++){
			System.out.println(user.getLoc().getSpecLocItem(i).getItemName(getLocItemList().get(i)));				
		}
		}
		
		for (int i = 0; i < getPaths().length; i++) {
			if (getPaths()[i] != null) {
				System.out.println("There is a road leading " + directions[i]);
			}
		}

	}
}
