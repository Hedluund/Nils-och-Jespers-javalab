package myutil;

public class MyStack <E> {
	private Node<E> top;
	private int size=0;
	
	public MyStack(){	
		top=null;
	}
	
	public void push(E newData){
		top = new Node<>(newData,top);
		size++;		
	}
	
	private void checkEmptyEx(){
		if (isEmpty()){
			throw new EmptyListException();
		}
	}
	
	public E pop(){
		try{
			checkEmptyEx();				
		}catch(EmptyListException e){
			System.out.println("Error: Listan är tom.");
			System.exit(1);
		}
		E data=top.data;
		this.top=top.next;
		size--;
		return data;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public int size(){
		return size;
	}
	
}
