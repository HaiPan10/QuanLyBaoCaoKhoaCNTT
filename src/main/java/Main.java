import baocao.*;
import cauhinh.CauHinh;
import connguoi.*;
import hoidong.HoiDong;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static QuanLyBaoCao quanLy = new QuanLyBaoCao();
    public static List<HoiDong> danhSachHoiDong = new ArrayList<>();
    public static List<SinhVien> danhSachSinhVien = new ArrayList<>();
    public static List<GiangVien> danhSachGiangVien = new ArrayList<>();
    public static List<SinhVien> csv;
    public static GiangVien chonGiangVien() {
        int dem = 0;
        for (GiangVien gv : danhSachGiangVien) {
            System.out.printf("%d : %s",(++dem), gv.getHoTen());
        }
        System.out.print("Nhap giang vien ban chon : ");
        int sgv = Integer.parseInt(CauHinh.sc.nextLine());
        for(int i = 0; i < danhSachGiangVien.size(); i++){
            if(danhSachGiangVien.indexOf(i) == sgv)
                return danhSachGiangVien.get(sgv);
        }
        return null;
    }
    public static List<SinhVien> chonSinhVien() {
        for(SinhVien sv : danhSachSinhVien){
            System.out.printf("Ma So: %d\nHo va Ten: %s\n", sv.getMaSo(), sv.getHoTen());
        }
        System.out.print("Nhap vao ma so cua sinh vien ban chon : ");
        int msv = Integer.parseInt(CauHinh.sc.nextLine());
        for(SinhVien sv : danhSachSinhVien){
            if(sv.getMaSo() == msv) {
                csv.add(sv);
                return csv;
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException, ParseException, Exception {
        mainMenu();
        System.out.println("SHUTDOWN SYSTEM");
    }

    public static void themHoiDong(HoiDong hoiDong){
        danhSachHoiDong.add(hoiDong);
    }

    public static void themSinhVien(SinhVien sv){
        danhSachSinhVien.add(sv);
    }

    public static void themGiangVien(GiangVien gv){
        danhSachGiangVien.add(gv);
    }

    public static void mainMenu() throws ParseException, Exception{
        int choose;
        do{
            System.out.print("""
                    1. Menu Thuc Tap
                    2. Menu Do An
                    3. Menu Khoa Luan
                    4. Tao sinh vien
                    5. Tao giang vien
                    6. Thoat chuong trinh
                    Moi chon:\s""");
            choose = Integer.parseInt(CauHinh.sc.nextLine());
            switch (choose) {
                case 1 -> menuThucTap();
                case 2 -> menuDoAn();
                case 3 -> menuKhoaLuan();
                case 4 -> {
                    SinhVien sv = new SinhVien();
                    sv.nhap();
                    themSinhVien(sv);
                }
                case 5 -> {
                    GiangVien gv = new GiangVien();
                    gv.nhap();
                    themGiangVien(gv);
                }
                default -> System.out.println("Ban chon thoat.\n");
            }
        }while(choose >= 1 && choose <= 6);
    }

    public static void menuThucTap() throws Exception {
        int choose;
        do{
            System.out.print("""
                    1. Tao Bao Thuc Tap Moi
                    2. Tim Kiem Bao Cao Bang Ma Bao CaoS
                    3. Thoat chuong trinh
                    Moi chon:\s""");
            choose = Integer.parseInt(CauHinh.sc.nextLine());
            switch (choose) {
                case 1 -> {
                    System.out.print("Nhap ten bao cao : ");
                    String tenbc = CauHinh.sc.nextLine();
                    GiangVien cgv = chonGiangVien();
                    List <SinhVien> dssv = chonSinhVien();
                    System.out.print("Chon thanh cong\nBan co muon chon them sinh vien hay khong ? Them : 1 ?  Khong : 0\n");
                    int them = Integer.parseInt(CauHinh.sc.nextLine());
                    if(them == 1 && dssv != null){
                        dssv.addAll(chonSinhVien());
                    }
                    else{
                        BaoCaoThucTap bctt = new BaoCaoThucTap(tenbc, cgv, dssv);
                    }
                }
                case 2 -> {
                    System.out.print("Nhap ma bao cao ban dang can tim : ");
                    int mbc = Integer.parseInt(CauHinh.sc.nextLine());
                    quanLy.timKiem(mbc);
                }
                default -> System.out.println("Ban chon thoat.\n");
            }
        }while(choose >= 1 && choose <= 3);
    }

    public static void menuDoAn(){

    }

    public static void menuKhoaLuan(){

    }
}
