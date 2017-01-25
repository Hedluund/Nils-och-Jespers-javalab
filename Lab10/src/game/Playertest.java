package game;
import game.Player;
import game.Location;

public class Playertest {
	public static Location Hell, heaven;
	public static Player adv;
	public static void main(String[] args){
		Hell= new Location("opiater");
	adv=new Player("Koksnisse");
	System.out.println(adv.getName());
	System.out.println(adv.getHealth());
	adv.changeHealth(6);
	System.out.println(adv.getHealth());
	adv.setLoc(Hell);
	adv.printLoc();
	
	
	
	}
}
