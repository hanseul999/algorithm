// 입력되는 시:분:초 에서 분만 출력해보기

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        String[] st = number.split(":");
        System.out.print(st[1]);
    }
}