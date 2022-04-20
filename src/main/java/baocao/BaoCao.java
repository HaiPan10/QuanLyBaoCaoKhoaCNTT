package baocao;

import cauhinh.CauHinh;
import connguoi.GiangVien;
import connguoi.SinhVien;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public abstract class BaoCao {
	private static int dem = 0;
	private int maBaoCao;
	private String tenBaoCao;
	private String chuoiLink;
	private Date ngayBaoCao;
	private GiangVien giangVienHD;
	private double diemBaoCao;
	private List<SinhVien> sinhVienThucHien;

	//Initialization Block
	{
		++dem;
	}

	//==========CONSTRUCTORS==========
	public BaoCao(){
		this.setMaBaoCao(dem);
	}

	public BaoCao(String ten, GiangVien giangVienHD, List<SinhVien> sinhVien){
		this();
		this.setTenBaoCao(ten);
		this.setGiangVienHD(giangVienHD);
		this.setSinhVienThucHien(sinhVien);
		this.diemBaoCao = -1;
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

	public String getChuoiLink() {
		return chuoiLink;
	}

	public void setChuoiLink(String chuoiLink) {
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

	public List<SinhVien> getSinhVienThucHien() {
		return sinhVienThucHien;
	}

	public void setSinhVienThucHien(List<SinhVien> sinhVienThucHien) {
		this.sinhVienThucHien = sinhVienThucHien;
	}

	//==========BAO CAO METHODS==========
	public void nhapNgayBaoCao() throws ParseException {
		System.out.print("Nhap ngay bao cao\n");
		String ngay = CauHinh.sc.nextLine();
		this.setNgayBaoCao(CauHinh.F.parse(ngay));
	}

	public void nhapDiem(){
		double diem = 0;
		System.out.println("Nhap diem: ");
		diem = Double.parseDouble(CauHinh.sc.nextLine());
		this.setDiemBaoCao(diem);
	}

	public void nhapChuoiLink(){
		System.out.print("Nhap vao chuoi link: ");
		this.setChuoiLink(CauHinh.sc.nextLine());
	}

	public void hienThi(){
		System.out.printf("Ma bao cao: %d\nTen bao cao: %s\nGiang vien huong dan: %s\n",
				this.maBaoCao,this.tenBaoCao, this.giangVienHD.getHoTen());
		for(int i = 0; i < sinhVienThucHien.size(); i++){
			System.out.printf("Sinh vien %d: %s\n", i + 1, sinhVienThucHien.get(i).getHoTen());
		}
		//Thong tin co the khong duoc cung cap
		if(this.chuoiLink != null)
			System.out.printf("Chuoi link: %s\n", this.chuoiLink);
		if(this.ngayBaoCao != null)
			System.out.printf("Ngay bao cao: %s", CauHinh.F.format(this.ngayBaoCao));
		if(this.diemBaoCao > -1){
			System.out.printf("Diem bao cao: %.1f", this.diemBaoCao);
		}
	}
}
