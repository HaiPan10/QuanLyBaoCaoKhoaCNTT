import baocao.*;
import cauhinh.CauHinh;
import connguoi.*;
import hoidong.HoiDong;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;


public class Main {
    public static final int MAX_SO_LUONG = 2;
    public static QuanLyBaoCao quanLy = new QuanLyBaoCao();
    public static List<HoiDong> danhSachHoiDong = new ArrayList<>();
    public static List<SinhVien> danhSachSinhVien = new ArrayList<>();
    public static List<GiangVien> danhSachGiangVien = new ArrayList<>();
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
        int choose;
        List <SinhVien> csv = new ArrayList<>();
        for(SinhVien sv : danhSachSinhVien){
            System.out.printf("Ma So: %d\nHo va Ten: %s\n", sv.getMaSo(), sv.getHoTen());
        }
        while(true) {
            System.out.print("Nhap vao ma so cua sinh vien ban chon : ");
            int msv = Integer.parseInt(CauHinh.sc.nextLine());
            for (SinhVien sv : danhSachSinhVien) {
                if (sv.getMaSo() == msv) {
                    csv.add(sv);
                }
            }
            if(csv.size() == MAX_SO_LUONG){
                break;
            }
            System.out.print("Tiep tuc chon: YES : 1 - NO : 0");
            choose = Integer.parseInt(CauHinh.sc.nextLine());
            if(choose == 0){
                break;
            }
        }
        return csv;
    }
    public static void docFileGiangVien() throws FileNotFoundException {
        File F = new File("giangVien.txt");
        try(Scanner doc = new Scanner(F)) {
            if (doc.hasNext()) {
               String t = doc.nextLine();
               CauHinh.sc.nextLine();
               String gt = doc.nextLine();
               CauHinh.sc.nextLine();
               String ns = doc.nextLine();
               CauHinh.sc.nextLine();
               String hv = doc.nextLine();
               CauHinh.sc.nextLine();
               String hh = doc.nextLine();
               GiangVien ngv = new GiangVien(t, gt, ns, hv, hh);
               danhSachGiangVien.add(ngv);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static void docFileSinhVien() throws FileNotFoundException {
        File F = new File("sinhVien.txt");
        try(Scanner doc = new Scanner(F)) {
            if (doc.hasNext()) {
                String t = doc.nextLine();
                CauHinh.sc.nextLine();
                String gt = doc.nextLine();
                CauHinh.sc.nextLine();
                String ns = doc.nextLine();
                CauHinh.sc.nextLine();
                int kh = doc.nextInt();
                CauHinh.sc.nextLine();
                String cn = doc.nextLine();
                SinhVien nsv = new SinhVien(t, gt, ns, kh, cn);
                danhSachSinhVien.add(nsv);
            }
        } catch (ParseException e) {
            e.printStackTrace();
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
                    2. Tim Kiem Bao Cao Bang Ma Bao Cao
                    3. Thoat chuong trinh
                    Moi chon:\s""");
            choose = Integer.parseInt(CauHinh.sc.nextLine());
            switch (choose) {
                case 1 -> {
                    System.out.print("Nhap ten bao cao : ");
                    String tenbc = CauHinh.sc.nextLine();
                    GiangVien cgv = chonGiangVien();
                    BaoCaoThucTap bctt = new BaoCaoThucTap(tenbc, cgv, chonSinhVien());
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

    public static void menuDoAn() throws Exception {
        int choose;
        do{
            System.out.print("""
                    1. Tao Bao Do An Moi
                    2. Tim Kiem Bao Cao Bang Ma Bao Cao
                    3. Thoat chuong trinh
                    Moi chon:\s""");
            choose = Integer.parseInt(CauHinh.sc.nextLine());
            switch (choose) {
                case 1 -> {
                    System.out.print("Nhap ten bao cao : ");
                    String tenbc = CauHinh.sc.nextLine();
                    GiangVien cgv = chonGiangVien();
                    BaoCaoDoAn bcda = new BaoCaoDoAn(tenbc, cgv ,chonSinhVien());
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
    public static void menuKhoaLuan(){

    }
}
