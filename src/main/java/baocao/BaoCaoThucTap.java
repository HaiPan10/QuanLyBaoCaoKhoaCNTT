package baocao;

import connguoi.GiangVien;
import connguoi.SinhVien;

public class BaoCaoThucTap extends BaoCao {
	private String danhGiaDoanhNghiep;

	//==========Constructor Methods==========
	public BaoCaoThucTap(){
		super();
	}

	public BaoCaoThucTap(String ten, GiangVien giangVienHD, SinhVien[] sinhVien){
		super(ten,giangVienHD,sinhVien);
	}

	//==========BaoCaoThucTap Methods/Behaviors==========
}
