package baocao;

import cauhinh.CauHinh;
import connguoi.GiangVien;
import connguoi.SinhVien;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public abstract class BaoCao {
	private static int dem = 0;
	private static final int MAX_SINHVIEN = 2;
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

	public BaoCao(String ten, GiangVien giangVienHD, List<SinhVien> sinhVien) throws Exception {
		this();
		if(sinhVien.size() > MAX_SINHVIEN)
			throw new Exception("InvalidData");
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

	public void nhapDiem(double diem){
		this.diemBaoCao = diem;
	}

	public void nhapChuoiLink(){
		System.out.print("Nhap vao chuoi link: ");
		this.setChuoiLink(CauHinh.sc.nextLine());
	}

	/**
	 *
	 * @return Chuoi bao gom ten cua tung sinh vien thuc hien
	 */
	public String getTenSinhVienThucHien(){
		if(this.sinhVienThucHien == null)
			return "null";
		StringBuilder sb = new StringBuilder();
		for(SinhVien sv : this.sinhVienThucHien){
			sb.append(sv.getHoTen());
			if(this.sinhVienThucHien.indexOf(sv) != this.sinhVienThucHien.size() - 1){
				sb.append(", ");
			}
		}
		return sb.toString();
	}

	public String getTenGiangVienHD(){
		if(this.giangVienHD == null)
			return "null";
		return this.giangVienHD.getHoTen();
	}

	/**
	 * Overloading của getNgayBaoCao()
	 * @param ngay
	 * @return Chuoi ngay thang nam
	 */
	public String getNgayBaoCao(Date ngay){
		if(ngay == null)
			return null;
		return CauHinh.F.format(ngay);
	}

	public abstract String loaiBaoCao();

	public String toString(){
		return String.format("Loai bao cao: %s\nMa bao cao: %d\nTen bao cao: %s\nChuoi link: %s\nNgay bao cao: %s\n" +
				"Sinh vien thuc hien: %s\nGiang vien huong dan: %s\n" +
				"Diem bao cao: %.1f\n",this.loaiBaoCao(),this.maBaoCao, this.tenBaoCao, this.chuoiLink,
				this.getNgayBaoCao(this.ngayBaoCao), this.getTenSinhVienThucHien(),this.getTenGiangVienHD(),
				this.diemBaoCao).replaceAll("null", "N/A");
	}
}
