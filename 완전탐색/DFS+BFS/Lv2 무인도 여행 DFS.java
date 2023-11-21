/*
    프로그래머스 Lv2 무인도 여행
    - 각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return
    - 지낼 수 있는 무인도가 없다면 -1을 배열에 담아 return

    DFS 
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {
    static boolean[][] visited;
    static int[][] arr;
    static int width;
    static int height;
    static List<Integer> answerList = new ArrayList<>();
    static int temp = 0;
    public static void main(String[] args) {
        // 입력 예제
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        //
        height = maps.length;
        width = maps[0].length();
        visited = new boolean[height][width];
        arr = new int[height][width];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'X') {
                    visited[i][j] = true;
                    arr[i][j] = 0;
                }else{
                    arr[i][j] = maps[i].charAt(j) - '0';
                }
            }
        }

        int count = 0 ;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, arr[i][j]);
                    answerList.add(temp);
                    temp = 0;
                }
            }
        }

        //정답출력

            /*
                if (answerList.isEmpty()) {
                    return new int[]{-1};
                }
             */
        Collections.sort(answerList);

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        for (int a : answer) { //return answer;
            System.out.println(a);
        }


    }

    static void dfs(int y, int x, int day) {

        temp += day;
        visited[y][x] = true;
        //상하좌우
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < width && ny >= 0 && ny < height && !visited[ny][nx]) {
                dfs(ny, nx, arr[ny][nx]);
            }
        }
    }


}

