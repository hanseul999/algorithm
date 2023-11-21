// 정수 a와 b를 입력받아 a를 2^b 배 곱한 값으로 출력하기

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.printf("%d", a << b) ;
    }
}