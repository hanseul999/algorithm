/**
 * 2606 바이러스
 * DFS BFS 둘 다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Queue<Integer> queue = new LinkedList<>(); //BFS에 쓰일 큐
    static int answer1 = 0;
    static int answer2 = 0;
    static boolean[] check; //방문 여부
    static int[][] graph; //인접행렬

    static int nodeCount;
    static int lineCount;
    static int startNode;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        nodeCount = sc.nextInt(); //컴퓨터 수
        lineCount = sc.nextInt(); //컴퓨터 쌍 수
        startNode = 1;

        graph = new int[nodeCount + 1][nodeCount + 1];
        check = new boolean[nodeCount + 1];

        //간선 연결상태 저장
        for (int i = 0; i < lineCount; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = graph[b][a] = 1;
        }
        dfs(startNode);
        check = new boolean[nodeCount + 1];
        bfs(startNode);
        System.out.println(answer1); //dfs 결과
        System.out.println(answer2); //bfs 결과
    }

    public static void dfs(int startNode) {
        check[startNode] = true;

        for (int i = 1; i <= nodeCount; i++) {
            if (graph[startNode][i] == 1 && !check[i]) {
                answer1++;
                dfs(i);
            }
        }

    }
    public static void bfs(int startNode) {
        queue.add(startNode);
        check[startNode] = true;

        while (!queue.isEmpty()) {

            startNode = queue.poll();

            for (int i = 1; i <= nodeCount; i++) {
                if (graph[startNode][i] == 1 && !check[i]) {
                    queue.add(i);
                    check[i] = true;
                    answer2++;
                }
            }

        }


    }

}