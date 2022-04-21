package hoidong;

import baocao.BaoCaoKhoaLuan;
import connguoi.GiangVien;

import java.util.ArrayList;
import java.util.List;

public class ThanhVienHoiDong {

	private HoiDong hoiDong;

	private String chucVu;

	private GiangVien thanhVienHoiDong;

	private List<ChamDiem> danhSachChamDiem;

	//==========CONSTRUCTORS==========

	public ThanhVienHoiDong(HoiDong hoiDong, String chucVu, GiangVien giangVien){
		this.hoiDong = hoiDong;
		this.chucVu = chucVu;
		this.thanhVienHoiDong = giangVien;
		setDanhSachChamDiem(new ArrayList<>());
	}

	//==========Getter & Setter==========

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

	public List<ChamDiem> getDanhSachChamDiem() {
		return danhSachChamDiem;
	}

	public void setDanhSachChamDiem(List<ChamDiem> danhSachChamDiem) {
		this.danhSachChamDiem = danhSachChamDiem;
	}

	//==========Methods/Behaviors==========
	public void addBaoCaoKhoaLuan(BaoCaoKhoaLuan baoCaoKhoaLuan){
		ChamDiem cd = new ChamDiem(baoCaoKhoaLuan);
		this.danhSachChamDiem.add(cd);
	}
}
