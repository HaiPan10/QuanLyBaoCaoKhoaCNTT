package hoidong;

import connguoi.GiangVien;
import hoidong.HoiDong;

public class ThanhVienHoiDong {

	private HoiDong hoiDong;

	private String chucVu;

	private GiangVien thanhVienHoiDong;

	private double diemCham;

	private String nhanXet;

	public HoiDong getHoiDong() {
		return hoiDong;
	}

	public void setHoiDong(HoiDong hoiDong) {
		this.hoiDong = hoiDong;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public GiangVien getThanhVienHoiDong() {
		return thanhVienHoiDong;
	}

	public void setThanhVienHoiDong(GiangVien thanhVienHoiDong) {
		this.thanhVienHoiDong = thanhVienHoiDong;
	}

	public double getDiemCham() {
		return diemCham;
	}

	public void setDiemCham(double diemCham) {
		this.diemCham = diemCham;
	}

	public String getNhanXet() {
		return nhanXet;
	}

	public void setNhanXet(String nhanXet) {
		this.nhanXet = nhanXet;
	}
}
