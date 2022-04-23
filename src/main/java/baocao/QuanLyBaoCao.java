package baocao;

import cauhinh.CauHinh;
import chuan.ITimKiem;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLyBaoCao implements ITimKiem<BaoCao> {
    private List<BaoCao> danhSach;

    //==========Getter & Setter==========

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

    @Override
    /**
     *
     * @param maBaoCao
     * @return BaoCao
     */
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

    public List<BaoCao> xuatDanhSach(String instance) throws ClassNotFoundException {
        Class<?> c = Class.forName(instance);
        return this.danhSach.stream().filter(c::isInstance).collect(Collectors.toList());
    }

    public void hienThiDanhSach(String instance) throws ClassNotFoundException {
        this.xuatDanhSach(instance).forEach(baoCao->System.out.println(baoCao.toString()));
    }

    public void sapXepTheoNgayBaoCao(){
        this.danhSach.sort((bc1,bc2)->{
            String loai1 = bc1.getClass().toString();
            String loai2 = bc2.getClass().toString();
            if(loai1.equals(loai2)){
                //Truong hop 1 trong 2 khong bik ngay bao cao
                if(bc1.getNgayBaoCao() == null)
                    return -1;
                else if(bc2.getNgayBaoCao() == null)
                    return 1;
                else if(bc1.getNgayBaoCao() == null && bc2.getNgayBaoCao() == null)
                    return 0;
                return bc1.getNgayBaoCao().compareTo(bc2.getNgayBaoCao());
            }
            return loai1.compareTo(loai2);
        });
    }

    public void sapXepTheoTenBaoCao(){
        this.danhSach.sort((bc1,bc2)->{
            String loai1 = bc1.getClass().toString();
            String loai2 = bc2.getClass().toString();
            if(loai1.equals(loai2)){
                return bc1.getTenBaoCao().compareTo(bc2.getTenBaoCao());
            }
            return loai1.compareTo(loai2);
        });
    }

    /**
     * Overloading BaoCao timKiem(int maBaoCao)
     * @param ten
     * @param nbc
     * @return Danh sach cac bao cao
     */
    public List<BaoCao> timKiem(String ten, Date nbc){
        return this.danhSach.stream().filter(t ->(t.getTenBaoCao().contains(ten) && t.getNgayBaoCao().compareTo(nbc) == 0)).collect(Collectors.toList());
    }
}
