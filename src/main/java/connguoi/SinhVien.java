package connguoi;

import java.text.ParseException;

public class SinhVien extends Person {
	private int khoaHoc;
	private String chuyenNganh;
	private static int dem = 0;

	public SinhVien() {

	}

	public SinhVien(String ten, String  gioiTinh, String namSinh, int kh, String cn) throws ParseException {
		super(ten, gioiTinh, namSinh);
		this.khoaHoc = kh;
		this.chuyenNganh = cn;
	}
	
	public int getKhoaHoc() {
		return khoaHoc;
	}

	public void setKhoaHoc(int khoaHoc) {
		this.khoaHoc = khoaHoc;
	}

	public String getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}
}
