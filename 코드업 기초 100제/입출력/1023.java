//입력받은 소수 정수부와 소수부로 나눠 출력하기
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] st = sc.next().split("\\.");
        System.out.print(st[0] + "\n" + st[1]);
    }
}