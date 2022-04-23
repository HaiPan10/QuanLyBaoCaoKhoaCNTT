package connguoi;

import cauhinh.CauHinh;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class SinhVien extends Person {
	private int khoaHoc;
	private String chuyenNganh;
	private static int dem = 0;
	{
		++dem;
	}

	//==========Constructor Methods==========
	public SinhVien() { //Moi lan tao 1 sinh vien se tu dong cap ma so
		super(dem);
	}

	public SinhVien(String ten, String  gioiTinh, String namSinh, int kh, String cn) throws ParseException, FileNotFoundException {
		super(dem,ten, gioiTinh, namSinh);
		this.khoaHoc = kh;
		this.chuyenNganh = cn;
	}

	//==========Getter & Setter==========
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

	@Override
	public void nhap() throws ParseException {
		super.nhap();
		System.out.print("Nhap vao khoa hoc: ");
		this.khoaHoc = Integer.parseInt(CauHinh.sc.nextLine());
		System.out.print("Nhap vao chuyen nganh: ");
		this.chuyenNganh = CauHinh.sc.nextLine();
	}
}
