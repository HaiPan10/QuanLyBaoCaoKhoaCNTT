package cauhinh;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public final class CauHinh {
    public static SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
    public static Scanner sc = new Scanner(System.in);
    public static void sayError(){
        System.out.println("ERROR");
    }
    public static void sayDone(){
        System.out.println("DONE");
    }
    public static void sayNotFound(){
        System.out.println("Value Not Found");
    }
}
