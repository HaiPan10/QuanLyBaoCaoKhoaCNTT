package baocao;

import connguoi.GiangVien;
import connguoi.SinhVien;

import java.util.List;

public class BaoCaoDoAn extends ThongTinChung {

    //==========Constructor Methods==========
    public BaoCaoDoAn(){
        super();
    }

    public BaoCaoDoAn(String ten, GiangVien giangVienHD, List<SinhVien> sinhVien){
        super(ten,giangVienHD,sinhVien);
    }

    //==========BaoCaoDoAn Methods/Behaviors==========

    @Override
    public void hienThi() {
        super.hienThi();
    }
}
