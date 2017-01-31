package game;

public abstract class Items {
	private String name;
	private double weight;
	private int healthInc;
	
	/*
	 * Konstruktor
	 */
	
	public Items(String name, double weight, int healthInc) {
		this.name = name;
		this.weight = weight;
		this.healthInc=healthInc;
	}
	
	/*
	 * kommandohanterare
	 */
	
	public abstract boolean doCommand(String action, Player user);
	
	/*
	 * hämtar namnet på ett item
	 */
	
	public String getItemName(Items item) {
		return this.name;
	}
	
	/*
	 * hämtar hur mycket ett item påverkar hälsan
	 */
	
	public int getHealthDiff(){
		return this.healthInc;
	}
	
	/*
	 * beskriver sig själv
	 */

	public void printYourself() {
		System.out.println("You see: " + name);
		System.out.println("It weighs: " + weight);
	}
	
	
}
