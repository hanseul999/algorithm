import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long r = sc.nextLong();
        long n = sc.nextLong();

        for (int i = 1; i < n; i++) {
            a*=r;
        }
        System.out.println(a);
    }
}