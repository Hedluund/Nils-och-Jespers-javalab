package game;

public abstract class Items {
	private String name;
	private double weight;

	
	public abstract boolean doCommand(String action, Player user);
	
	public Items(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public String getItemName(Items item) {
		return this.name;
	}
	
	
	public void printYourself() {
		System.out.println("You see: " + name);
		System.out.println("It weighs: " + weight);
	}
	
	
}
