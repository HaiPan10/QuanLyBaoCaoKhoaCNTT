package baocao;

import java.util.ArrayList;

public class QuanLyBaoCao {
    private ArrayList<BaoCao> danhSachThucTap;
    private ArrayList<BaoCao> danhSachDoAn;
    private ArrayList<BaoCao> danhSachKhoaLuan;

    public QuanLyBaoCao(){
        this.setDanhSachThucTap(new ArrayList<>());
        this.setDanhSachDoAn(new ArrayList<>());
        this.setDanhSachKhoaLuan(new ArrayList<>());
    }

    public ArrayList<BaoCao> getDanhSachThucTap() {
        return danhSachThucTap;
    }

    public void setDanhSachThucTap(ArrayList<BaoCao> danhSachThucTap) {
        this.danhSachThucTap = danhSachThucTap;
    }

    public ArrayList<BaoCao> getDanhSachDoAn() {
        return danhSachDoAn;
    }

    public void setDanhSachDoAn(ArrayList<BaoCao> danhSachDoAn) {
        this.danhSachDoAn = danhSachDoAn;
    }

    public ArrayList<BaoCao> getDanhSachKhoaLuan() {
        return danhSachKhoaLuan;
    }

    public void setDanhSachKhoaLuan(ArrayList<BaoCao> danhSachKhoaLuan) {
        this.danhSachKhoaLuan = danhSachKhoaLuan;
        this.danhSachKhoaLuan.add(new BaoCaoKhoaLuan());
    }

    public void them(BaoCaoKhoaLuan baoCao){
        this.danhSachKhoaLuan.add(baoCao);
    }

    public void them(BaoCaoDoAn baoCao){
        this.danhSachDoAn.add(baoCao);
    }

    public void them(BaoCaoThucTap baoCao){
        this.danhSachThucTap.add(baoCao);
    }

    public void xoa(BaoCaoThucTap baoCao){

    }
}