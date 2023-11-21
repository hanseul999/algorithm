import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double h = sc.nextInt();
        double b = sc.nextInt();
        double c = sc.nextInt();
        double s = sc.nextInt();

        double answer = (h * b * c * s) / 8 / (1 << 10) / (1 << 10);
        System.out.printf("%.1f MB", answer);

    }
}