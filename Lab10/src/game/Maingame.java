package game;

import game.Player;
import game.Location;
import java.util.Scanner;
import java.util.ArrayList;

public class Maingame {
	private Player MainUser;
	static Scanner userInput = new Scanner(System.in);
	private ArrayList<Location> World = new ArrayList<Location>();
	

	public Maingame(){
		this.MainUser = createPlayer();
		this.World = setWorld();	
	}
	
	public Player createPlayer(){
		System.out.print("Please state your name!");
		Scanner userInput = new Scanner(System.in);
		Player User = new Player(userInput.nextLine());
		System.out.println("Hello " + User.getName()
				+ "!Welcome to the world of NoJoria #<3/3?# Full of both scary creatures and wonderful places...");
		return User;

	}

	public ArrayList<Location> setWorld() {

		Location Forest = new OutdoorsArea("Forbidden Forest",
				"You are now in the Forbidden Forest. The legend says that the trees in this forest get their strength from the suffering of the thousand men who have lost their lives here",
				"Welcome back to the Forbidden Forest, hmm, you get a really strange feeling that the trees seems to be talking. ",
				"Misty");

		Location Castle = new Room("Castle Black",
				"You are now at Castle Black, the utter defense of NoJoria. Beyond the castle there are creatures that not even your wildest fantasy can picture. The men seems a bit frightenend but hopefully, Lord Commander Snow can found courage in them. ",
				"You are now at Castle Black. Lord Snow seems a bit worried about the loyalty of his men. ",
				"The castle is very dark. ");

		Location Hometown = new OutdoorsArea("Karakorum",
				"Welcome to the captial city of NoJoria, Karakorum. The great Khan Ghengis rules this city with an iron fist. You better watch your tounge!",
				"Welcome back to Karakorum. The city of the great Khan", "Sunny");

		Location Mountain = new OutdoorsArea("Mount Doom",
				"You are standing at the root of Mount Doom. Some maniacs state that this mountain will devastate the whole kingdom of NoJoria, what if they are right?.....KRASSHHH, BOOOOM!!! You better run, or at least protect yourself!!!",
				"You are back at Mt.Doom. The flying rocks may harm you", "Fog");

		Location Pub = new Room("MacLaren's Pub",
				"Welcome to MacLaren's Pub! Here you can enjoy our famous Cinnamon Bun. It will literary turn your world upside down",
				"You are back at MacLaren's Pub. Please, have a seat and enjoy something from the bar", "Light");
		
		Items elven_robe = new Wearables("elven_robe", 10.0, 5);
		Items medic_kit = new Tools("medic_kit", 1.0, 5);
		Items Ring = new Wearables("The Ring", 0.5, 0);

		Forest.setPaths(Castle, null, Mountain, Hometown);
		Castle.setPaths(null, Forest, Hometown, Pub);
		Hometown.setPaths(Castle, Forest, Mountain, Pub);
		Mountain.setPaths(Hometown, Forest, null, null);
		Pub.setPaths(Castle, Hometown, null, null);
		
		Forest.setLocationItem(elven_robe);
		Castle.setLocationItem(medic_kit);
		Mountain.setLocationItem(Ring);

		World.add(Hometown);
		World.add(Castle);
		World.add(Forest);
		World.add(Pub);
		World.add(Mountain);

		return World;

	}	
	/*
	 * konstruktorn
	 */
	

	public void setStartLoc(Player User,Location Start){
		User.setLoc(Start);
	}

	public boolean whatToDo(Player User){	
		String command = userInput.nextLine();
		boolean LocCom = User.getLoc().doCommand(command, User);
		LocCom=User.doCommand(command, User);
		boolean itemUsed=false;
		int i = 0;
		while(!itemUsed && i<User.getListLength()){
		itemUsed=User.getCurrentItems(i).doCommand(command, User);
		i++;
		}
		int checker = User.getLoc().checkPaths(command,User.getLoc());
		if (checker!=4 && !LocCom){
			User.getLoc().setBeenhere();
			User.setLoc(User.getLoc().getNextloc(checker));	
			return true;
		}

		return false;
	}

		


	// public Player getPlayer()

	private void Run(Maingame gamefield) {
		String command = "hej";
		while (!command.equals("exit")) {
			gamefield.MainUser.getLoc().describeYourself();
			System.out.println("What do you want to do?");
			boolean check = false;
			while (!check) {
				check = whatToDo(gamefield.MainUser);
				if (!check) {
					System.out.println("What do you want to do?");
				}
			}
		}

	}

	public static void main(String[] args) {
		Maingame spelet = new Maingame();
		spelet.setStartLoc(spelet.MainUser, spelet.World.get(0));
		spelet.Run(spelet);
	}
}

