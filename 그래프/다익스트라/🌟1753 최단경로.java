/*
      백준 골드4 1753 최단경로
      다익스트라

      - V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력
      - 시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력

 */

import java.io.*;
import java.util.*;
class Main {

    static class Edge implements Comparable<Edge> {
        int vertex, cost;

        Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static List<List<Edge>> graph = new ArrayList<>(); //인접리스트 그래프
    static boolean[] visited; // 방문 여부
    static int[] distance; // 출발지로부터 거리가 얼마나 되는지 기록


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =  new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수
        int start = Integer.parseInt(br.readLine()); // 시작정점의 번호

        visited = new boolean[V + 1]; // 1 ~ V 사용
        distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i <= V; i++) { // 그래프 초기화
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st =  new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            // 정점별로 연결 정보 저장
            graph.get(v1).add(new Edge(v2, cost)); //단방향 그래프
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            }else{
                sb.append(distance[i]).append("\n");
            }
        }

        System.out.println(sb);

    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentVertex = current.vertex;
            int currentCost = current.cost;

            if (visited[currentVertex]) {
                continue;
            }
            visited[currentVertex] = true; //방문처리

            for (Edge next : graph.get(currentVertex)) { // 해당 정점과 연결된 노드들 탐색
                int nextVertex = next.vertex;
                int nextCost = next.cost;

                if (distance[currentVertex] + nextCost < distance[nextVertex] ) {
                    /*
                        현재까지 알려진 최단 거리보다 새로운 경로를 통한
                        거리가 더 짧으면 그 거리를 업데이트한다
                        -> 현재까지 알려진 next 정점으로 까지의 최단거리보다
                           currentVertext를 통해 next Vertex의 접근하는거리가 더 짧다면
                           그 거리를 업데이트
                     */

                    // 최단 거리 갱신
                    distance[nextVertex] = distance[currentVertex] + nextCost;
                    pq.offer(new Edge(nextVertex, distance[nextVertex]));
                }
            }

        }


    }





}

