package Lab6;

import java.util.Arrays;

public class SinglyLinkedListTest {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
		
		linkedList.addFirst(4);
		linkedList.addFirst(3); //--> [1, 2, 3, 4]
		linkedList.addFirst(2);
		linkedList.addFirst(1);
		
		linkedList.addLast(5);
		linkedList.addLast(6); //--> [1, 2, 3, 4, 5, 6, 7, 8]
		linkedList.addLast(7);
		linkedList.addLast(8);
		
		System.out.println("size: " + linkedList.size());
		System.out.println("isEmpty: " + linkedList.isEmpty());
		System.out.println();
		
		System.out.println("first element: " + linkedList.first());
		System.out.println("last element: " + linkedList.last());
		System.out.println();
		
		System.out.println("removed element: " + linkedList.removeFirst()); //removed element is "1" --> [2, 3, 4, 5, 6, 7, 8]
		System.out.println("removed element: " + linkedList.removeLast()); //removed element is "8" --> [2, 3, 4, 5, 6, 7]
		
		System.out.println(Arrays.toString(linkedList.toArray()));
	}
}
