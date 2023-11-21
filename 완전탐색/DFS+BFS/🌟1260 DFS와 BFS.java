/**
 * 1260 DFS와 BFS
 * DFS는 재귀함수 방식
 * BFS는 Queue 사용
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static Queue<Integer> queue = new LinkedList<>(); //BFS에 쓰일 큐
    static StringBuilder sb = new StringBuilder(); //정답
    static boolean[] check; //방문 여부
    static int[][] graph; //인접행렬

    static int nodeCount;
    static int lineCount;
    static int startNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        nodeCount = Integer.parseInt(st.nextToken());
        lineCount = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());

        graph = new int[nodeCount + 1][nodeCount + 1];
        check = new boolean[nodeCount + 1];

        //간선 연결상태 저장
        for (int i = 0; i < lineCount; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }
        dfs(startNode);
        sb.append("\n");

        check = new boolean[nodeCount + 1];
        bfs(startNode);

        System.out.print(sb);

    }

    public static void dfs(int startNode) {
        check[startNode] = true;
        sb.append(startNode).append(" ");

        for (int i = 1; i <= nodeCount; i++) {
            if (graph[startNode][i] == 1 && !check[i]) {
                dfs(i);
            }
        }

    }
    public static void bfs(int startNode) {
        queue.add(startNode);
        check[startNode] = true;
        while (!queue.isEmpty()) {

            startNode = queue.poll();
            sb.append(startNode).append(" ");

            for (int i = 1; i <= nodeCount; i++) {
                if (graph[startNode][i] == 1 && !check[i]) {
                    queue.add(i);
                    check[i] = true;
                }
            }

        }


    }

}