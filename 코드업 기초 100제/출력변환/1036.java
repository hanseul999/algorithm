// 영문자 입력받아 아스키 코드표의 10진수로 출력하기

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char i = sc.next().charAt(0);

        System.out.println((int)i);

    }
}