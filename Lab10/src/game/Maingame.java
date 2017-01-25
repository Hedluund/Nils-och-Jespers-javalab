package game;

import game.Player;
import game.Location;
import java.util.Scanner;

public class Maingame {
	
	public Maingame(){
		createPlayer();
		//createWorld();
	
	}
	
	public void createPlayer(){
		System.out.print("Vad vill du att din spelare ska heta?");
		Scanner userInput= new Scanner(System.in);
		
		Player User=new Player(userInput.nextLine());
		
	} 
}
