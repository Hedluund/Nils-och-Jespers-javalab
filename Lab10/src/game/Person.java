package game;

public class Person extends NPC {
	private String phrase;
	private int gold;
	private Items NPCItems;

	public Person(String name, int health, Items item, int gold, String phrase) {
		super(name);
		this.phrase = phrase;
		this.gold = gold;
		this.NPCItems = item;
	}

	public boolean doCommand(String action, Player user) {
		return true;
	}

}
