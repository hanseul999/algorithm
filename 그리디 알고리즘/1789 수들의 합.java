/*
1789 수들의 합
 */


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long S = scan.nextLong();
        long s = 0;
        int answer = 0;
        int i = 1;

        while (s <= S) {
            s += i;
            answer++;
            i++;
        }

        System.out.println(answer - 1);
    }
}