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
	
	public E pop(){
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
