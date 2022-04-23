package hoidong;

import baocao.BaoCaoKhoaLuan;

import java.util.List;

public class HoiDong {

	private List<ThanhVienHoiDong> thanhVien;

	private List<BaoCaoKhoaLuan> danhSachKhoaLuan;

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
}
