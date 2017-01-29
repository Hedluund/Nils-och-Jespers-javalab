package game;

public abstract class Items {
	private String name;
	private double weight;
	private int healthInc;

	
	public abstract boolean doCommand(String action, Player user);
	
	public Items(String name, double weight, int healthInc) {
		this.name = name;
		this.weight = weight;
	}
	
	public String getItemName(Items item) {
		return this.name;
	}
	
	public int getHealthDiff(){
		return this.healthInc;
	}
	
	
	
	public void printYourself() {
		System.out.println("You see: " + name);
		System.out.println("It weighs: " + weight);
	}
	
	
}
