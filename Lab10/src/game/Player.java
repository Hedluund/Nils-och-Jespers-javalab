package game;

public class Player {
	private String name;
	private int age;
	private int health=10;
	
	public void setName(String newname){
		this.name=newname;
	}
	public String getName(){
		return this.name;	
	}
	public void changeHealth(int dmg){
		this.health= this.health+dmg;
		if (health<0) {
			health=0;
		}
		
	}

}
