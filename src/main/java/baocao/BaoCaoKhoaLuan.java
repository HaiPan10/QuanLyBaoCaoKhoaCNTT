package baocao;

import connguoi.GiangVien;
import connguoi.SinhVien;
import hoidong.HoiDong;

import java.util.List;

public class BaoCaoKhoaLuan extends ThongTinChung {
	private HoiDong hoiDong;
	private String danhGiaPhanBien;

	//==========Constructor Methods==========
	public BaoCaoKhoaLuan(){
		super();
	}

	public BaoCaoKhoaLuan(String ten, GiangVien giangVienHD, List<SinhVien> sinhVien){
		super(ten, giangVienHD, sinhVien);
	}

	//==========Getter & Setter==========
	public HoiDong getHoiDong() {
		return hoiDong;
	}

	public void setHoiDong(HoiDong hoiDong) {
		this.hoiDong = hoiDong;
	}

	public String getDanhGiaPhanBien() {
		return danhGiaPhanBien;
	}

	public void setDanhGiaPhanBien(String danhGiaPhanBien) {
		this.danhGiaPhanBien = danhGiaPhanBien;
	}

	//==========BaoCaoKhoaLuan Methods/Behaviors==========

	@Override
	public void hienThi() {
		super.hienThi();
		System.out.printf("Danh gia phan bien: %s", this.getDanhGiaPhanBien());
	}
}
