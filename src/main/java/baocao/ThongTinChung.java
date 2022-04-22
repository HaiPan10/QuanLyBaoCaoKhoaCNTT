package baocao;

import cauhinh.CauHinh;
import connguoi.GiangVien;
import connguoi.SinhVien;

import java.util.List;

public abstract class ThongTinChung extends BaoCao {
    private double tyLeDaoVan;

    public ThongTinChung(){
        super();
    }

    public ThongTinChung(String ten, GiangVien giangVienHD, List<SinhVien> sinhVien){
        super(ten,giangVienHD,sinhVien);
    }

    //==========Getter & Setter==========

    public double getTyLeDaoVan() {
        return tyLeDaoVan;
    }

    public void setTyLeDaoVan(double tyLeDaoVan) {
        this.tyLeDaoVan = tyLeDaoVan;
    }

    //==========Methods/Behaviors==========

    public void nhapTyLeDaoVan(){
        System.out.print("Nhap ty le dao van: ");
        this.tyLeDaoVan = Double.parseDouble(CauHinh.sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Ty le dao van: %.1f\n", this.tyLeDaoVan);
    }
}
