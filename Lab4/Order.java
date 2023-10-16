package Lab4;

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
	public OrderItem[] BubbleSortbyPrice(OrderItem[] items) {
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items.length - 1 - i; j++) {
				if (items[j].getPrice() > items[j + 1].getPrice()) {
					OrderItem index = items[j - 1];
					items[j - 1] = items[j];
					items[j] = index;
				}
			}
		}
		return items;
	}

	public OrderItem[] SelectionSortbyPrice(OrderItem[] items) {
		for (int i = 0; i < items.length; i++) {
			for (int j = i + 1; j < items.length; j++) {
				if (items[i].getPrice() > items[j].getPrice()) {
					OrderItem temp = items[i];
					items[i] = items[j];
					items[j] = temp;
				}
			}
		}
		return items;
	}

	public OrderItem[] InsertionSortbyPrice(OrderItem[] items) {
		for (int i = 0; i < items.length; i++) {
			double temp = items[i].getPrice();
			for (int j = i - 1; j >= 0; j--) {
				if (temp < items[j].getPrice()) {
					OrderItem tmp = items[j + 1];
					items[j + 1] = items[j];
					items[j] = tmp;
				}
			}
		}
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
