package baocao;

import cauhinh.CauHinh;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class QuanLyBaoCao {
    private List<BaoCao> danhSach;

    public QuanLyBaoCao(){
        setDanhSach(new ArrayList<>());
    }

    public List<BaoCao> getDanhSach() {
        return danhSach;
    }

    public void setDanhSach(List<BaoCao> danhSach) {
        this.danhSach = danhSach;
    }

    //==========QuanLyBaoCao Methods==========

    public void them(BaoCao baoCao){
        danhSach.add(baoCao);
    }

    public BaoCao timKiem(int maBaoCao){
        for(BaoCao baoCao : danhSach){
            if(baoCao.getMaBaoCao() == maBaoCao)
                return baoCao;
        }
        return null; //value not found
    }

    public void xoa(int maBaoCao) {
        try{
            danhSach.remove(this.timKiem(maBaoCao));
        } catch (NullPointerException | UnsupportedOperationException exception) {
            System.out.println("Value Not Found");
        } finally {
            System.out.println("DONE");
        }
    }

    public void sua(int maBaoCao){
        BaoCao baoCao = this.timKiem(maBaoCao);
        try{
            System.out.print("Nhap vao ten bao cao: ");
            baoCao.setTenBaoCao(CauHinh.sc.nextLine());
            baoCao.nhapDiem();
            baoCao.nhapNgayBaoCao();
        } catch (ParseException e) {
            System.out.println("ERROR");
        }
    }
}
