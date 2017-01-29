package game;

public class Tools extends Items {

	public Tools(String name, Double weight, int healthInc) {
		super(name, weight, healthInc);
	}

	public boolean doCommand(String action, Player user) {
		if (action.equals("light torch")) {
			user.LightTorch();
			System.out.println("Ljuuuuuuuuuus");
			return true;
		}
			return false;
	}	

}
