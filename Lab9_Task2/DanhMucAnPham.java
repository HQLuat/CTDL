package Lab9_Task2;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DanhMucAnPham {
	private List<AnPham> dsAnPham;

	public DanhMucAnPham(List<AnPham> dsAnPham) {
		super();
		this.dsAnPham = dsAnPham;
	}
	
	public double tongTien() {
		double re = 0.0;
		for (AnPham anPham : dsAnPham) {
			re += anPham.getGiaTien();
		}
		return re;
	}
	public AnPham nhieuChuongNhat() {
		int index = 0;
		for (int i = 0; i < dsAnPham.size(); i++) {
			if (dsAnPham.get(index) instanceof SachThamKhao) {
				if (dsAnPham.get(i).getSoTrang() > dsAnPham.get(index).getSoTrang()
						&& dsAnPham.get(i) instanceof SachThamKhao) {
					index = i;
				}
			} else {
				index++;
			}
		}
		return dsAnPham.get(index);
	}
	
	public boolean timTapChi(AnPham anpham) {
		for (AnPham arr : dsAnPham) {
			if (arr.equals(anpham)) {
				return true;
			}
		}
		return false;
	}

	public Set<AnPham> namChoTruoc(int year) {
		Set<AnPham> result = new HashSet<>();
		for (AnPham arr : dsAnPham) {
			if (arr.getNamXuatBan() == year && arr instanceof TapChi) {
				result.add(arr);
			}
		}
		return result;
	}

	public List<AnPham> sapXep() {
		Collections.sort(dsAnPham, new Comparator<AnPham>() {

			@Override
			public int compare(AnPham o1, AnPham o2) {
				if (o1.getNamXuatBan() == o2.getNamXuatBan()) {
					return o1.getTieuDe().compareTo(o2.getTieuDe());
				}
				return o2.getNamXuatBan() - o1.getNamXuatBan();
			}
		});
		return dsAnPham;
	}

	public Map<Integer, Integer> thongKe() {
		Map<Integer, Integer> result = new HashMap<>();
		for (AnPham arr : dsAnPham) {
			result.put(arr.getNamXuatBan(), result.getOrDefault(arr.getNamXuatBan(), 0) + 1);
		}
		return result;
	}
}
