package Lab6;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayListTest {
	public static void main(String[] args) {
		MyArrayList<String> marr = new MyArrayList<String>(3);
		
		//add method
		marr.add("E");
		marr.add("F");
		marr.add("C");
		marr.add("Z"); //Array will be: [E, F, C, Z, A, F]
		marr.add("A");
		marr.add("F");
		
		//size method
		System.out.println(marr.size()); //--> 6
		
		//isEmpty method
		System.out.println(marr.isEmpty()); //--> false
		
		//get method
		System.out.println(marr.get(2)); //The current element index 2 is "C"
		
		//set method
		marr.set(3,"D"); //method will change the element "Z" to "D" --> [E, F, C, D, A, F]
		
		//add(int index, E e) method
		marr.add(1,"B");  //method will add the element "B" to index 1 --> [E, B, F, C, D, A, F]
		
		//lastIndexOf method
		System.out.println(marr.lastIndexOf("F")); //--> 6
		
		//indexOf method
		System.out.println(marr.indexOf("F")); //--> 2
		
		//remove(int index) method
		marr.remove(6); //--> [E, B, F, C, D, A]
		
		//remove(E e) method
		marr.remove("F"); //--> [E, B, C, D, A]
				
		//contains method
		System.out.println(marr.contains("B")); //Array contains "B" --> True
		
		//sort method
		marr.sort(Comparator.naturalOrder()); //--> [A, B, C, D, E]
		
		//toArray method
		System.out.println(Arrays.toString(marr.toArray()));
		
		//clone method
		System.out.println("clone: " + Arrays.toString(marr.clone().toArray()));
		
		//clear method
		marr.clear();
		System.out.println(Arrays.toString(marr.toArray()));
	}
}
