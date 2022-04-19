package baocao;

import connguoi.GiangVien;
import connguoi.SinhVien;

public abstract class ThongTinChung extends BaoCao {
    private double tyLeDaoVan;

    public ThongTinChung(){
        super();
    }

    public ThongTinChung(String ten, GiangVien giangVienHD, SinhVien[] sinhVien){
        super(ten,giangVienHD,sinhVien);
    }

    public double getTyLeDaoVan() {
        return tyLeDaoVan;
    }

    public void setTyLeDaoVan(double tyLeDaoVan) {
        this.tyLeDaoVan = tyLeDaoVan;
    }
}
