package game;

import game.Location;

public class GameLocations {

	public Location[] setWorld() {
		Location[] World = new Location[5];

		Location Forest = new OutdoorsArea("Forbidden Forest",
				"You are now in the Forbidden Forest. The legend says that the trees in this forest get their strength from the suffering of the thousand men who have lost their lives here",
				"Welcome back to the Forbidden Forest, hmm, you get a really strange feeling that the trees seems to be talking",
				"Misty");

		Location Castle = new Room("Castle Black",
				"You are now at Castle Black, the utter defense of NoJoria against. Beyond the castle there are creatures that not even your wildest fantasy can picture. The men seems a bit frightenend but hopefully, Lord Commander Snow can found courage in them",
				"You are now at Castle Black. Lord Snow seems a bit worried about the loyalty of his men",
				"The castle is dark. Only a strim of light comes from candles");

		Location Hometown = new OutdoorsArea("Karakorum",
				"Welcome to the captial city of NoJoria, Karakorum. The great Khan Ghengis rules this city with an iron fist. You better watch your tounge!",
				"Welcome back to Karakorum. The city of the great Khan", "Sunny");

		Location Mountain = new OutdoorsArea("Mt.Doom",
				"You are standing at the root of Mt.Doom. Some maniacs state that this mountain will devastate the whole kingdom of NoJoria, what if they are right?.....KRASSHHH, BOOOOM!!! You better run, or at least protect yourself!!!",
				"You are back at Mt.Doom. The flying rocks may harm you", "Fog");

		Location Pub = new Room("MacLaren's Pub",
				"Welcome to MacLaren's Pub! Here you can enjoy our famous Cinnamon Bun. It will literary turn your world upside down",
				"You are back at MacLaren's Pub. Please, have a seat and enjoy something from the bar", "Light");

		Forest.setPaths(Castle, null, Mountain, Hometown);
		Castle.setPaths(null, Forest, Hometown, Pub);
		Hometown.setPaths(Castle, Forest, Mountain, Pub);
		Mountain.setPaths(Hometown, Forest, null, null);
		Pub.setPaths(Castle, Hometown, null, null);

		World[0] = Hometown;
		World[1] = Castle;
		World[2] = Forest;
		World[3] = Mountain;
		World[4] = Pub;

		return World;

	}

}
