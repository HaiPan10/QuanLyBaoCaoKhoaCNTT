import baocao.*;
import cauhinh.CauHinh;
import connguoi.*;
import hoidong.ChucVu;
import hoidong.HoiDong;
import hoidong.ThanhVienHoiDong;

import java.io.*;
import java.text.Format;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static final int MAX_SO_LUONG = 2;
    public static QuanLyBaoCao quanLyBaoCao = new QuanLyBaoCao();
    public static List<HoiDong> danhSachHoiDong = new ArrayList<>();
    public static List<SinhVien> danhSachSinhVien = new ArrayList<>();
    public static List<GiangVien> danhSachGiangVien = new ArrayList<>();
    public static GiangVien chonGiangVien() {
        for (GiangVien gv : danhSachGiangVien) {
            System.out.printf("%d : %s\n",gv.getMaSo(), gv.getHoTen());
        }
        System.out.print("Nhap ma giang vien ban chon : ");
        int sgv = Integer.parseInt(CauHinh.sc.nextLine());
        for(GiangVien gv : danhSachGiangVien){
            if(gv.getMaSo() == sgv){
                System.out.println("Chon thanh cong");
                return gv;
            }
        }
        return null;
    }

    public static List<SinhVien> chonSinhVien() {
        int choose;
        List <SinhVien> csv = new ArrayList<>();
        for(SinhVien sv : danhSachSinhVien){
            System.out.printf("%d : %s\n", sv.getMaSo(), sv.getHoTen());
        }
        while(true) {
            System.out.print("Nhap vao ma so cua sinh vien ban chon : ");
            int msv = Integer.parseInt(CauHinh.sc.nextLine());
            for (SinhVien sv : danhSachSinhVien) {
                if (sv.getMaSo() == msv) {
                    System.out.println("Chon thanh cong");
                    csv.add(sv);
                    break;
                }
            }
            if(csv.size() == MAX_SO_LUONG){
                break;
            }
            System.out.print("Tiep tuc chon: YES : 1 - NO : 0 -> ");
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
            System.out.printf("%d)\n%s",dem,hoiDong);
            ++dem;
        }
        System.out.print("Chon hoi dong: ");
        return danhSachHoiDong.get(Integer.parseInt(CauHinh.sc.nextLine()));
    }

    public static void docFileGiangVien() throws FileNotFoundException {
        File F = new File("src/main/resources/giangVien.txt");
        try(Scanner doc = new Scanner(F)) {
            while (doc.hasNext()) {
                String t = doc.nextLine();
                String gt = doc.nextLine();
                String ns = doc.nextLine();
                String hv = doc.nextLine();
                String hh = doc.nextLine();
                GiangVien ngv = new GiangVien(t, gt, ns, hv, hh);
                danhSachGiangVien.add(ngv);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void docFileSinhVien() throws FileNotFoundException {
        File F = new File("src/main/resources/sinhVien.txt");
        try(Scanner doc = new Scanner(F)) {
            while (doc.hasNext()) {
                String t = doc.nextLine();
                String gt = doc.nextLine();
                String ns = doc.nextLine();
                int kh = Integer.parseInt(doc.nextLine());
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
        docFileSinhVien();
        docFileGiangVien();
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
            try{
                ChucVu cv = chonChucVu();
                GiangVien gv = chonGiangVien();
                if(!hoiDong.kiemTraChucVu(cv))
                    hoiDong.themThanhVienHoiDong(new ThanhVienHoiDong(hoiDong,cv,gv));
                else
                    System.out.println("Chuc vu nay da co trong hoi dong.");
            } catch (IllegalArgumentException exception){
                CauHinh.sayError();
            }
            System.out.print("Tiep tuc? 1 : Co | 2 : khong -> ");
            choose = Integer.parseInt(CauHinh.sc.nextLine());
            if(choose == 0)
                break;
        }
        return hoiDong.isDuThanhVien() ? hoiDong : null;
    }

    public static void mainMenu() throws Exception{
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
                    ghiFileSinhVien(sv);
                }
                case 5 -> {
                    GiangVien gv = new GiangVien();
                    gv.nhap();
                    themGiangVien(gv);
                    ghiFileGiangVien(gv);
                }

                case 6 -> quanLyBaoCao.getDanhSach().forEach(System.out::println);

                case 7 -> {
                    quanLyBaoCao.sapXepTheoTenBaoCao();
                    System.out.println("Vui long chon xem danh sach de thay ket qua");
                }

                case 8 -> {
                    quanLyBaoCao.sapXepTheoNgayBaoCao();
                    System.out.println("Vui long chon xem danh sach de thay ket qua");
                }

                case 9 -> {
                    try {
                        System.out.print("Nhap vao ten bao cao: ");
                        String ten = CauHinh.sc.nextLine();
                        System.out.print("Nhap vao ngay bao cao: ");
                        Date ngay = CauHinh.F.parse(CauHinh.sc.nextLine());
                        quanLyBaoCao.timKiem(ten,ngay).forEach(System.out::println);
                    } catch (NullPointerException | ParseException exception){
                        CauHinh.sayError();
                    }
                }

                case 10 -> {
                    System.out.print("Nhap vao ma bao cao: ");
                    quanLyBaoCao.xoa(Integer.parseInt(CauHinh.sc.nextLine()));
                }

                case 11 -> {
                    System.out.print("Nhap vao ma bao cao: ");
                    quanLyBaoCao.sua(Integer.parseInt(CauHinh.sc.nextLine()));
                }

                default -> System.out.println("Ban chon thoat.\n");
            }
            System.out.println("==============================");
        }while(choose >= 1 && choose <= 11);
    }

    public static void menuThucTap() throws Exception {
        int choose;
        do{
            System.out.print("""
                    1. Tao Bao Cao Thuc Tap Moi.
                    2. Xem danh sach bao cao thuc tap.
                    3. Nhap danh gia doanh nghiep.
                    4. Nhap diem.
                    5. Nhap ngay bao cao.
                    6. Nhap chuoi link.
                    7. Go back.
                    Moi chon:\s""");
            choose = Integer.parseInt(CauHinh.sc.nextLine());
            switch (choose) {
                case 1 -> {
                    System.out.print("Nhap ten bao cao : ");
                    String tenbc = CauHinh.sc.nextLine();
                    GiangVien cgv = chonGiangVien();
                    List<SinhVien> sv = chonSinhVien();
                    if(!BaoCaoThucTap.isDaThamGia(sv) && cgv != null && sv.size() > 0){
                        BaoCaoThucTap bctt = new BaoCaoThucTap(tenbc, cgv, sv);
                        quanLyBaoCao.them(bctt);
                        System.out.println("Them thanh cong");
                    }
                    else
                        System.out.println("Them that bai");
                }
                case 2 -> {
                    System.out.println("==========DANH SACH BAO CAO THUC TAP==========");
                    quanLyBaoCao.hienThiDanhSach("baocao.BaoCaoThucTap");
                }
                case 3 -> {
                    BaoCaoThucTap baoCao = (BaoCaoThucTap) chonBaoCao("baocao.BaoCaoThucTap");
                    if(baoCao != null)
                        baoCao.nhapDanhGia();
                }
                case 4 -> {
                    BaoCaoThucTap baoCao = (BaoCaoThucTap) chonBaoCao("baocao.BaoCaoThucTap");
                    if(baoCao != null)
                        baoCao.nhapDiem();
                }
                case 5 -> {
                    BaoCaoThucTap baoCao = (BaoCaoThucTap) chonBaoCao("baocao.BaoCaoThucTap");
                    if(baoCao != null)
                        baoCao.nhapNgayBaoCao();
                }
                case 6 -> {
                    BaoCaoThucTap baoCao = (BaoCaoThucTap) chonBaoCao("baocao.BaoCaoThucTap");
                    if(baoCao != null)
                        baoCao.nhapChuoiLink();
                }
                default -> System.out.println("Quay ve menu chinh.\n");
            }
            System.out.println("==============================");
        }while(choose >= 1 && choose <= 6);
    }

    public static void menuDoAn() throws Exception {
        int choose;
        do{
            System.out.print("""
                    1. Tao Bao Cao Do An Moi.
                    2. Xem danh sach bao cao do an.
                    3. Nhap diem.
                    4. Nhap ngay bao cao.
                    5. Nhap chuoi link.
                    6. Nhap ty le dao van.
                    7. Go back.
                    Moi chon:\s""");
            choose = Integer.parseInt(CauHinh.sc.nextLine());
            switch (choose) {
                case 1 -> {
                    System.out.print("Nhap ten bao cao : ");
                    String tenbc = CauHinh.sc.nextLine();
                    GiangVien cgv = chonGiangVien();
                    List<SinhVien> sv = chonSinhVien();
                    if(!BaoCaoDoAn.isDaThamGia(sv) && cgv != null && sv.size() > 0){
                        BaoCaoDoAn bcda = new BaoCaoDoAn(tenbc, cgv ,sv);
                        quanLyBaoCao.them(bcda);
                        System.out.println("Them thanh cong");
                    }
                    else
                        System.out.println("Them that bai");
                }
                case 2 -> {
                    System.out.println("==========DANH SACH BAO CAO DO AN==========");
                    quanLyBaoCao.hienThiDanhSach("baocao.BaoCaoDoAn");
                }
                case 3 -> {
                    BaoCaoDoAn baoCao = (BaoCaoDoAn) chonBaoCao("baocao.BaoCaoDoAn");
                    if(baoCao != null)
                        baoCao.nhapDiem();
                }
                case 4 -> {
                    try {
                        BaoCaoDoAn baoCao = (BaoCaoDoAn) chonBaoCao("baocao.BaoCaoDoAn");
                        if(baoCao != null)
                            baoCao.nhapNgayBaoCao();
                    } catch (ParseException e){
                        CauHinh.sayError();
                    }
                }
                case 5 -> {
                    BaoCaoDoAn baoCao = (BaoCaoDoAn) chonBaoCao("baocao.BaoCaoDoAn");
                    if(baoCao != null)
                        baoCao.nhapChuoiLink();
                }
                case 6 -> {
                    BaoCaoDoAn baoCao = (BaoCaoDoAn) chonBaoCao("baocao.BaoCaoDoAn");
                    if(baoCao != null)
                        baoCao.nhapTyLeDaoVan();
                }
                default -> System.out.println("Quay ve menu chinh.\n");
            }
            System.out.println("==============================");
        }while(choose >= 1 && choose <= 6);
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
                    8. Xem danh sach bao cao khoa luan.
                    9. Nhap ngay bao cao.
                    10. Nhap chuoi link.
                    11. Exit.
                    Moi chon:""");
            choose = Integer.parseInt(CauHinh.sc.nextLine());
            switch(choose){
                case 1 -> {
                    try{
                        HoiDong hoiDong = chonHoiDong();
                        GiangVien giangVien = chonGiangVien();
                        List<SinhVien> sv = chonSinhVien();
                        if(!BaoCaoKhoaLuan.isDaThamGia(sv) && giangVien != null && hoiDong != null && sv.size() > 0){
                            System.out.print("Nhap vao ten bao cao: ");
                            String ten = CauHinh.sc.nextLine();
                            BaoCaoKhoaLuan baoCaoKhoaLuan = new BaoCaoKhoaLuan(hoiDong,ten,giangVien,sv);
                            quanLyBaoCao.them(baoCaoKhoaLuan);
                            hoiDong.themBaoCaoKhoaLuan(baoCaoKhoaLuan);
                            System.out.println("Them thanh cong");
                        }
                        else
                            System.out.println("Them that bai");
                    } catch (IndexOutOfBoundsException e){
                        CauHinh.sayError();
                    }
                }

                case 2 -> {
                    BaoCaoKhoaLuan baoCao = (BaoCaoKhoaLuan) chonBaoCao("baocao.BaoCaoKhoaLuan");
                    if(baoCao != null)
                        baoCao.getHoiDong().nhapDiem(baoCao.getMaBaoCao());
                }
                case 3 -> {
                    BaoCaoKhoaLuan baoCao = (BaoCaoKhoaLuan) chonBaoCao("baocao.BaoCaoKhoaLuan");
                    if(baoCao != null)
                        baoCao.getHoiDong().nhapNhanXet(baoCao.getMaBaoCao());
                }
                case 4 -> {
                    BaoCaoKhoaLuan baoCao = (BaoCaoKhoaLuan) chonBaoCao("baocao.BaoCaoKhoaLuan");
                    if(baoCao != null)
                        baoCao.nhapDanhGia();
                }
                case 5 -> {
                    BaoCaoKhoaLuan baoCao = (BaoCaoKhoaLuan) chonBaoCao("baocao.BaoCaoKhoaLuan");
                    if(baoCao != null){
                        HoiDong hoiDong = baoCao.getHoiDong();
                        System.out.print(hoiDong.getThongTin(baoCao.getMaBaoCao()));
                        System.out.print("Nhap vao ma giang vien: ");
                        int ma = Integer.parseInt(CauHinh.sc.nextLine());
                        hoiDong.suaDiem(baoCao.getMaBaoCao(), ma);
                    }
                }
                case 6 -> {
                    BaoCaoKhoaLuan baoCao = (BaoCaoKhoaLuan) chonBaoCao("baocao.BaoCaoKhoaLuan");
                    if(baoCao != null){
                        HoiDong hoiDong = baoCao.getHoiDong();
                        System.out.print(hoiDong.getThongTin(baoCao.getMaBaoCao()));
                        System.out.print("Nhap vao ma giang vien: ");
                        int ma = Integer.parseInt(CauHinh.sc.nextLine());
                        hoiDong.suaNhanXet(baoCao.getMaBaoCao(), ma);
                    }
                }
                case 7 -> {
                    HoiDong hd = thanhLapHoiDong();
                    if(hd != null)
                        themHoiDong(hd);
                }
                case 8 -> {
                    System.out.println("==========DANH SACH BAO CAO KHOA LUAN==========");
                    quanLyBaoCao.hienThiDanhSach("baocao.BaoCaoKhoaLuan");
                }
                case 9 -> {
                    try{
                        BaoCaoKhoaLuan baoCao = (BaoCaoKhoaLuan) chonBaoCao("baocao.BaoCaoKhoaLuan");
                        if(baoCao != null)
                            baoCao.nhapNgayBaoCao();
                    } catch (ParseException e){
                        CauHinh.sayError();
                    }
                }
                case 10 -> {
                    BaoCaoKhoaLuan baoCao = (BaoCaoKhoaLuan) chonBaoCao("baocao.BaoCaoKhoaLuan");
                    if(baoCao != null)
                        baoCao.nhapChuoiLink();
                }
                default -> System.out.println("Quay ve menu chinh.");
            }
            System.out.println("==============================");
        }while(choose >= 1 && choose <= 10);
    }
}
