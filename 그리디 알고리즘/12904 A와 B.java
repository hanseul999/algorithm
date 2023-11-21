/*
12904 A와 B

A -> B 가 아닌 B -> A로 바꾼다고 생각하면
할 수 있는 작업이
1. 문자열 맨 뒤가 A인 경우 A 제거
2. 문자열 맨 뒤가 B인 경우 B를 제거하고 뒤집기
밖에 없으므로
거꾸로 생각해서 B를 A로 만들어가는 과정을 반복

(A->B인 경우 S에서 A를 추가하거나, 뒤집고 B를 추가하는 방식 2가지중 하나를 선택하여야 한다)

 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        StringBuilder S = new StringBuilder(sc.next());
        StringBuilder T = new StringBuilder(sc.next());

        while (S.length()<T.length()) {
            int m = S.length();
            int n = T.length();

            if (T.charAt(n-1) == 'A') {
                T.deleteCharAt(n - 1);
            } else if (T.charAt(n - 1) == 'B') {
                T.deleteCharAt(n - 1);
                T.reverse();
            }

        }

        String s = S.toString();
        String t = T.toString();

        if (s.equals(t)) {
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }
}