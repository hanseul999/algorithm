/*
    프로그래머스 Lv2 미로 탈출
    BFS
    (시작점 -> 레버) + (레버 -> 도착지)로 나눠서 생각

 */


import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static boolean[][] visited;
    static int[][] time;

    public static void main(String[] args) {
        //문제 입력 예제
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        //String[] maps = {"LOOOS","OOOOO","OOOOO","XOOOO","EXOOO"};
        //String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        //String[] maps = {"OOOOOL", "OXOXOO", "OOSXOX", "OXXXOX", "EOOOOX"};
        /*
            S : 시작 지점
            E : 출구
            L : 레버
            O : 통로
            X : 벽
         */
        //
        String[][] mapsArray = new String[maps[0].length()][maps.length];
        visited = new boolean[maps[0].length()][maps.length];
        time = new int[maps[0].length()][maps.length];
        Point start = null;
        Point lever = null;
        Point end = null;


        for (int i = 0; i < mapsArray.length; i++) {
            for (int j = 0; j < mapsArray[i].length; j++) {
                mapsArray[i][j] = String.valueOf(maps[j].charAt(i));
                if (mapsArray[i][j].equals("S")) {
                    start = new Point(i, j);
                }else if (mapsArray[i][j].equals("L")) {
                    lever = new Point(i, j);
                }
                else if (mapsArray[i][j].equals("E")) {
                    end =new Point(i, j);
                }
            }
        }


        bfs(mapsArray, start, lever);
        int l = time[lever.x][lever.y];
        if (l == 0) { //레버까지 못가는 경우
            System.out.println(-1);
        }
        visited = new boolean[maps[0].length()][maps.length];

        bfs(mapsArray, lever, end);
        int e = time[end.x][end.y];
        if (e == 0) { //EXIT를 가지 못하는 경우
            System.out.println(-1);
        }

        System.out.println(l + e);


    }

    static void bfs(String[][] mapsArray, Point start, Point end) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;
        time[start.x][start.y] = 0;

        int[][] direct = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; //상하좌우

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = (int) (current.getX() + direct[i][0]);
                int ny = (int) (current.getY() + direct[i][1]);

                if (nx < mapsArray.length && nx >= 0 && ny < mapsArray[0].length  && ny >=0) {
                    if (!mapsArray[nx][ny].equals("X") && !visited[nx][ny]) {

                        time[nx][ny] = time[current.x][current.y] + 1;
                        if (nx == end.getX() && ny == end.getY()) {
                            return;
                        }

                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;

                    }
                }

            }
        }
    }

}