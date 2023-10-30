package Lab6;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {
		super();
	}

// Returns the number of elements in the list.
	public int size() {
		return size;
	}

// Returns true if the list is empty, and false otherwise.
	public boolean isEmpty() {
		return size == 0;
	}

// Returns (but does not remove) the first element in the list.
	public E first() {
		if(size == 0) {
			return null;
		}
		return head.getData();
	}

// Returns (but does not remove) the last element in the list.
	public E last() {
		if(size == 0) {
			return null;
		}
		return tail.getData();
	}

// Adds a new element to the front of the list.
	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e,head);
		head = newNode;
		size++;

		if (head.getNext() == null) {
			tail = head;
		}
	}

// Adds a new element to the end of the list.
	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e); 

		if (size == 0) {
			addFirst(e);
			return;
		}

		tail.setNext(newNode);
		tail = newNode;
		size++;
	}

// Removes and returns the first element of the list.
	public E removeFirst() {
		if(size == 0) {
			return null;
		}
		E element = head.getData();
		Node<E> nextNode = head.getNext();
		
		head.setData(null);
		head.setNext(null);
		head = nextNode;
		size--;
		
		return element;
	}

// Removes and returns the last element of the list.
	public E removeLast() {
		if(size == 0) {
			return null;
		}
		E element = tail.getData();
		Node<E> prevNode = head;
		for (int i = 0; i < size-2; i++) {
			prevNode = prevNode.getNext();
		}
		
		tail = prevNode;
		tail.setNext(null);
		
		size--;
		return element;
	}

	public E[] toArray() {
		Object[] result = new Object[size];
		int index = 0;
		for (Node<E> x = head; x != null; x = x.getNext()) {
			result[index++] = (E) x.getData();
		}
		return (E[]) result;
	}
}
