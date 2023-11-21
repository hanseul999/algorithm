/**
 * 1012 유기농 배추
 * 지도 문제
 * DFS BFS 둘 다
 */

import java.awt.*;
import java.util.*;

public class Main {
    static Queue<Point> queue = new LinkedList<>(); //BFS에 쓰일 큐
    static ArrayList<Integer> answer  = new ArrayList<>();
    static int count = 0; //필요한 지렁이 수
    static boolean[][] visited;
    static int[][] map;

    static int M; //지도 가로 크기
    static int N; //지도 세로 크기
    static int K; //배추가 심어져있는 위치의 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); //테스트 케이스 개수

        for (int k = 0; k < T; k++) {
            count = 0;
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();

            map = new int[M][N];

            visited = new boolean[M][N];
            for (boolean[] m : visited) {
                Arrays.fill(m, false);
            }

            //배추 심기
            for (int i = 0; i < K; i++) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    map[x][y] = 1;

            }


            //지도 순회
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == 1 && !visited[i][j]){
                        count++;
                        bfs(i, j);
                        //dfs(i, j);
                    }
                }
            }

            System.out.println(count);
        }



    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        // 상, 하, 좌, 우 방향
        int[] dx = {0, 0, -1, 1}; // x 좌표의 변화량
        int[] dy = {-1, 1, 0, 0}; // y 좌표의 변화량

        for (int i = 0; i < 4; i++) {

            //다음에 탐색할 좌표
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) { //지도 범위 안에 드는지 확인
                if (map[nx][ny] == 1 && !visited[nx][ny]) { //갈 수 있으면 재귀함수
                    dfs(nx, ny);
                }
            }
        }
    }
    public static void bfs(int x, int y) {
        queue.add(new Point(x,y));
        visited[x][y] = true;

        // 상, 하, 좌, 우 방향
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while (!queue.isEmpty()) {

            Point temp = queue.poll();
            x = temp.x;
            y = temp.y;


            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {

                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;

                    }
                }
            }

        }


    }

}