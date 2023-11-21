/*

15651 N과 M (3)
- 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
- 같은 수를 여러 번 골라도 된다.

중복허용 모든 노드에 대해 탐색 

 */

import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] arr; //선택된 숫자를 저장
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();


        arr = new int[M + 1];

        recursion(0);

        System.out.println(sb);
    }

    public static void recursion(int idx){

        if (idx == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[idx] = i;
            recursion(idx + 1); // 탐색
        }

    }
}
