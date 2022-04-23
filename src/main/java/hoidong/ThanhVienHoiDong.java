package hoidong;

import baocao.BaoCaoKhoaLuan;
import chuan.ITimKiemBaoCao;
import connguoi.GiangVien;

import java.util.ArrayList;
import java.util.List;

public class ThanhVienHoiDong implements ITimKiemBaoCao<Boolean> {

	private HoiDong hoiDong;

	private ChucVu chucVu;

	private GiangVien thanhVienHoiDong;

	private List<ChamDiem> danhSachChamDiem;

	//==========CONSTRUCTORS==========

	public ThanhVienHoiDong(HoiDong hoiDong, ChucVu chucVu, GiangVien giangVien){
		this.hoiDong = hoiDong;
		this.chucVu = chucVu;
		this.thanhVienHoiDong = giangVien;
		setDanhSachChamDiem(new ArrayList<>());
	}

	//==========Getter & Setter==========

	public HoiDong getHoiDong() {
		return hoiDong;
	}

	public void setHoiDong(HoiDong hoiDong) {
		this.hoiDong = hoiDong;
	}

	public ChucVu getChucVu() {
		return chucVu;
	}

	public void setChucVu(ChucVu chucVu) {
		this.chucVu = chucVu;
	}

	public GiangVien getThanhVienHoiDong() {
		return thanhVienHoiDong;
	}

	public void setThanhVienHoiDong(GiangVien thanhVienHoiDong) {
		this.thanhVienHoiDong = thanhVienHoiDong;
	}

	public List<ChamDiem> getDanhSachChamDiem() {
		return danhSachChamDiem;
	}

	public void setDanhSachChamDiem(List<ChamDiem> danhSachChamDiem) {
		this.danhSachChamDiem = danhSachChamDiem;
	}

	//==========Methods/Behaviors==========
	public void addBaoCaoKhoaLuan(BaoCaoKhoaLuan baoCaoKhoaLuan){
		ChamDiem cd = new ChamDiem(baoCaoKhoaLuan);
		this.danhSachChamDiem.add(cd);
	}

	@Override
	public ChamDiem timKiem(int maBaoCao) {
//		for(ChamDiem cd  : danhSachChamDiem){
//			if(cd.getBaoCao().getMaBaoCao() == maBaoCao){
//				return cd;
//			}
//		}
		return null;
	}

}
