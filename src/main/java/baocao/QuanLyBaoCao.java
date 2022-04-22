package baocao;

import cauhinh.CauHinh;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            CauHinh.sayNotFound();
        } finally {
            CauHinh.sayDone();
        }
    }

    public void sua(int maBaoCao){
        BaoCao baoCao = this.timKiem(maBaoCao);
        try{
            System.out.print("Nhap vao ten bao cao: ");
            baoCao.setTenBaoCao(CauHinh.sc.nextLine());
            baoCao.nhapDiem();
            baoCao.nhapNgayBaoCao();
            baoCao.nhapChuoiLink();
        } catch (ParseException e) {
            CauHinh.sayError();
        } finally{
            CauHinh.sayDone();
        }
    }

    public List<BaoCao> xuatDanhSach(String instance) throws ClassNotFoundException {
        Class<?> c = Class.forName(instance);
        return this.danhSach.stream().filter(c::isInstance).collect(Collectors.toList());
    }

    public void hienThiDanhSach(String instance) throws ClassNotFoundException {
        this.xuatDanhSach(instance).forEach(baoCao->System.out.println(baoCao.toString()));
    }
}
