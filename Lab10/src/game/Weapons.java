package game;

public class Weapons extends Items {
	private int dmg;
	
	public Weapons(String name, double weight, int healthinc, int dmg){
		super(name, weight, healthinc);
		this.dmg=dmg;
	}
	
	public boolean doCommand(String action, Player user) {
		String[] Split = action.split("\\ ");
		if (Split.length==2 && Split[0].equals("equip") && user.itemExist(Split[1])) {
			user.setPlayerDmg(this.dmg);
			return true;
		}
		return false;
	}

}
