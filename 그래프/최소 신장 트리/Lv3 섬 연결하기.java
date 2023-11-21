/*
      프로그래머스 Lv3 섬 연결하기
      크루스칼 사용
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Main {

    static class Edge {
        int v1, v2, cost;

        Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        //문제 입력 예제
        int n = 6;
        int[][] costs = {{0, 1, 5}, {0, 3, 2}, {0, 4, 3},
                {1, 4, 1}, {3, 4, 10}, {1, 2, 2}, {2, 5, 3}, {4, 5, 4}};
        //

        parent = new int[n];
        for (int i = 0; i < n; i++) { // 유니온 파인드
            parent[i] = i;
        }

        List<Edge> edges = new ArrayList<>();
        for (int[] cost : costs) {
            edges.add(new Edge(cost[0], cost[1], cost[2]));
        }

        //간선을 기준으로 오름차순 정렬
        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.cost, o2.cost);
            }
        });
        
        int answer = 0;
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            int v1 = edge.v1;
            int v2 = edge.v2;
            if (!isSameParent(v1, v2)) { //둘의 부모가 다르다면
                union(v1, v2); //연결 
                answer += edge.cost;
            }
        }

        System.out.println(answer);
        //return answer;

    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        else{
            return parent[x] = find(parent[x]);
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x!=y) {
            if(x < y) {
                parent[y] = x;
            }
            else {
                parent[x] = y;
            }
        }
    }

    static boolean isSameParent(int x, int y) {
        if (find(x) == find(y)) {
            return true;
        } else {
            return false;
        }
    }

}

