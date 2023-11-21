/**
 * 입력예시 - 75254
 * 출력예시
 * [70000]
 * [5000]
 * [200]
 * [50]
 * [4]
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        String[] st = number.split("");
        int cnt = number.length();
        for (String s: st) {
            cnt--;
            StringBuilder zero = new StringBuilder();
            for (int i = 0; i < cnt; i++) {
                zero.append("0");
            }
            System.out.println("[" + s + zero + "]");
        }
    }
}