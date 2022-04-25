package hoidong;

import baocao.BaoCaoKhoaLuan;
import chuan.ITimKiem;
import connguoi.GiangVien;

import java.util.ArrayList;
import java.util.List;

public class ThanhVienHoiDong implements ITimKiem<ChamDiem> {

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

	public void nhapDiem(int maBaoCao){
		ChamDiem cd = this.timKiem(maBaoCao);
		if(cd != null){
			System.out.println(this.chucVu);
			cd.nhapDiem();
		}
	}

	public void nhapNhanXet(int maBaoCao) {
		ChamDiem cd = this.timKiem(maBaoCao);
		if (cd != null)
			cd.nhapNhanXet();
	}

	public String layNhanXet(int maBaoCao){
		ChamDiem cd = this.timKiem(maBaoCao);
		if(cd != null){
			return cd.getNhanXet();
		}
		return "N/A";
	}

	@Override
	public ChamDiem timKiem(int ma) {
		for(ChamDiem cd : danhSachChamDiem){
			if(cd.getBaoCao().getMaBaoCao() == ma)
				return cd;
		}
		return null;
	}

	public String getThongTin(int ma){
		ChamDiem cd = this.timKiem(ma);
		GiangVien gv = this.getThanhVienHoiDong();
		return String.format("%d - %s - Chuc vu: %s - Diem: %.1f - Nhan xet: %s",
				gv.getMaSo(),gv.getHoTen(), this.chucVu, cd.getDiemBaoCao(), cd.getNhanXet());
	}
}
