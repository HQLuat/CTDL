package Lab3;

import java.util.Arrays;
import java.util.Comparator;

public class Order {
	private OrderItem[] items;
	
	public Order(OrderItem[] items) {
		this.items = items;
	}
	
	//Cost method
	public double cost() {
		double result = 0;
		for (int i = 0; i < items.length; i++) {
			result += items[i].getPrice();
		}
		return result;
	}
	
	//Sort by price
	public OrderItem[] sort(OrderItem[] items) {
		Arrays.sort(items, Comparator.comparing(item -> item.getProduct().getPrice()));
		return items;
	}

	//Contains method
	public boolean contains(Product p) {
		Arrays.sort(items, Comparator.comparing(item -> item.getProduct().getPrice()));
		int low = 0;
		int high = items.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (p.getPrice() == items[mid].getPrice())
				return true;
			if (p.getPrice() < items[mid].getPrice())
				high = mid - 1;
			else 
				low = mid + 1;
		}
		return false;
	}
	
	//Filter method
	public int getLength(OrderItem[] items, String type) {
		int result = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i].getType() == type) {
				result++;
			}
		}
		return result;
	}
	public Product[] filter(String type) {
		Product[] result = new Product[getLength(items, type)];
		int index = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i].getType() == type) {
				result[index++] = items[i].getProduct();
			}
		}
		return result;
	}
}
