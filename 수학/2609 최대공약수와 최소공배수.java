/**
 * 2609 최대공약수와 최소공배수
 * 유클리드 호제법
 */

import java.util.Scanner;

public class Main {


    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();


        int answer = GCD(M, N);

        System.out.println(answer); //최대공약수

        N/=answer;
        M/=answer;

        System.out.println(N*M*answer); //최소공배수
        
    }
    private static int GCD(int n, int m) {
        if (m == 0) {
            return n;
        }
        return GCD(m, n%m);
    }

}