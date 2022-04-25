package hoidong;

import baocao.BaoCaoKhoaLuan;
import chuan.ITimKiem;

import java.util.ArrayList;
import java.util.List;

public class HoiDong implements ITimKiem<BaoCaoKhoaLuan> {

	private static final int MAX_THANH_VIEN = 5;
	private static final int MIN_THANH_VIEN = 3;

	private List<ThanhVienHoiDong> thanhVien;

	private List<BaoCaoKhoaLuan> danhSachKhoaLuan;

	private int maHoiDong;

	private static int dem = 0;

	{
		this.maHoiDong = ++dem;
	}

	//==========Constructor Methods==========

	public HoiDong() {
		this.thanhVien = new ArrayList<>();
		this.danhSachKhoaLuan = new ArrayList<>();
	}

	//==========Getter & Setter==========

	public int getMaHoiDong() {
		return maHoiDong;
	}

	public void setMaHoiDong(int maHoiDong) {
		this.maHoiDong = maHoiDong;
	}

	public static int getDem() {
		return dem;
	}

	public static void setDem(int dem) {
		HoiDong.dem = dem;
	}

	public List<ThanhVienHoiDong> getThanhVien() {
		return thanhVien;
	}

	public void setThanhVien(List<ThanhVienHoiDong> thanhVien) {
		this.thanhVien = thanhVien;
	}

	public List<BaoCaoKhoaLuan> getDanhSachKhoaLuan() {
		return danhSachKhoaLuan;
	}

	public void setDanhSachKhoaLuan(List<BaoCaoKhoaLuan> danhSachKhoaLuan) {
		this.danhSachKhoaLuan = danhSachKhoaLuan;
	}

	//==========Behaviors/Methods==========

	public void themThanhVienHoiDong(ThanhVienHoiDong thanhVien) {
		if (this.thanhVien.size() == 5)
			return;
		this.thanhVien.add(thanhVien);
	}

	public void themBaoCaoKhoaLuan(BaoCaoKhoaLuan baoCao) {
		this.danhSachKhoaLuan.add(baoCao);
		thanhVien.forEach(tv -> tv.addBaoCaoKhoaLuan(baoCao));
	}

	public void nhapDiem(int maBaoCao) {
		for (ThanhVienHoiDong tv : this.thanhVien) {
			tv.nhapDiem(maBaoCao);
		}
		capNhatDiem(maBaoCao);
	}

	public void nhapNhanXet(int maBaoCao) {
		for (ThanhVienHoiDong tv : this.thanhVien) {
			tv.nhapNhanXet(maBaoCao);
		}
	}

	public void suaDiem(int maBaoCao, int maGiangVien) {
		ThanhVienHoiDong tv = this.timKiemThanhVien(maGiangVien);
		if (tv != null) {
			tv.nhapDiem(maBaoCao);
			capNhatDiem(maBaoCao);
		}
	}

	public void suaNhanXet(int maBaoCao, int maGiangVien) {
		ThanhVienHoiDong tv = this.timKiemThanhVien(maGiangVien);
		if (tv != null)
			tv.nhapNhanXet(maBaoCao);
	}

	public ThanhVienHoiDong timKiemThanhVien(int maGiangVien) {
		for (ThanhVienHoiDong tv : this.thanhVien)
			if (tv.getThanhVienHoiDong().getMaSo() == maGiangVien)
				return tv;
		return null;
	}

	public void capNhatDiem(int maBaoCao){
		BaoCaoKhoaLuan baoCao = this.timKiem(maBaoCao);
		double diem = 0;
		for(ThanhVienHoiDong tv : this.thanhVien){
			diem += tv.timKiem(maBaoCao).getDiemBaoCao();
		}
		baoCao.setDiemBaoCao(diem / this.thanhVien.size());
	}

	@Override
	public BaoCaoKhoaLuan timKiem(int ma) {
		for(BaoCaoKhoaLuan baoCao : this.danhSachKhoaLuan){
			if(baoCao.getMaBaoCao() == ma)
				return baoCao;
		}
		return null;
	}

	public void hienThiNhanXet(int maBaoCao){
		for(ThanhVienHoiDong tv : this.thanhVien){
			System.out.printf("%s\nNhan xet: %s\n", tv.getChucVu(), tv.layNhanXet(maBaoCao).replaceAll("null","N/A"));
		}
	}
}