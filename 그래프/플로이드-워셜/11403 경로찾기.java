/*
    11403 백준 실버1 경로찾기
    가중치 없는 방향 그래프 G가 주어졌을 때, 모든 정점 (i, j)에 대해서,
    i에서 j로 가는 길이가 양수인 경로가 있는지 없는지 구하기
 */


import java.util.Scanner;

class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int graph[][] = new int[N + 1][N + 1]; // 1~N 사용


        for (int i = 1; i <= N; i++) { //그래프입력
            for (int j = 1; j <= N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        /*
            i에서 j까지 갈 수 있다는 것은
            i에서 k로 가고, k에서 j로 갈 수 있다는 의미
         */
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        //정답출력
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }
}

