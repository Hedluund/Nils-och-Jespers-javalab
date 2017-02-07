package myutil;

public class testQueue {
	
	public static void main(String[] args) {
		MyQueue<Integer> ko = new MyQueue<>();
		ko.enqueue(1);
		
		System.out.println(ko.dequeue());
		System.out.println(ko.dequeue());
		if(ko.isEmpty()) {
			System.out.println("hej");
		}

		
	}

}
