/**
 * 2667번 단지번호 붙이기
 * DFS BFS 둘 다
 */

import java.awt.*;
import java.util.*;

public class Main {
    static Queue<Point> queue = new LinkedList<>(); //BFS에 쓰일 큐
    static int count = 0;
    static boolean[][] visited;
    static int[][] map;

    static int N; //지도 크기

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //지도 크기

        map = new int[N][N];

        visited = new boolean[N][N];
        for (boolean[] n : visited) {
            Arrays.fill(n, false);
        }

        //지도 저장
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                int a = line.charAt(j) - '0';
                map[i][j] = a;
            }
        }

        //지도 순회
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]){
                    count = 0;
                    //dfs(i, j);
                    bfs(i, j);
                    answer.add(count);
                }
            }
        }

        visited = new boolean[N][N];

        int c = answer.size();
        System.out.println(c);

        Collections.sort(answer);
        for (int i = 0; i < c; i++) {
            System.out.println(answer.get(i));
        }

    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        // 상, 하, 좌, 우 방향
        int[] dx = {-1, 1, 0, 0}; // x 좌표의 변화량
        int[] dy = {0, 0, -1, 1}; // y 좌표의 변화량

        for (int i = 0; i < 4; i++) {

            //다음에 탐색할 좌표
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) { //지도 범위 안에 드는지 확인
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
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            Point temp = queue.poll();
            x = temp.x;
            y = temp.y;
            count++;

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {

                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;

                    }
                }
            }

        }


    }

}