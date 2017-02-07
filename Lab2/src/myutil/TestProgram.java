package myutil;

public class TestProgram {
	
	public static void main(String[] args){
		MyStack<Integer> stacken=new MyStack<>();
		stacken.push(4);
	
		
	
		System.out.println(stacken.pop());
		System.out.println(stacken.pop());
		System.out.println(stacken.size());
		if(stacken.isEmpty()){
			System.out.println("Nils snittet jonsson");
		}
	
	}
	
}
