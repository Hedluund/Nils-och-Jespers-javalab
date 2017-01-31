package game;

public class Person extends NPC {
	private String phrase;
	private int gold;
	private Items NPCItem;

	/*
	 * konstruktorn
	 */

	public Person(String name, int health, Items item, int gold, String phrase) {
		super(name);
		this.phrase = phrase;
		this.gold = gold;
		this.NPCItem = item;
	}

	/*
	 * hanterar kommandon för platsen
	 */

	public boolean doCommand(String action, Player user) {
		if (action.equals("give gold")) {
			if (user.getGold() == 113) {
				user.changeGold(-113);
				user.setItem(this.NPCItem);
				System.out.println("Here you go, use this to defend NoJoria from its enemies. ");
				System.out.println("You recieved a piece of dragon_glass. If only you had a spear to use this on. ");
			} else {
				System.out.println(
						"Ohh, you don't have that much gold..? I have a gift for you if you can get me 113 gold coins");
			}
			return true;
		}
		return false;
	}

}
