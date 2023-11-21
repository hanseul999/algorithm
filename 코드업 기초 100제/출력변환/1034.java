// 8진 정수 입력받아 10진수로 출력하기

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();

        // 8진수 변환 Integer.valueOf(문자열, 진수);
        int o = Integer.valueOf(n, 8);

        // 8진수를 10진수로 출력
        System.out.printf("%d", o);

    }
}