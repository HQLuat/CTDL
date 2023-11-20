package Lab9_Task2;

import java.util.ArrayList;
import java.util.List;

public class TestTask2 {
	public static void main(String[] args) {
		//ChuongSach
		ChuongSach cs1 = new ChuongSach("Dao dong co", 17);
		ChuongSach cs2 = new ChuongSach("Song co va song am", 29);
		ChuongSach cs3 = new ChuongSach("Dong dien xoay chieu", 46);
		
		List<ChuongSach> dsChuongSach = new ArrayList<ChuongSach>();
		dsChuongSach.add(cs1);
		dsChuongSach.add(cs2);
		dsChuongSach.add(cs3);
		
		//SachThamKhao
		AnPham stk1 = new SachThamKhao("SGK vat ly lop 12", 250, 2013, "BoGiaoDuc", 42000, "VatLy", dsChuongSach);
		
		//TapChi
		AnPham tc1 = new TapChi("Vo cam", 30, 2010, "Nguyen Van A", 50000, "Dang nho");
		
		//DanhMucAnPham
		List<AnPham> dsAnPham = new ArrayList<AnPham>();
		dsAnPham.add(stk1);
		dsAnPham.add(tc1);
		DanhMucAnPham dmap = new DanhMucAnPham(dsAnPham);
		
		//Phuong thuc kiem tra 2 An Pham co cung loai va cung tac gia hay khong
		System.out.println(stk1.coCungLoaiVaTacGia(tc1));
		
		//Phuong thuc kiem tra An Pham la tap chi va co thoi gian xuan ban cach day(2021) la 10 nam hay khong?
		System.out.println(tc1.tapChiVaCach10Nam());
		
		//Phuong thuc tinh tong tien tat ca cac An Pham trong nha sach
		System.out.println(dmap.tongTien());
		
		//Tim quyen sach tham khao co chuong sach nhieu trang nhat
		System.out.println(dmap.nhieuChuongNhat());
		
		//Tìm xem trong danh sách các ấn phẩm có chứa một tạp chí có tên cho trước hay không?
		System.out.println(dmap.timTapChi(tc1));
		
		//Lấy ra danh sách các tạp chí được xuất bản vào 1 năm cho trước
		System.out.println(dmap.namChoTruoc(2013));
		
		
		//Sắp xếp ấn phẩm tăng dần theo tiêu đề và giảm dần theo năm xuất bản (sử dụng interface Comparable hoặc Comparator)
		System.out.println(dmap.sapXep());
		
		//Thống kê số lượng ấn phẩm theo năm xuất bản. Ví dụ 2020: 5, 2021: 10, …năm 2020 có 5 ấn phẩm, năm 2021 có 10 ấn phẩm
		System.out.println(dmap.thongKe());
	}
}
