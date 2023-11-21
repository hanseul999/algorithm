/*
    프로그래머스 Lv3 등굣길
    오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는 최단경로의 개수

    오른쪽과 아래로만 이동 가능하므로
    왼쪽에 웅덩이가 있는 경우
        위에서만 접근 가능 왼쪽에서 돌아오면 최단거리도 아니고 애초에 위로 이동해야함 
    위쪽에 웅덩이가 있는 경우
        마찬가지로 왼쪽에서만 접근 가능 
    따라서 왼쪽에 웅덩이가 없는 경우 오른쪽으로 이동 위쪽에 웅덩이가 없는 경우 아래로 이동
    
    최단거리를 dp에 기록 

 */



class Main {


    public static void main(String[] args) {
        // 입력 예제
//        int m = 7;
//        int n = 4;
//        int[][] puddles = {{2, 1}, {2, 2}, {2, 3}, {4, 2}, {4, 3}, {4, 4}, {6, 2}, {6, 3}}; // 물웅덩이

        int m = 4; int n = 3;
        int[][] puddles = {{2, 2}};
        //

        // 1 ~ n,m idx 사용
        int[][] map = new int[n + 1][m + 1];
        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            map[y][x] = -1;
        }
        int[][] dp = new int[n + 1][m + 1];

        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (map[i][j] != -1) {
                    if (i != 1 && dp[i - 1][j] != -1) { //위에 웅덩이가 없는 경우
                        dp[i][j] += dp[i - 1][j] % 1000000007; //내려오기 가능
                    }
                    if (j != 1 && dp[i][j - 1] != -1) { //왼쪽에 웅덩이가 없는 경우
                        dp[i][j] += dp[i][j - 1] % 1000000007; //오른쪽으로 이동 가능
                    }
                }
            }
        }

        int answer = dp[n][m] % 1000000007;
        System.out.println(answer);
    }
}

