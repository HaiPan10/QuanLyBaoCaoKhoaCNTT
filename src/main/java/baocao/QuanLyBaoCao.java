package baocao;

import java.util.ArrayList;

public class QuanLyBaoCao {
    private ArrayList<BaoCao> danhSach;

    public QuanLyBaoCao(){
        this.setDanhSach(new ArrayList<>());
    }

    public ArrayList<BaoCao> getDanhSach() {
        return danhSach;
    }

    public void setDanhSach(ArrayList<BaoCao> danhSach) {
        this.danhSach = danhSach;
    }

    public void them(BaoCaoThucTap baoCao){
        this.danhSach.add(baoCao);
    }

    public void xoa(BaoCaoThucTap baoCao){

    }
}