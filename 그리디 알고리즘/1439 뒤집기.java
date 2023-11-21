/**
 * 1439 뒤집기
 * 두 문자의 등장 횟수를 확인하고 작은 것이 정답
 *
 */


import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();

        int first = 0;

        int second = 0;

        char curr = S.charAt(0);
        if (curr == '1') {
            first++;
        }else if(curr == '0'){
            second++;
        }


        for (int i = 1; i < S.length(); i++) {

            //System.out.println(curr + " " + S.charAt(i));


            if (curr == S.charAt(i)) {
                continue;
            }else{
                if (S.charAt(i) == '1') {
                    first++;
                }else{
                    second++;
                }
            }
            curr = S.charAt(i);
        }


        int answer = Math.min(first, second);

        System.out.println(answer);

    }


}