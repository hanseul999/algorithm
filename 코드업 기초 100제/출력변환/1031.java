// 10진수를 입력받아 8진수(octal)로 출력하기

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.printf("%o", n);

    }
}