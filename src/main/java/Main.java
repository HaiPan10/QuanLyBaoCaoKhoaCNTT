import baocao.*;
import cauhinh.CauHinh;
import connguoi.*;
import hoidong.HoiDong;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static QuanLyBaoCao quanLy = new QuanLyBaoCao();
    public static List<HoiDong> danhSachHoiDong = new ArrayList<>();
    public static List<SinhVien> danhSachSinhVien = new ArrayList<>();
    public static List<GiangVien> danhSachGiangVien = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException, ParseException {
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

    public static void mainMenu() throws ParseException {
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

    public static void menuThucTap(){

    }

    public static void menuDoAn(){

    }

    public static void menuKhoaLuan(){

    }
}
