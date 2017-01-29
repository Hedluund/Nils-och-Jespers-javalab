package game;

import game.Player;

public class Wearables extends Items {

	public Wearables(String name, Double weight, int healthInc) {
		super(name, weight, healthInc);
	}

	public boolean doCommand(String action, Player user) {
		String[] Split = action.split("\\ ");
		if (Split[0].equals("wear")) {
			if (Split.length == 2) {
				if (Split[1].equals("elven_robe")) {
					user.setJacket();
					user.changeHealth(user.getPlayerWears(Split[1]).getHealthDiff());
					return true;
				}
				else if (Split[1].equals("The Ring")) {
					user.setRing();
					user.changeHealth(user.getPlayerWears(Split[1]).getHealthDiff());
					return true;
				}
			}
		}

		return false;
	}
}

