/*

15649 N과 M (1) - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

모든 조합을 탐색하면서 해를 찾기 위해 재귀호출 사용

 */

import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] arr; //선택된 숫자를 저장
    static boolean[] visited; // 방문한 노드
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N + 1];
        arr = new int[M + 1];

        recursion(0);

        System.out.println(sb);
    }

    public static void recursion(int idx) {
        if (idx == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                //방문한 노드 == 유망하지 않은 노드 -> 탐색 X
                visited[i] = true; //해당 순회에서 방문한 노드는 탐색하지 않게 됨
                arr[idx] = i;
                recursion(idx + 1); // 탐색
                visited[i] = false; // 모든 노드에서 dfs하기 위해
            }
        }

    }
}
