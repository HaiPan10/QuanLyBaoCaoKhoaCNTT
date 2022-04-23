package connguoi;

import cauhinh.CauHinh;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class GiangVien extends Person {
	private String hocHam;
	private String hocVi;
	private static int dem = 0;
	{
		++dem;
	}

	//==========Constructor Methods==========
	public GiangVien(){
		super(dem);
	}

	public GiangVien(String ten, String gioiTinh, String namSinh, String hh, String hv) throws ParseException, FileNotFoundException {
		super(dem, ten,gioiTinh,namSinh);
		this.hocHam = hh;
		this.hocVi = hv;
	}


	//==========Getter & Setter==========
	public String getHocHam() {
		return hocHam;
	}

	public void setHocHam(String hocHam) {
		this.hocHam = hocHam;
	}

	public String getHocVi() {
		return hocVi;
	}

	public void setHocVi(String hocVi) {
		this.hocVi = hocVi;
	}

	@Override
	public void nhap() throws ParseException {
		super.nhap();
		System.out.print("Nhap vao hoc ham: ");
		this.hocHam = CauHinh.sc.nextLine();
		System.out.print("Nhap vap hoc vi: ");
		this.hocVi = CauHinh.sc.nextLine();
	}
}
