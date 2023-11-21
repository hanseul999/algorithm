import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double w = sc.nextInt();
        double h = sc.nextInt();
        double b = sc.nextInt();

        double answer = (w*h*b) / 8 / (1 << 10) / (1 << 10);
        System.out.printf("%.2f MB", answer);

    }
}