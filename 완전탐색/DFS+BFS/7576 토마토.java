/**
 * 7576 토마토
 * 익은 토마토는 익지 않은 토마토에게 영향을 준다 + 안 익은 토마토 혼자있으면 못익음
 * 익은 토마토 -> 안익은 토마토로 탐색
 *
 *  * 1. "최소일수"를 구해야하기 때문에 BFS로
 *  * 2. 모든 익은 토마토에서 동시에 BFS를 시작해야야함.
 *      이를 위해 익은 토마토를 모두 큐에 넣고 이후 bfs를 시작해서 동시에 진행
 *      추가적으로 각각의 토마토가 익는데 걸리는 날을 저장해줘야함 
 *
 *
 */

import java.awt.*;
import java.util.*;

public class Main {
    static Queue<Point> queue = new LinkedList<>(); //BFS에 쓰일 큐

    static boolean[][] visited;
    static int[][] map; //토마토 농장

    static int M; //가로
    static int N; //세로
    static int[][] day; // 토마토가 모두 익을때까지의 날짜

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();


        map = new int[M][N];
        visited = new boolean[M][N];
        day = new int[M][N];

        boolean already = true;

        //토마토 저장 + 토마토가 없는 곳은 이미 방문한곳으로 처리
        //day도 초기화
        for (int j = 0; j < N; j++){
             for (int i = 0; i < M; i++){
                int tomato = sc.nextInt();
                map[i][j] = tomato;
                if (tomato == -1) { //빈공간
                    visited[i][j] = true;
                }else if(tomato == 1){ //익은토마토
                    visited[i][j] = true;

                    queue.add(new Point(i, j)); // 익은 토마토 큐에 넣기

                }else{ //안익은 토마토
                    visited[i][j] = false;
                    already = false;
                }
                day[i][j] = 0;
            }
        }


        if (already) {
            System.out.println(0);
            return;
        }


        bfs();

        int maxDay = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                maxDay = Math.max(maxDay, day[i][j]);
            }
        }

        System.out.println(maxDay);

    }

    public static void bfs() {

        //상하좌우 이동량
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};


        while (!queue.isEmpty()) {

            Point currentPoint = queue.poll();
            int x = (int) currentPoint.getX();
            int y = (int) currentPoint.getY();

            for (int i = 0; i < 4 ; i++) { //상하좌우 중 이동할수 있는 곳을 탐색

                int nx = x + dx[i];
                int ny = y + dy[i];


                if (nx >= 0 && nx < M && ny >= 0 && ny < N) { //배열 범위에 들어있는지 확인
                    if (map[nx][ny] == 0 && !visited[nx][ny]) { //방문하지 않은 안 익은 토마토로 이동
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                        day[nx][ny] = day[x][y] + 1;

                        map[nx][ny] = 1; //토마토가 익게됨 

                    }
                }
            }
        }

    }

}