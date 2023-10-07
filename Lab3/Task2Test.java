package Lab3;

import java.util.Arrays;

public class Task2Test {
	public static void main(String[] args) {
		Product p1 = new Product("001", "Red Bull", 15000, "Drink");
		Product p2 = new Product("002", "Mountain Dew", 10000, "Drink");
		Product p3 = new Product("003", "Sprite", 7000, "Drink");
		Product p4 = new Product("004", "Dasani", 5000, "Drink");
		Product p5 = new Product("005", "Bread", 20000, "Food");
		Product p6 = new Product("006", "Mashed Potatoes", 30000, "Food");
		Product p7 = new Product("007", "Spaghetti", 50000, "Food");
		Product p8 = new Product("008", "Hot Dog", 35000, "Food");
		Product p9 = new Product("009", "Snoop Dogg", 100000, "Food");
//		OrderItem i1 = new OrderItem(p1, 50);
		OrderItem i2 = new OrderItem(p2, 30);
		OrderItem i3 = new OrderItem(p3, 20);
		OrderItem i4 = new OrderItem(p4, 70);
		OrderItem i5 = new OrderItem(p5, 100);
		OrderItem i6 = new OrderItem(p6, 30);
		OrderItem i7 = new OrderItem(p7, 70);
		OrderItem i8 = new OrderItem(p8, 40);
		OrderItem i9 = new OrderItem(p9, 40);
		OrderItem[] items = {i2, i3, i4, i5, i6, i7, i8, i9};
		Order list1 = new Order(items);
		
		// cost
		System.out.println("**Cost: ");
		System.out.println(list1.cost());
		System.out.println();
		
		//contains
		System.out.println("**Contains: ");
		System.out.println(list1.contains(p1));
		System.out.println(list1.contains(p7));
		System.out.println();
		
		//sort by Price
		System.out.println("sort: ");
		System.out.println(Arrays.toString(list1.sort(items)));
		System.out.println();
		
		// filter
		System.out.println("**filter: ");
		System.out.println(Arrays.toString(list1.filter("Food")));
		System.out.println(Arrays.toString(list1.filter("Drink")));
	}
}
