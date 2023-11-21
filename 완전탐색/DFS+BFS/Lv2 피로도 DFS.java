/*
    프로그래머스 Lv2 피로도

    dfs로 돌면서
    던전에 들어갈 수 있는 피로도인지 체크하고 들어간다
    

 */


class Main {
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) {
        // 입력 예제
        int k = 80; // 현재 피로도
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}}; //돌기 위해 필요한 최소 필요도, 소모 필요도
        //
        visited = new boolean[dungeons.length];

        dfs(0, k, dungeons);

        System.out.println(answer);

    }

    static void dfs(int depth, int k, int[][] dungeons) {

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }

        answer = Math.max(answer, depth);
    }

}

