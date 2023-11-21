import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;

        for (int i = 1; i < 1000000000; i++) {
            if (sum >= n) {
                break;
            }
            sum += i;
        }
        System.out.println(sum);
    }
}