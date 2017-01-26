package game;

import game.Player;

public class Wearables extends Items {

	private int healthInc;

	public Wearables(String name, Double weight, int healthInc) {
		super(name, weight);
		this.healthInc = healthInc;
	}

	public void doCommand(String action, String item) {
	}

	public void putOn(Player user, Wearables item) {
		user.setJacket(item);
		user.changeHealth(item.healthInc);
	}

}
