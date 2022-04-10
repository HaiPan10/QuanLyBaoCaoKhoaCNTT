package baocao;

import connguoi.GiangVien;
import connguoi.SinhVien;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BaoCao {
	public static final Scanner sc = new Scanner(System.in);
	public static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
	private int maBaoCao;
	private String tenBaoCao;
	private String[] chuoiLink;
	private Date ngayBaoCao;
	private GiangVien giangVienHD;
	private double diemBaoCao;
	private SinhVien[] sinhVienThucHien;

	//==========CONSTRUCTORS==========
	public BaoCao(){

	}

	public BaoCao(int maBaoCao){
		this.setMaBaoCao(maBaoCao);
	}

	public BaoCao(int maBaoCao, String ten, GiangVien giangVienHD, SinhVien[] sinhVien){
		this(maBaoCao);
		this.setTenBaoCao(ten);
		this.setGiangVienHD(giangVienHD);
		this.setSinhVienThucHien(sinhVien);
	}

	//==========GETTER & SETTER METHODS==========
	public int getMaBaoCao() {
		return maBaoCao;
	}

	public void setMaBaoCao(int maBaoCao) {
		this.maBaoCao = maBaoCao;
	}

	public String getTenBaoCao() {
		return tenBaoCao;
	}

	public void setTenBaoCao(String tenBaoCao) {
		this.tenBaoCao = tenBaoCao;
	}

	public String[] getChuoiLink() {
		return chuoiLink;
	}

	public void setChuoiLink(String[] chuoiLink) {
		this.chuoiLink = chuoiLink;
	}

	public Date getNgayBaoCao() {
		return ngayBaoCao;
	}

	public void setNgayBaoCao(Date ngayBaoCao) {
		this.ngayBaoCao = ngayBaoCao;
	}

	public GiangVien getGiangVienHD() {
		return giangVienHD;
	}

	public void setGiangVienHD(GiangVien giangVienHD) {
		this.giangVienHD = giangVienHD;
	}

	public double getDiemBaoCao() {
		return diemBaoCao;
	}

	public void setDiemBaoCao(double diemBaoCao) {
		this.diemBaoCao = diemBaoCao;
	}

	public SinhVien[] getSinhVienThucHien() {
		return sinhVienThucHien;
	}

	public void setSinhVienThucHien(SinhVien[] sinhVienThucHien) {
		this.sinhVienThucHien = sinhVienThucHien;
	}

	//==========BAO CAO METHODS==========
	public void nhapNgayBaoCao() throws ParseException {
		System.out.print("Nhap ngay bao cao\n");
		String ngay = sc.nextLine();
		this.setNgayBaoCao(F.parse(ngay));
	}

	public void nhapDiem(double diem){
		this.setDiemBaoCao(diem);
	}

	public void nhapThongTin(){
		System.out.print("Nhap vao ten bao cao: ");

	}

	public void hienThiSinhVien() {

	}

	public void hienThiChuoiLink() {

	}
}
