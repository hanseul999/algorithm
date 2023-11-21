/**
 * 11047 동전 0
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int answer=0;


        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        N--;

        while(K!=0){
            if ( K-arr[N]>=0  ) {
                K -= arr[N];
                answer++;
            }
            else{
                N--;
            }

        }

        System.out.println(answer);

    }
}