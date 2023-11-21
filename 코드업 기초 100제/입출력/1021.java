//문자열을 한 문자씩 잘라내서 출력하는 문제

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] st = sc.next().split("");
        for (String s: st) {
            System.out.print(s);
        }
    }
}