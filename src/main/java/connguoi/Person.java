package connguoi;

import cauhinh.CauHinh;

import java.io.File;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Person {
	private static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
	private String hoTen;
	private int maSo;
	private String gioiTinh;
	private Date namSinh;

	//==========Constructor Methods==========
	public Person(int maSo){
		this.maSo = maSo;
	}

	public Person(int ma,String ten, String gioiTinh, Date namSinh) throws FileNotFoundException {
		this(ma);
		this.hoTen = ten;
		this.gioiTinh = gioiTinh;
		this.namSinh = namSinh;
	}

	public Person(int ma,String ten, String gioiTinh, String namSinh) throws ParseException, FileNotFoundException {
		this(ma,ten,gioiTinh,F.parse(namSinh));
	}

	//==========Getter & Setter==========

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

	//==========Person Methods==========
	public void hienThi(){
		System.out.printf("Ho va ten : %s\nGioi Tinh : %s\nNam Sinh: %s\n", this.hoTen, this.gioiTinh, F.format(namSinh));
	}

//	public void docFile() throws FileNotFoundException {
//		File f = new File("src/main/resources/data.txt");
//		try (Scanner s1 = new Scanner(f)) {
//			while (s1.hasNext()) {
//				String hoTen = s1.nextLine();
//				String gioiTinh = s1.nextLine();
//				String namSinh = F.format(s1.nextLine());
//				s1.nextLine();
//			}
//		}
//	}

	public void nhap() throws ParseException {
		System.out.print("Ho va ten: ");
		this.hoTen = CauHinh.sc.nextLine();
		System.out.print("Gioi Tinh : ");
		this.gioiTinh = CauHinh.sc.nextLine();
		System.out.print("Nam Sinh : ");
		this.namSinh = F.parse(CauHinh.sc.nextLine());
	}
}