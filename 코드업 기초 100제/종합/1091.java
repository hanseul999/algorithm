import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long m = sc.nextLong();
        long d = sc.nextLong();
        long n = sc.nextLong();

        for (int i = 1; i < n; i++) {
            a = (a * m) + d;
        }
        System.out.println(a);
    }
}