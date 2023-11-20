package Lab9_Task2;

import java.util.List;
import java.util.Objects;

public class SachThamKhao extends AnPham {
	private String linhVuc;
	private List<ChuongSach> dsChuongSach;

	public SachThamKhao(String tieuDe, int soTrang, int namXuatBan, String tacGia, int giaTien, String linhVuc,
			List<ChuongSach> dsChuongSach) {
		super(tieuDe, soTrang, namXuatBan, tacGia, giaTien);
		this.linhVuc = linhVuc;
		this.dsChuongSach = dsChuongSach;
	}
	
	public String loaiAnPham() {
		return "Sach tham khao";
	}

	public List<ChuongSach> getDsChuongSach() {
		return dsChuongSach;
	}
	
	
	public String toString() {
		return "tieuDe=" + tieuDe + ", soTrang=" + soTrang + ", namXuatBan=" + namXuatBan + ", tacGia=" + tacGia + ", giaTien=" + giaTien
				+ "linhVuc=" + linhVuc + ", dsChuongSach=" + dsChuongSach;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dsChuongSach, linhVuc);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SachThamKhao other = (SachThamKhao) obj;
		return Objects.equals(dsChuongSach, other.dsChuongSach) && Objects.equals(linhVuc, other.linhVuc);
	}
}
