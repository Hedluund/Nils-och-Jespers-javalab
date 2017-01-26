package game;

import game.Player;
import game.Location;
import java.util.Scanner;

public class Maingame {
	private Player MainUser ;
	private Location[] World =new Location[4];
	
	
	public Player createPlayer(){
		System.out.print("Please state your name!");
		Scanner userInput= new Scanner(System.in);	
		Player User=new Player(userInput.nextLine());
		System.out.println("Hello " + User.getName()+"!Welcome to the world of NoJoria #<3/3?# Full of both scary creatures and wonderful places...");
		return User;
		
	} 	
	
	public Maingame(){
		this.MainUser = createPlayer();
		//createWorld();
	
	}

	//public Player getPlayer()
	
	public void walkToOther(Player User){
		System.out.print("So where do you want to go next?");
		Scanner userInput = new Scanner(System.in);
		int checker=User.getLoc().checkPaths(userInput.nextLine(),User.getLoc());
		while (checker==4){
			System.out.println("Sorry, thats not a valid command. Try again. you can always use the help command!");
			checker=User.getLoc().checkPaths(userInput.nextLine(),User.getLoc());
		}
		User.setLoc(User.getLoc().getNextloc(checker));	
	}
	
	
	public void Run(Player User){
		User.getLoc().describeYourself();
		walkToOther(User);
		
		
	}
	
}
