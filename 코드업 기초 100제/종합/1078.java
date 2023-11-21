import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int answer = 0;
        for (int i = 2; i <= a; i+=2) {
            answer += i;
        }
        System.out.println(answer);
    }
}