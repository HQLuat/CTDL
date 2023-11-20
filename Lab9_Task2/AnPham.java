package Lab9_Task2;

import java.util.Objects;

public abstract class  AnPham {
	protected String tieuDe;
	protected int soTrang;
	protected int namXuatBan;
	protected String tacGia;
	protected int giaTien;
	
	public AnPham(String tieuDe, int soTrang, int namXuatBan, String tacGia, int giaTien) {
		this.tieuDe = tieuDe;
		this.soTrang = soTrang;
		this.namXuatBan = namXuatBan;
		this.tacGia = tacGia;
		this.giaTien = giaTien;
	}
	
	public abstract String loaiAnPham();
	
	public boolean tapChiVaCach10Nam() {
		return loaiAnPham().equals("Tap chi") && (2021 - namXuatBan) >= 10;
	}
	
	public boolean coCungLoaiVaTacGia(AnPham that) {
		return this.loaiAnPham().equals(that.loaiAnPham()) && this.tacGia.equals(that.tacGia);
	}
	
	
	
	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public int getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(giaTien, namXuatBan, soTrang, tacGia, tieuDe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnPham other = (AnPham) obj;
		return giaTien == other.giaTien && namXuatBan == other.namXuatBan && soTrang == other.soTrang && Objects.equals(tacGia, other.tacGia)
				&& Objects.equals(tieuDe, other.tieuDe);
	}
}
