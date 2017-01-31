package game;

public class Weapons extends Items {
	private int dmg;

	/*
	 * konstruktorn
	 */

	public Weapons(String name, double weight, int healthinc, int dmg) {
		super(name, weight, healthinc);
		this.dmg = dmg;
	}

	/*
	 * hämtar skadan ett vapen gör
	 */

	public int getWeapondmg() {
		return this.dmg;
	}

	/*
	 * hanterar kommandon kring vapen
	 */

	public boolean doCommand(String action, Player user) {
		String[] Split = action.split("\\ ");
		if (Split.length == 2 && Split[0].equals("equip") && user.itemExist(Split[1])) {
			user.setPlayerDmg(dmg);
			System.out.println("You can now use "
					+ user.getPlayerItems(Split[1]).getItemName(user.getPlayerItems(Split[1])) + " in battle.");
			return true;
		}
		return false;
	}

}
