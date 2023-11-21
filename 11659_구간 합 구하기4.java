/*
11659

ArrayIndexOutofBoudns 주의 - try catch문으로 처리

구간 합 배열을 구할 때
입력받은 정수를 일반 배열에 집어 넣은 뒤
일반 배열을 이용하여 구간 합 배열을 구했더니
시간초과 문제가 발생하여
구간 합 배열에 바로 입력값을 더하는 방식으로 해결
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;
        int j;

        int N = sc.nextInt();
        //int A[] = new int[N]; //일반 배열
        int S[] = new int[N]; //구간 합 배열

        int M = sc.nextInt();

        for(int k=0;k<N;k++){
            //A[k] = sc.nextInt();
            try{  // Array Eception 방지
                S[k] = S[k-1] + sc.nextInt();
            }catch(Exception e){
                S[k] = sc.nextInt();
            }

        }

        for(int k=0;k<M;k++){
            i = sc.nextInt();
            j = sc.nextInt();
            try{  // Array Eception 방지
                System.out.println(S[j-1] - S[i-2]);
            }catch(Exception e){
                System.out.println(S[j-1]);
            }

        }


    }
}