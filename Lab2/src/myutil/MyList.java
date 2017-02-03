package myutil;

public class MyList <E>{
	private Node<E> top;
	private int size=0;
	
	public MyList(){
		top=null;
	}
	
	public void add(E newData){
		top = new Node<>(newData,top);
		size++;	
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	private E ValueOfPlace(int count, Node<E> listNode){
		if (count == 0) {
			return listNode.data;
		}
		count--;
		return ValueOfPlace(count, listNode.next);
	}
	
	public E getElementAt(int PlaceInList){
		return ValueOfPlace(this.size-PlaceInList,this.top);
	}
	

}
