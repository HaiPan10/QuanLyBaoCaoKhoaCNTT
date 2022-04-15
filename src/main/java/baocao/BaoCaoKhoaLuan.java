package baocao;

import connguoi.GiangVien;
import connguoi.SinhVien;
import hoidong.HoiDong;

public class BaoCaoKhoaLuan extends BaoCao {
	private HoiDong danhSach;
	private String danhGiaPhanBien;

	//==========Constructor Methods==========
	public BaoCaoKhoaLuan(){
		super();
	}

	public BaoCaoKhoaLuan(String ten, GiangVien giangVienHD, SinhVien[] sinhVien){
		super(ten, giangVienHD, sinhVien);
	}

	//==========BaoCaoKhoaLuan Methods/Behaviors==========
}
