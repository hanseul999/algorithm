/*
      백준 골드4 1197 최소 스패닝 트리
      최소 신장 트리 - 크루스칼
 */

import java.io.*;
import java.util.*;
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
    static List<Edge> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =  new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수

        parent = new int[V + 1]; //유니온 파인드
        for (int i = 0; i <= V; i++) { // 1 ~ V 사용
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) { // 연결정보
            st =  new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(v1, v2, cost));
        }
        edges.sort(new Comparator<Edge>() { // cost를 기준으로 오름차순 정렬
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.cost, o2.cost);
            }
        });

        int answer = 0;
        for (int i = 0; i < edges.size(); i++) { // 정렬된 순대로 탐색
            Edge edge = edges.get(i);
            if (!isSameParent(edge.v1, edge.v2)) { // 두 노드의 부모가 다르다면
                union(edge.v1, edge.v2); // 연결
                answer += edge.cost; //가중치 추가
            }
        }

        System.out.println(answer);


    }

    static int find(int x) {
        if(x == parent[x]){
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
        x = find(x);
        y = find(y);
        return x == y;
    }


}

