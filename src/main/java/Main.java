import baocao.*;
import cauhinh.CauHinh;
import connguoi.*;
import hoidong.ChucVu;
import hoidong.HoiDong;
import hoidong.ThanhVienHoiDong;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static final int MAX_SO_LUONG = 2;
    public static QuanLyBaoCao quanLyBaoCao = new QuanLyBaoCao();
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

    public static HoiDong chonHoiDong() throws IndexOutOfBoundsException{
        int dem = 0;
        for(HoiDong hoiDong : danhSachHoiDong){
            System.out.printf("%d) %s",dem,hoiDong);
            ++dem;
        }
        System.out.print("Chon hoi dong: ");
        return danhSachHoiDong.get(Integer.parseInt(CauHinh.sc.nextLine()));
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

    public static void ghiFileGiangVien(GiangVien gv) throws FileNotFoundException, ParseException {
        File f = new File("src/main/resources/giangVien.txt");
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
            bw.append(gv.getHoTen());
            bw.append(gv.getGioiTinh());
            bw.append(CauHinh.F.format(gv.getNamSinh()));
            bw.append(gv.getHocHam());
            bw.append(gv.getHocVi());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ghiFileSinhVien(SinhVien sv) throws FileNotFoundException, ParseException {
        File f = new File("src/main/resources/sinhVien.txt");
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
            bw.append(sv.getHoTen());
            bw.append(sv.getGioiTinh());
            bw.append(CauHinh.F.format(sv.getNamSinh()));
            bw.append((String.valueOf(sv.getKhoaHoc())));
            bw.append(sv.getChuyenNganh());
            bw.close();
        } catch (IOException e) {
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

    public static BaoCao chonBaoCao(String instance) throws ClassNotFoundException {
        System.out.print("Nhap vao ma bao cao: ");
        int ma = Integer.parseInt(CauHinh.sc.nextLine());
        Class<?> c = Class.forName(instance);
        BaoCao baoCao = quanLyBaoCao.timKiem(ma);
        return c.isInstance(baoCao) ? baoCao:null;
    }
    
    public static ChucVu chonChucVu(){
        for(ChucVu cv : ChucVu.values()){
            System.out.printf("%s\n", cv);
        }
        System.out.print("Moi chon: ");
        return ChucVu.valueOf(CauHinh.sc.nextLine());
    }

    public static HoiDong thanhLapHoiDong(){
        HoiDong hoiDong = new HoiDong();
        while(true){
            int choose;
            ChucVu cv = chonChucVu();
            GiangVien gv = chonGiangVien();
            if(!hoiDong.kiemTraChucVu(cv))
                hoiDong.themThanhVienHoiDong(new ThanhVienHoiDong(hoiDong,cv,gv));
            else
                System.out.println("Chuc vu nay da co trong hoi dong.");
            System.out.print("Tiep tuc? 1 : Co | 2 : khong -> ");
            choose = Integer.parseInt(CauHinh.sc.nextLine());
            if(choose == 0)
                break;
        }
        return hoiDong.isDuThanhVien() ? hoiDong : null;
    }

    public static void mainMenu() throws ParseException, Exception{
        int choose;
        do{
            System.out.print("""
                    1. Menu Thuc Tap.
                    2. Menu Do An.
                    3. Menu Khoa Luan.
                    4. Tao sinh vien.
                    5. Tao giang vien.
                    6. Xem danh sach bao cao.
                    7. Sap xep theo ten bao cao.
                    8. Sap xep theo ngay bao cao.
                    9. Tim kiem.
                    10. Xoa bao cao.
                    11. Sua bao cao.
                    12. Thoat chuong trinh.
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

                case 6 -> {
                    quanLyBaoCao.getDanhSach().forEach(System.out::println);
                }

                default -> System.out.println("Ban chon thoat.\n");
            }
        }while(choose >= 1 && choose <= 11);
    }

    public static void menuThucTap() throws Exception {
        int choose;
        do{
            System.out.print("""
                    1. Tao Bao Thuc Tap Moi.
                    2. Tim Kiem Bao Cao Bang Ma Bao Cao.
                    3. Xem danh sach bao cao thuc tap.
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
                    quanLyBaoCao.timKiem(mbc);
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
                    quanLyBaoCao.timKiem(mbc);
                }
                default -> System.out.println("Ban chon thoat.\n");
            }
        }while(choose >= 1 && choose <= 3);
    }

    public static void menuKhoaLuan() throws Exception {
        int choose;
        do {
            System.out.print("""
                    1. Tao bao cao khoa luan.
                    2. Nhap diem.
                    3. Nhap nhan xet.
                    4. Nhap danh gia.
                    5. Sua diem.
                    6. Sua nhan xet.
                    7. Thanh lap hoi dong.
                    8. Exit.
                    """);
            choose = Integer.parseInt(CauHinh.sc.nextLine());
            switch(choose){
                case 1 -> {
                    HoiDong hoiDong = chonHoiDong();
                    GiangVien giangVien = chonGiangVien();
                    List<SinhVien> sv = chonSinhVien();
                    if(giangVien != null && hoiDong != null && sv.size() > 0){
                        System.out.print("Nhap vao ten bao cao: ");
                        String ten = CauHinh.sc.nextLine();
                        BaoCaoKhoaLuan baoCaoKhoaLuan = new BaoCaoKhoaLuan(hoiDong,ten,giangVien,sv);
                        quanLyBaoCao.them(baoCaoKhoaLuan);
                        hoiDong.themBaoCaoKhoaLuan(baoCaoKhoaLuan);
                    }
                }

                case 2 -> {
                    BaoCaoKhoaLuan baoCao = (BaoCaoKhoaLuan) chonBaoCao("BaoCaoKhoaLuan");
                    assert baoCao != null;
                    baoCao.getHoiDong().nhapDiem(baoCao.getMaBaoCao());
                }
                case 3 -> {
                    BaoCaoKhoaLuan baoCao = (BaoCaoKhoaLuan) chonBaoCao("BaoCaoKhoaLuan");
                    assert baoCao != null;
                    baoCao.getHoiDong().nhapNhanXet(baoCao.getMaBaoCao());
                }
                case 4 -> {
                    BaoCaoKhoaLuan baoCao = (BaoCaoKhoaLuan) chonBaoCao("BaoCaoKhoaLuan");
                    assert baoCao != null;
                    baoCao.nhapDanhGia();
                }
                case 5 -> {
                    BaoCaoKhoaLuan baoCao = (BaoCaoKhoaLuan) chonBaoCao("BaoCaoKhoaLuan");
                    assert baoCao != null;
                    HoiDong hoiDong = baoCao.getHoiDong();
                    System.out.print(hoiDong.getThongTin(baoCao.getMaBaoCao()));
                    System.out.print("Nhap vao ma giang vien: ");
                    int ma = Integer.parseInt(CauHinh.sc.nextLine());
                    hoiDong.suaDiem(baoCao.getMaBaoCao(), ma);
                }
                case 6 -> {
                    BaoCaoKhoaLuan baoCao = (BaoCaoKhoaLuan) chonBaoCao("BaoCaoKhoaLuan");
                    assert baoCao != null;
                    HoiDong hoiDong = baoCao.getHoiDong();
                    System.out.print(hoiDong.getThongTin(baoCao.getMaBaoCao()));
                    System.out.print("Nhap vao ma giang vien: ");
                    int ma = Integer.parseInt(CauHinh.sc.nextLine());
                    hoiDong.suaNhanXet(baoCao.getMaBaoCao(), ma);
                }
                case 7 -> {
                    HoiDong hd = thanhLapHoiDong();
                    assert hd != null;
                    themHoiDong(hd);
                }
                default -> System.out.println("Quay ve menu chinh.");
            }
        }while(choose >= 1 && choose <= 7);
    }
}
