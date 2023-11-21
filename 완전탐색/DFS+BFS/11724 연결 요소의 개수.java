/**
 * 11724 연결 요소의 개수
 * 인접행렬 사용
 * DFS BFS 둘 다
 * 주의할점 : 혼자 떨어진 외딴 정점도 하나의 연결 요소로 봐야함
 * 따라서 인접행렬 방문시 들리지 않은 곳이라면 모두 방문
 */

import java.util.*;

public class Main {
    static Queue<Integer> queue = new LinkedList<>(); //BFS에 쓰일 큐

    static boolean[] visited;
    static int[][] graph;

    static int N; //노드 개수
    static int M; //간선 개수
    static int count = 0; // 연결 요소의 개수(정답)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N + 1][N + 1];

        visited = new boolean[N + 1];
        Arrays.fill(visited, false);


        //간선 연결상태 저장
        for (int i = 1; i <= M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v] = graph[v][u] = 1;
        }

        //인접행렬 방문
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                count++;
                bfs(i);
                //dfs(i);
            }
        }
        System.out.println(count);
    }

    public static void dfs(int start) {
        visited[start] = true;

        for (int i = 1; i <= N; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
    public static void bfs(int start) {
        queue.add(start);
        visited[start] = true;


        while (!queue.isEmpty()) {

            int currentNode = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (graph[currentNode][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;

                }
            }
        }

    }

}