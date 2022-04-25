package hoidong;

import chuan.ITimKiem;

import java.util.ArrayList;
import java.util.List;

public class QuanLyHoiDong implements ITimKiem<HoiDong> {

    private List<HoiDong> danhSachHoiDong;


    //==========Constructor Methods==========
    public QuanLyHoiDong(){
        this.setDanhSachHoiDong(new ArrayList<>());
    }

    //==========Getter & Setter==========
    public List<HoiDong> getDanhSachHoiDong() {
        return danhSachHoiDong;
    }

    public void setDanhSachHoiDong(List<HoiDong> danhSachHoiDong) {
        this.danhSachHoiDong = danhSachHoiDong;
    }

    //==========QuanLyBaoCao Methods==========
    @Override
    public HoiDong timKiem(int ma) {
        for(HoiDong hd : getDanhSachHoiDong()){
            if(hd.getMaHoiDong() == ma)
                return hd;
        }
        return null;
    }
}
