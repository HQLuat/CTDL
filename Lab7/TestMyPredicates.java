package Lab7;

import java.util.ArrayList;
import java.util.List;

public class TestMyPredicates {
	public static void main(String[] args) {
		//Testing for remove method
		List<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(4);
		list.add(5);
		
		MyPredicates.remove(list, new Even());
		System.out.println("remove: " + list);
		
		//Testing for retain method
		List<Integer> list1 = new ArrayList<>();
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		list1.add(5);
		
		MyPredicates.retain(list1, new Even());
		System.out.println("retain: " + list1);
		
		//Testing for collect method
		List<Integer> list2 = new ArrayList<>();
		
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(5);
		
		System.out.println("collect: " + MyPredicates.collect(list2, new Even()));
		
		//Testing for collect method
		List<Integer> list3 = new ArrayList<>();
				
		list3.add(1);
		list3.add(2);
		list3.add(3);
		list3.add(3);
		list3.add(4);
		list3.add(5);
		list3.add(5);
				
		System.out.println("find: " + MyPredicates.find(list3, new Even()));
	}
}
