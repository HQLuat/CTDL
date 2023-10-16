package Lab4;
public class OrderItem {
	private Product p;
	private int quality;
	
	public OrderItem(Product p, int quality) {
		this.p = p;
		this.quality = quality;
	}
	
	public double getPrice() {
		return p.getPrice();
	}
	public String getType() {
		return p.getType();
	}

	public Product getProduct() {
		return p;
	}

	public String toString() {
		return p.toString() + "," + quality;
	}
	
}
