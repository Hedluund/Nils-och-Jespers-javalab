package myutil;

public class testlist {
	
	public static void main(String[] args) {
		MyList<Integer> listan = new MyList<>(); 
		
		listan.add(7);
		listan.add(28746);
		listan.add(3);
		System.out.println(listan.getElementAt(47));
	}

}
