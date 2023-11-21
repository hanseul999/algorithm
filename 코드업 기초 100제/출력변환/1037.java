// 정수 입력받아 아스키 문자로 출력하기

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println((char) i);
    }
}