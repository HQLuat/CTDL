package Lab9_Task2;

public class ChuongSach {
	private String tieuDe;
	private int soTrang;
	
	public ChuongSach(String tieuDe, int soTrang) {
		super();
		this.tieuDe = tieuDe;
		this.soTrang = soTrang;
	}
	
	@Override
	public String toString() {
		return "[tieuDe=" + tieuDe + ", soTrang=" + soTrang +']';
	}
}
