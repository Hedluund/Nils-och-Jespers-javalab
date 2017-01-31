package game;

public abstract class NPC {
	
	private String name;
	
	/*
	 * Konstruktor
	 */
	
	public NPC(String name){
		this.name=name;
	}
	
	/*
	 * hämtar NPC:ns namn
	 */
	
	public String getNPCname() {
		return this.name;
	}
	
	/*
	 * kommandohanterare
	 */
	
	public abstract boolean doCommand(String action, Player user);


}
