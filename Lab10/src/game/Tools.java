package game;

public class Tools extends Items {

	public Tools(String name, Double weight) {
		super(name, weight);
	}

	public void doCommand(String action, Player user) {
		if (action.equals("light torch")) {
			user.LightTorch();
		}
		else if (action.equals("dig") && user.getLoc().canIDigHere() && !user.getLoc().haveIDugHere()) {
			user.getLoc().digHere();
			System.out.println("Du har grävt");
		}
	}

}
