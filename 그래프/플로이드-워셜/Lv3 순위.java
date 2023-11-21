/*
    프로그래머스 Lv3 순위
    선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때
    정확하게 순위를 매길 수 있는 선수의 수를 return
 */


class Main {


    public static void main(String[] args) {
        // 입력 예제
        int n = 5; //선수 수
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}; //경기 결과
        //
        int[][] graph = new int[n + 1][n + 1]; // 1~n 사용

        for (int[] result : results) {
            graph[result[0]][result[1]] = 1;  //a가 b에게 이겼다면 1
            graph[result[1]][result[0]] = -1; //b가 a에게 졌다면  -1

        }

        /*
            플로이드-워셜
            i -> k + k -> j  == i -> j
            i 선수가 k 선수에게 이겼고 k 선수가 j 선수에게 이겼다면 j 선수는 i 선수에게 진 것.
            i 선수가 k 선수에게 졌고 k 선수가 j 선수에게 졌다면 i 선수는 j 선수에게 진 것.
         */
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {

                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }

                    if(graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }

        /*
            정답출력
            본인과 n-1명과의 승부 결과를 알면 순위를 알 수 있음 
         */
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            for(int j = 1; j <= n; j++) {
                if (graph[i][j] != 0) {
                    cnt++;
                }
            }
            if (cnt == n - 1) {
                answer++;
            }
        }

        System.out.println(answer);


    }
}

