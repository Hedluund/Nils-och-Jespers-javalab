package myutil;

public class Node <E> {
	E data;
	Node<E> next;
	
	public Node(E newData, Node<E> nextNode ){
		this.data=newData;
		this.next=nextNode;
	}
	
	public Node <E> returnNext() {
		return this.next;
	}

}
