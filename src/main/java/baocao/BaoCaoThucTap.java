package baocao;

import cauhinh.CauHinh;
import connguoi.GiangVien;
import connguoi.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class BaoCaoThucTap extends BaoCao {
	private String danhGiaDoanhNghiep;
	private static List<SinhVien> daThamGia = new ArrayList<>();

	//==========Constructor Methods==========
	public BaoCaoThucTap(){
		super();
	}

	public BaoCaoThucTap(String ten, GiangVien giangVienHD, List<SinhVien> sinhVien) throws Exception {
		super(ten,giangVienHD,sinhVien);
		daThamGia.addAll(sinhVien);
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
	public String toString() {
		return super.toString() + String.format("Danh gia doanh nghiep: %s\n", this.danhGiaDoanhNghiep).replaceAll("null","N/A");
	}

	@Override
	public String loaiBaoCao() {
		return "Bao Cao Thuc Tap";
	}

	public void nhapDanhGia(){
		System.out.print("Nhap danh gia doanh nghiep: ");
		this.danhGiaDoanhNghiep = CauHinh.sc.nextLine();
	}

	@Override
	public void sua() {
		super.sua();
		nhapDanhGia();
	}

	/***
	 * Kiem soat viec sinh vien da tung tham gia chua
	 * @param sv
	 * @return true / false
	 */
	public static boolean isDaThamGia(List<SinhVien> sv){
		for(SinhVien sinhVien : daThamGia){
			for(SinhVien temp : sv){
				if(temp == sinhVien)
					return true;
			}
		}
		return false;
	}
}
