package game;

public abstract class NPC {
	
	private String name;
	
	public NPC(String name){
		this.name=name;
	}
	
	public String getNPCname() {
		return this.name;
	}
	
	public abstract boolean doCommand(String action, Player user);


}
