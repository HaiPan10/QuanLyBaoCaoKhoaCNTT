package hoidong;

import baocao.BaoCaoKhoaLuan;
import cauhinh.CauHinh;

public class ChamDiem {
    private String nhanXet;
    private double diemBaoCao;
    private BaoCaoKhoaLuan baoCao;

    //==========CONSTRUCTORS==========
    public ChamDiem(BaoCaoKhoaLuan baoCao){
        this.baoCao = baoCao;
    }

    //==========Getter & Setter==========
    public String getNhanXet() {
        return nhanXet;
    }

    public void setNhanXet(String nhanXet) {
        this.nhanXet = nhanXet;
    }

    public double getDiemBaoCao() {
        return diemBaoCao;
    }

    public void setDiemBaoCao(double diemBaoCao) {
        this.diemBaoCao = diemBaoCao;
    }

    public BaoCaoKhoaLuan getBaoCao() {
        return baoCao;
    }

    public void setBaoCao(BaoCaoKhoaLuan baoCao) {
        this.baoCao = baoCao;
    }

    //==========Methods/Behaviors==========
    public void nhapDiem(){
        System.out.print("Nhao vao diem: ");
        this.setDiemBaoCao(Double.parseDouble(CauHinh.sc.nextLine()));
    }

    public void nhapNhanXet(){
        System.out.print("Nhap vao nhan xet: ");
        this.setNhanXet(CauHinh.sc.nextLine());
    }
}
