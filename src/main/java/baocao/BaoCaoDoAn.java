package baocao;

import connguoi.GiangVien;
import connguoi.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class BaoCaoDoAn extends ThongTinChung {

    private static List<SinhVien> daThamGia = new ArrayList<>();
    //==========Constructor Methods==========
    public BaoCaoDoAn(){
        super();
    }

    public BaoCaoDoAn(String ten, GiangVien giangVienHD, List<SinhVien> sinhVien) throws Exception {
        super(ten,giangVienHD,sinhVien);
        daThamGia.addAll(sinhVien);
    }

    //==========BaoCaoDoAn Methods/Behaviors==========

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String loaiBaoCao() {
        return "Bao Cao Do An";
    }

    /***
     * Kiem soat viec sinh vien da tung tham gia chua
     * @param sv
     * @return true / false
     */
    public static boolean isDaThamGia(List<SinhVien> sv){
        for(SinhVien sinhVien : daThamGia){
            for(SinhVien temp : sv){
                if(temp == sinhVien)
                    return true;
            }
        }
        return false;
    }
}
