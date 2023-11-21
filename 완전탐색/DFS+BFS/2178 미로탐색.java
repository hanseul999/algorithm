/**
 * 2178 미로 탐색
 * "최소의 칸 수" 를 구해야하니 BFS로
 * distance를 따로 저장해줘서 목적지 까지의 최단거리를 출력해주면 된다
 *      distance는 각 위치까지의 최단거리로
 *      이전 위치의 distance에 +1 하는 방식으로 구해줌
 *
 */

import java.awt.*;
import java.util.*;

public class Main {
    static Queue<Point> queue = new LinkedList<>(); //BFS에 쓰일 큐

    static boolean[][] visited; //방문 여부

    static int[][] map; //미로
    static int[][] distance; //도착지까지의 거리

    static int N; //가로
    static int M; //세로



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); //가로
        M = sc.nextInt(); //세로



        map = new int[N][M];
        visited = new boolean[N][M];
        distance = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                int num = line.charAt(j) - '0';
                map[i][j] = num;
            }
        }


        bfs(0, 0);

        System.out.println(distance[N - 1][M - 1]); // 출구까지의 최단 거리 출력

    }

    public static void bfs(int x, int y) {

        queue.add(new Point(x, y));
        visited[x][y] = true;
        distance[x][y] = 1; // 시작점의 거리는 1


        //상하좌우 이동량
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};


        while (!queue.isEmpty()) {

            Point currentPoint = queue.poll();
            int cx = (int) currentPoint.getX();
            int cy = (int) currentPoint.getY();



            for (int i = 0; i < 4 ; i++) { //상하좌우 중 이동할수 있는 곳을 탐색

                int nx = cx + dx[i];
                int ny = cy + dy[i];


                if (nx >= 0 && nx < N && ny >= 0 && ny < M) { //배열 범위에 들어있는지 확인
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        distance[nx][ny] = distance[cx][cy] + 1; // 이전 칸에서 1 증가한 거리를 기록
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
    }

}