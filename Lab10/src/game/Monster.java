package game;

public class Monster extends NPC {
	private int dmg;
	private int health;
	private int startHP;

	/*
	 * konstruktorn
	 */

	public Monster(String name, int health, int startHP, int dmg) {
		super(name);
		this.dmg = dmg;
		this.health = health;
	}

	/*
	 * returnerar monstrets hälsa
	 */

	public int getMonsterHealth() {
		return this.health;
	}

	/*
	 * hanterar kommandon kring monstret
	 */

	public boolean doCommand(String action, Player user) {
		String[] Split = action.split("\\ ");
		if (Split[0].equals("kill")) {
			if (user.getLoc().getNPC().size() > 0 && user.getLoc().getNPC().get(0).getNPCname().equals(Split[1])) {

				if (Split[1].equals("White_walker") && user.isDragonGlass() && user.getPlayerDmg() == 10) {
					this.health = 0;
					System.out.println("GRATTIS BROR, du räddade världen");
					return true;
				}

				this.health = this.health - user.getPlayerDmg();
				if (this.health > 0) {
					user.changeHealth(0 - this.dmg);
				}
				if (user.getHealth() > 0) {
					System.out.print(user.getLoc().getNPC().get(0).getNPCname() + " attacked. You have: ");
					System.out.print(user.getHealth());
					System.out.println(" hitpoints left");
				} else {
					System.out.println(
							"You ran away for your life, your health got really low.. You spend the night at the hospital");
					user.setHealth(10);
					this.health = this.startHP;
					return true;
				}

				if (this.health > 0) {
					System.out.print(user.getLoc().getNPC().get(0).getNPCname() + " have: ");
					System.out.print(this.health);
					System.out.println(" hitpoints left");
					return true;
				} else {
					System.out.print("You killed the ");
					System.out.println(user.getLoc().getNPC().get(0).getNPCname());
					user.getLoc().getNPC().remove(0);
					return true;
				}

			}
		}
		return false;
	}

}
