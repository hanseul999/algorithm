/**
 * 10진수를 입력받아 16진수(hexadecimal)로 출력하기
 * %x 사용시 소문자로 출력
 */ 

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.printf("%x", n);

    }
}