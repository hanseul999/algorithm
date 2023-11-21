// 16진 정수 입력받아 8진수로 출력하기

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();

        // 16진수 변환 Integer.valueOf(문자열, 진수);
        int x = Integer.valueOf(n, 16);

        // 16진수를 8진수로 출력
        System.out.printf("%o", x);

    }
}