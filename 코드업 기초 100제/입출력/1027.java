// 2014.07.15 -> 15-07-2014

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();
        String[] st = number.split("\\.");
        System.out.print(st[2] + "-" + st[1] + "-" + st[0]);
    }
}