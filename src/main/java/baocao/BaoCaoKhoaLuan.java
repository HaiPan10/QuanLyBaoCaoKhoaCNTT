package baocao;

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

	public BaoCaoKhoaLuan(HoiDong hoiDong,String ten, GiangVien giangVienHD, List<SinhVien> sinhVien){
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

	/**
	 * Lay ten cac thanh vien hoi dong
	 * @return Chuoi ten cac thanh vien hoi dong
	 */
	public String getTenThanhVien(){
		StringBuilder sb = new StringBuilder();
		List<ThanhVienHoiDong> danhSach = hoiDong.getThanhVien();
		for(ThanhVienHoiDong tv : danhSach){
			sb.append(String.format("%s (%s)",tv.getThanhVienHoiDong().getHoTen(),tv.getChucVu()));
			if(danhSach.indexOf(tv) < danhSach.size() - 1){
				sb.append(", ");
			}
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return super.toString() + String.format("Thanh vien hoi dong quan ly: %s\nDanh gia phan bien: %s\n",
				this.getTenThanhVien(), this.danhGiaPhanBien).replaceAll("null","N/A");
	}
}
