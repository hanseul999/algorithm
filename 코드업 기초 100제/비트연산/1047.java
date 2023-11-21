// 정수 1개를 입력받아 2배 곱해 출력해보기

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.printf("%d", i << 1);
    }
}