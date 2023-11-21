/*
    프로그래머스 Lv3 가장 먼 노드
    1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return
    bfs 사용

    edge를 사용하여 바로 bfs 탐색을 진행하면,
    그래프의 각 간선마다 현재 노드와 연결된 노드가 있는지 확인하기 위해
    *매번* edge를 전부 순회해야함. 크기가 큰 경우에 매우 비효율적임.

    따라서 인접리스트를 통해 그래프를 구현하여 시간복잡도 단축

 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    static int[] map; // 거리 기록
    static boolean[] visited; //방문 여부
    static ArrayList<ArrayList<Integer>> graph; // 인접 리스트
    public static void main(String[] args) {
        //주어진 입력 예제
        int n = 6; //노드의 개수 n
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}; //간선정보
        //

        map = new int[n + 1]; //편하게 1 ~ max idx 사용
        visited = new boolean[n + 1];

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) { //인접리스트 초기화
            graph.add(new ArrayList<>());
        }

        // 그래프 생성
        for (int[] e : edge) {
            int node1 = e[0];
            int node2 = e[1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        bfs(edge);

        int max = 0;
        for (int i = 1; i < map.length; i++) {
            max = Math.max(max, map[i]);
        }

        int answer = 0;
        for (int i = 1; i < map.length; i++) {
            if (map[i] == max) {
                answer++;
            }
        }

        System.out.println(answer);

    }

    static void bfs(int[][] edge) {

        int start = 1; //1번 노드에서 시작

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        map[start] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next :  graph.get(current)) {// 현재 노드와 연결된 노드들 바로 탐색
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    map[next] = map[current] + 1;
                }
            }

        }
    }

}