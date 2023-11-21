/**
 * 2839 설탕 배달
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();


        int answer=0;


        while (true) {
            if(N%5==0){
                answer+=N/5;
                break;
            }
            else if(N<0){
                System.out.println(-1);
                return;
            }
            else {
                N -= 3;
                answer++;
            }

        }

        System.out.println(answer);

    }
}