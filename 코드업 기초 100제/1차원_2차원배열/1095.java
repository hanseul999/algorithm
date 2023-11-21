import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int a = 23;

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            arr[i] = temp;
            if (a > temp) {
                a = temp;
            }
        }
        System.out.println(a);
    }
}