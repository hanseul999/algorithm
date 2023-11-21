//입력받은 문자열 나눠서 한줄에 하나씩 문자 출력
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] st = sc.next().split("");
        for (String s: st) {
            System.out.println("'" + s + "'");
        }
        //ver2
        Scanner sc2 = new Scanner(System.in);
        String st2 = sc.next();
        for (int i = 0; i < st2.length(); i++) {
            System.out.println("'" + st2.charAt(i) + "'");
        }
    }
}