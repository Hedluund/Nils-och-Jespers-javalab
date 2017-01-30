package game;

public class Tools extends Items {

	public Tools(String name, Double weight, int healthInc) {
		super(name, weight, healthInc);
	}

	public boolean doCommand(String action, Player user) {
		String[] Split = action.split("\\ ");
		if (action.equals("light torch") && !user.isLit()) {
			user.LightTorch(true);
			return true;
		}
		
		else if (Split[0].equals("use") && user.itemExist(Split[1])){
			user.changeHealth(user.getPlayerItems(Split[1]).getHealthDiff());
			return true;
		}
		return false;
	}

}
