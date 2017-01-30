package game;

public class Person extends NPC{
	private String phrase;
	
	public Person(String name, int health, Items item, String phrase) {
		super(name, health, item);
		this.phrase=phrase;
	}

}
