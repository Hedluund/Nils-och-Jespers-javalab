package game;

public class Monster extends NPC {
	private int dmg;
	
	public Monster(String name, int health, Items item, int dmg) {
		super(name, health, item);
		this.dmg=dmg;
	}

}
