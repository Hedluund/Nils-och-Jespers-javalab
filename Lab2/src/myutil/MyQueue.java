package myutil;

public class MyQueue<E> {
	private Node<E> Last;
	private int size=0;

	public MyQueue() {
		this.Last = null;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int size() {
		return this.size;
	}
	
	private void checkEmptyEx(){
		if (isEmpty()){
			throw new EmptyListException();
		}
	}

	public void enqueue(E newData) {
		Last = new Node<>(newData, Last);
		size++;
	}
	
	private Node<E> findFirstNode(Node<E> eQ) {
		if (eQ.next.next != null) {
			return findFirstNode(eQ.next);
		}
		return eQ;
	}

	public E dequeue() {
		try {
			checkEmptyEx();
		}catch(EmptyListException e){
			System.out.println("Error: Det finns inget att avk�a.");
			System.exit(1);
		}
		
		if(Last.next == null){
			E valuelast = Last.data;
			Last = null;
			size--;
			return valuelast;
		}	
		Node <E> First;
		First = findFirstNode(this.Last);
		E value = First.next.data;
		First.next=null;
		size--;
		return value;
	}

	
}
