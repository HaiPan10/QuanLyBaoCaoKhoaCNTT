package connguoi;

import java.text.ParseException;

public class GiangVien extends Person {
	private String hocHam;
	private String hocVi;
	private static int dem = 0;

	public GiangVien(){

	}

	public GiangVien(String ten, String gioiTinh, String namSinh, String hh, String hv) throws ParseException {
		super(ten,gioiTinh,namSinh);
		this.hocHam = hh;
		this.hocVi = hv;
	}
	

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
}
