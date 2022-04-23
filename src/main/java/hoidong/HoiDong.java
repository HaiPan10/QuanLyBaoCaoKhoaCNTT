package hoidong;

import baocao.BaoCaoKhoaLuan;

import java.util.ArrayList;
import java.util.List;

public class HoiDong {

	private static final int MAX_THANH_VIEN = 5;
	private static final int MIN_THANH_VIEN = 3;

	private List<ThanhVienHoiDong> thanhVien;

	private List<BaoCaoKhoaLuan> danhSachKhoaLuan;

	//==========Constructor Methods==========

	public HoiDong(){
		this.thanhVien = new ArrayList<>();
		this.danhSachKhoaLuan = new ArrayList<>();
	}

	//==========Getter & Setter==========
	public List<ThanhVienHoiDong> getThanhVien() {
		return thanhVien;
	}

	public void setThanhVien(List<ThanhVienHoiDong> thanhVien) {
		this.thanhVien = thanhVien;
	}

	public List<BaoCaoKhoaLuan> getDanhSachKhoaLuan() {
		return danhSachKhoaLuan;
	}

	public void setDanhSachKhoaLuan(List<BaoCaoKhoaLuan> danhSachKhoaLuan) {
		this.danhSachKhoaLuan = danhSachKhoaLuan;
	}

	//==========Behaviors/Methods==========

	public void themThanhVienHoiDong(ThanhVienHoiDong thanhVien){
		if(this.thanhVien.size() == 5)
			return;
		this.thanhVien.add(thanhVien);
	}

	public void themBaoCaoKhoaLuan(BaoCaoKhoaLuan baoCao){
		this.danhSachKhoaLuan.add(baoCao);
		thanhVien.forEach(tv->tv.addBaoCaoKhoaLuan(baoCao));
	}
}
