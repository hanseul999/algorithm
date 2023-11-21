/*
    11404 골드4 플로이드
    모든 도시의 쌍 (A, B)에 대해서
    도시 A에서 B로 가는데 필요한 비용의 최솟값을 구하기

    탐색을 하면서 가중치가 더 낮은 값이 있을 경우 갱신

    +) 버스 한 대의 비용이 10만이지 목적지까지 여러대를 이용할경우 값은 더 커질 수 있음
       Integer.MAX_VALUE 사용시 overflow 발생하니 적당한 수 집어넣기
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시 수
        int m = Integer.parseInt(br.readLine()); // 버스의 수
        int[][] graph = new int[n + 1][n + 1]; // 1~n 사용

        for (int[] g : graph) { //초기화
            Arrays.fill(g, INF);
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) { // 그래프입력
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v1][v2] = Integer.min(graph[v1][v2], cost);
        }


        /*
            플로이드-워셜 알고리즘

            i에서 j까지 갈 수 있다는 것은
            i에서 k로 가고, k에서 j로 갈 수 있다는 의미
            탐색을 하면서 가중치가 더 낮은 값이 있을 경우 갱신
             -> k를 거쳐서 연결될 수 있으면 map[i][j]의 값을 map[i][k] + map[k][j]으로 갱신
         */
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if ((graph[i][j] > graph[i][k] + graph[k][j]) && (i != j)) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }


        //정답출력
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if (graph[i][j] == INF) {
                    sb.append(0).append(" ");
                }else{
                    sb.append(graph[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }
}

