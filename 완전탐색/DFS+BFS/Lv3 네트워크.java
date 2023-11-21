/*
    프로그래머스 Lv3 네트워크

    computers에는 연결정보
        - 차례대로 idx 노드가 연결되어있는 정보가 담겨있음

    DFS
 */

class Solution {
    static int answer = 0;
    static boolean[] visited;
    static int nodeCnt;
    public int solution(int n, int[][] computers) {

        nodeCnt = computers.length;
        visited = new boolean[nodeCnt];

        for(int i = 0; i < nodeCnt; i++){ //방문배열 초기화
            visited[i] = false;
        }

        for (int i = 0; i < nodeCnt; i++) { //노드 순회
            if (!visited[i]) { //새로운 네트워크를 찾으면 answer++
                answer++;
                dfs(computers, i); //dfs를 통해 연결된 모든 노드 방문
            }
        }

        return answer;

    }

    static void dfs(int[][] computers, int idx) { //연결된 모든 노드 방문

        visited[idx] = true;

        for (int i = 0; i < nodeCnt; i++) {
            if (computers[idx][i] == 1 && !visited[i]) {
		//연결돼있다면 dfs로 쭉쭉 들어감
		//연결이 끊겨있다면 탐색X
		//이후 방문하지 않은 노드는 혼자 떨어져있으니 !visitied -> 후에 answer++ 하게됨 
                dfs(computers, i);
            }
        }

    }


}