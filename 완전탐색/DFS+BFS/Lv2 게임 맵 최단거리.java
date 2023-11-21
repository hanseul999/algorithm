/*
    프로그래머스 Lv2 게임 맵 최단거리
    최단거리니까 BFS 사용
        목표지점까지의 거리를 + 1씩 하면서 구한다
        백준 2178과 비슷
        맵은 꼭 정사각형이 아닐 수 있다
 */

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static Queue<Point> queue = new LinkedList<>();
    static int[][] distance; //도착지까지의 거리
    static boolean[][] visited; // 방문 여부
    static int h, w;

    public int solution(int[][] maps) {
        h =  maps.length;
        w = maps[0].length;


        distance = new int[h][w];
        visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(visited[i], false);
        }



        bfs(maps);

        if (distance[h - 1][w - 1] == 0) {
            return -1;
        }else{
            return distance[h - 1][w - 1];
        }

    }
    static void bfs(int[][] maps) {

        //출발지점
        queue.add(new Point(0,0));
        visited[0][0] = true;
        distance[0][0] = 1;


        //상하좌우 이동량
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        int nx,ny;
        int cx,cy;


        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll(); //현재위치
            cx = (int) currentPoint.getX();
            cy = (int) currentPoint.getY();


            for (int i = 0; i < 4; i++) { //상하좌우 탐색

                nx = cx + dx[i];
                ny = cy + dy[i];

                if ( ny >= 0  && ny < h && nx >= 0 && nx < w ) {
                    if (!visited[ny][nx] && maps[ny][nx] == 1 ) {
                        visited[ny][nx] = true;
                        distance[ny][nx]= distance[cy][cx] + 1;
                        queue.add(new Point(nx, ny));
                    }
                }
            }

        }
    }
}