package baocao;

import cauhinh.CauHinh;
import connguoi.GiangVien;
import connguoi.SinhVien;
import hoidong.HoiDong;
import hoidong.ThanhVienHoiDong;

import java.util.List;

public class BaoCaoKhoaLuan extends ThongTinChung {
	private HoiDong hoiDong;
	private String danhGiaPhanBien;

	//==========Constructor Methods==========
	public BaoCaoKhoaLuan(){
		super();
	}

	public BaoCaoKhoaLuan(HoiDong hoiDong,String ten, GiangVien giangVienHD, List<SinhVien> sinhVien) throws Exception {
		super(ten, giangVienHD, sinhVien);
		this.hoiDong = hoiDong;
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
	public String toString() {
		return super.toString() + String.format("Thanh vien hoi dong khoa luan:\n %s\nDanh gia phan bien: %s\n",
				this.hoiDong.getThongTin(this.getMaBaoCao()), this.danhGiaPhanBien).replaceAll("null","N/A");
	}

	@Override
	public String loaiBaoCao() {
		return "Bao Cao Khoa Luan";
	}

	public void nhapDanhGia(){
		System.out.print("Nhap danh gia phan bien: ");
		this.danhGiaPhanBien = CauHinh.sc.nextLine();
	}

	@Override
	public void sua() {
		super.sua();
		nhapDanhGia();
	}
}
