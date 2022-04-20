package baocao;

import connguoi.GiangVien;
import connguoi.SinhVien;

import java.util.List;

public class BaoCaoThucTap extends BaoCao {
	private String danhGiaDoanhNghiep;

	//==========Constructor Methods==========
	public BaoCaoThucTap(){
		super();
	}

	public BaoCaoThucTap(String ten, GiangVien giangVienHD, List<SinhVien> sinhVien){
		super(ten,giangVienHD,sinhVien);
	}

	//==========Getter & Setter==========
	public String getDanhGiaDoanhNghiep() {
		return danhGiaDoanhNghiep;
	}

	public void setDanhGiaDoanhNghiep(String danhGiaDoanhNghiep) {
		this.danhGiaDoanhNghiep = danhGiaDoanhNghiep;
	}

	//==========BaoCaoThucTap Methods/Behaviors==========

	@Override
	public void hienThi() {
		super.hienThi();
		System.out.printf("Danh gia doanh nghiep: %s\n", this.getDanhGiaDoanhNghiep());
	}
}
