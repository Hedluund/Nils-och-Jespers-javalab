package game;

public class Tools extends Items {

	/*
	 * Konstruktor
	 */

	public Tools(String name, Double weight, int healthInc) {
		super(name, weight, healthInc);
	}

	/*
	 * hanterar kommandon för spelaren
	 */

	public boolean doCommand(String action, Player user) {
		String[] Split = action.split("\\ ");
		if (action.equals("light torch") && !user.isLit()) {
			user.LightTorch(true);
			System.out.println("You lit your torch, you can now see at castle black");
			return true;
		}

		else if (Split[0].equals("use") && user.itemExist(Split[1])) {
			user.changeHealth(user.getPlayerItems(Split[1]).getHealthDiff());
			if (Split[1].equals("dragon_glass") && user.itemExist("Hunting_Spear")) {
				user.setDragonGlass();
				System.out.println("Your spear breathes power.");
			}
			return true;
		}

		return false;
	}

}
