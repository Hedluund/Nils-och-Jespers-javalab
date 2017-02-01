package game;

import game.Player;
import game.Location;
import game.Room;
import java.util.Scanner;
import java.util.ArrayList;

public class Maingame {
	static Scanner userInput = new Scanner(System.in);
	private Player MainUser;
	private ArrayList<Location> World = new ArrayList<Location>();
	
	/*
	 * konstruktorn
	 */
	
	public Maingame(){
		this.MainUser = createPlayer();
		this.World = setWorld();	
	}
	
	/*
	 * skapar spelaren
	 */
	
	public Player createPlayer(){
		System.out.print("Please state your name!");
		Scanner userInput = new Scanner(System.in);
		Player User = new Player(userInput.nextLine());
		System.out.println("Hello " + User.getName()
				+ "!Welcome to the world of NoJoria #<3/3?# Full of both scary creatures and wonderful places...");
		return User;

	}
	
	/*
	 * skapar världen
	 */

	public ArrayList<Location> setWorld() {

		Location Forest = new OutdoorsArea("Forbidden Forest",
				"You are now in the Forbidden Forest. "
				+ "The legend says that the trees in this forest get their strength from the suffering of the thousand men who have lost their lives here",
				"Welcome back to the Forbidden Forest, hmm, you get a really strange feeling that the trees seems to be talking. ",
				"Misty");

		Location Castle = new Room("Castle Black",
				"You are now at Castle Black, the utter defense of NoJoria. "
				+ "Beyond the castle there are creatures that not even your wildest fantasy can picture. "
				+ "The men seems a bit frightenend but hopefully, Lord Commander Snow can found courage in them. ",
				"You are now at Castle Black. Lord Snow seems a bit worried about the loyalty of his men. ",
				"dark", "The light attracts the attention of a White_walker and the men panics. "
						+ "One of them manages to cut it but it didn't have any effect at all."
						+ " Maybe you need som kind of special weapon?");

		Location Hometown = new OutdoorsArea("Karakorum",
				"Welcome to the captial city of NoJoria, Karakorum. "
				+ "The great Khan Ghengis rules this city with an iron fist. You better watch your tounge!",
				"Welcome back to Karakorum. The city of the great Khan", "Sunny");

		Location Mountain = new OutdoorsArea("Mount Doom",
				"You are standing at the root of Mount Doom. Some maniacs state that this mountain will devastate the whole kingdom of NoJoria, what if they are right?...../nKRASSHHH, BOOOOM!!! You better run, or at least protect yourself!!!",
				"You are back at Mt.Doom. The flying rocks may harm you", "Fog");

		Location Pub = new Room("MacLaren's Pub",
				"Welcome to MacLaren's Pub! There is a beggar in the corner. He looks like he needs 113 gold coins. ",
				"You are back at MacLaren's Pub. The beggar in the corner is in at great need of 113 gold coins. ", "Light", null);
		
		Items elven_robe = new Wearables("elven_robe", 10.0, 5);
		Items medic_kit = new Tools("medic_kit", 1.0, 2);
		Items Ring = new Wearables("The_Ring", 0.5, 0);
		Items Spear = new Weapons("Hunting_Spear", 10.0, 0, 10);
		Items dragon_glass = new Tools("dragon_glass", 0.0, 0);
		
		NPC beggar = new Person("beggar", 2, dragon_glass, 0, "Pleeease, some money for the poor one");
		NPC Boar = new Monster("Boar", 20, 20, 3);
		NPC WhiteWalker = new Monster("White_walker", 500, 500, 1000);

		Forest.setPaths(Castle, null, Mountain, Hometown);
		Castle.setPaths(null, Forest, Hometown, Pub);
		Hometown.setPaths(Castle, Forest, Mountain, Pub);
		Mountain.setPaths(Hometown, Forest, null, null);
		Pub.setPaths(Castle, Hometown, null, null);
		
		Forest.setLocationItem(elven_robe);
		Forest.setLocationItem(medic_kit);
		Mountain.setLocationItem(Ring);
		Mountain.setLocationItem(Spear);
		
		Forest.setLocationNPC(Boar);
		Pub.setLocationNPC(beggar);
		Castle.setLocationNPC(WhiteWalker);

		World.add(Hometown);
		World.add(Castle);
		World.add(Forest);
		World.add(Pub);
		World.add(Mountain);

		return World;

	}	
	
	
	/*
	 * sätter spelarens startposition
	 */

	public void setStartLoc(Player User,Location Start){
		User.setLoc(Start);
	}
	
	/*
	 * hanterar användarens kommandon
	 */

	public boolean whatToDo(Player User){	
		String command = userInput.nextLine();
		boolean LocCom = new Boolean(false);
		User.getLoc().doCommand(command, User);
		LocCom=User.doCommand(command, User);
		if(User.getLoc().getNPC().size() > 0){
			LocCom=User.getLoc().getNPC().get(0).doCommand(command, User);
		}
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

		
	/*
	 * kör spelet
	 */

	private void Run(Maingame gamefield) {
		String command = "start";
		while (!command.equals("exit")) {
			gamefield.MainUser.getLoc().describeYourself(gamefield.MainUser);
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
	
	/*
	 * huvudmetoden
	 */

	public static void main(String[] args) {
		Maingame spelet = new Maingame();
		spelet.setStartLoc(spelet.MainUser, spelet.World.get(0));
		spelet.Run(spelet);
	}
}

