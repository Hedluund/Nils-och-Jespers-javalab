package game;

import game.Player;

public class Wearables extends Items {
	
	/*
	 * konstruktorn
	 */

	public Wearables(String name, Double weight, int healthInc) {
		super(name, weight, healthInc);
	}
	
	/*
	 * hanterar kommandon f√∂r wearables
	 */

	public boolean doCommand(String action, Player user) {
		String[] Split = action.split("\\ ");
		if (Split[0].equals("wear")) {
			if (Split.length == 2) {
				if (Split[1].equals("elven_robe") && !user.isJacketOn()) {
					user.setJacket();
					System.out.println("You look faboulus in your new robe");
					user.changeHealth(user.getPlayerItems(Split[1]).getHealthDiff());
					return true;
				}
				else if (Split[1].equals("The_Ring") && !user.isRingOn()) {
					System.out.println("Ohhh the ring looks fabulous, but it¥s also a burden");
					user.setRing();
					user.changeHealth(user.getPlayerItems(Split[1]).getHealthDiff());
					return true;
				}
			}
		}

		return false;
	}
}

