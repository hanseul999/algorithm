import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] st = sc.next().split("\\.");
        
        int year = Integer.parseInt(st[0]);
        int month = Integer.parseInt(st[1]);
        int day = Integer.parseInt(st[2]);

        System.out.printf("%04d.%02d.%02d", year, month, day);
    }
}