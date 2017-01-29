package game;

import game.Player;

public class Wearables extends Items {

	private int healthInc;

	public Wearables(String name, Double weight, int healthInc) {
		super(name, weight);
		this.healthInc = healthInc;
	}
	
	public void putOn(Player user) {
		user.setWearable(this);
		user.changeHealth(this.healthInc);
	}
	
	public void doCommand(String action, Player user) {			
		}
	}

