import baocao.*;
import connguoi.*;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        SinhVien sinhVien = new SinhVien("Phan Thanh Hải", "Nam","18/05/2002",2020,"CNTT");
        GiangVien giangVienHD = new GiangVien("Trần Thị Xuân Thanh", "Nữ", "23/06/2002","Tiến sĩ","Tiến Sĩ");
        List<SinhVien> test = new ArrayList<>();
        test.add(sinhVien);
        BaoCao khoaLuan = new BaoCaoKhoaLuan(null,"Thử Nghiệm",giangVienHD,test);
        System.out.println(khoaLuan.toString());
    }
}
