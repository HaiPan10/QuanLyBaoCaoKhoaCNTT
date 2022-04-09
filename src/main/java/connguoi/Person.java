package connguoi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
	private static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
	private String hoTen;
	private int maSo;
	private String gioiTinh;
	private Date namSinh;

	public Person(){

	}

	public Person(String ten, String gioiTinh, Date namSinh){
		this.hoTen = ten;
		this.gioiTinh = gioiTinh;
		this.namSinh = namSinh;
	}

	public Person(String ten, String gioiTinh, String namSinh) throws ParseException {
		this(ten,gioiTinh,F.parse(namSinh));
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getMaSo() {
		return maSo;
	}

	public void setMaSo(int maSo) {
		this.maSo = maSo;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(Date namSinh) {
		this.namSinh = namSinh;
	}
}
