/*
    프로그래머스 Lv3 여행경로

    주어진 항공권을 모두 사용하여 방문하는 공항 경로를 배열에 담아 return
    - 항상 "ICN" 공항에서 출발함
    - 여러 경로가 있을 경우 알파벳순으로 앞선 결과를 return

 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static boolean[] used;
    static List<String> answerList = new ArrayList<>();
    public static void main(String[] args) {
        // 입력 예제
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"},
                             {"ATL", "ICN"}, {"ATL","SFO"}};
                // 보유한 a->b로 가는 티켓
        //

        used = new boolean[tickets.length];

        dfs(0, "ICN", "ICN", tickets); // ICN에서 시작 

        // 결과들을 정렬하여 알파벳순으로 앞선 결과를 return
        Collections.sort(answerList);
        StringTokenizer st = new StringTokenizer(answerList.get(0));
        String[] answer = new String[st.countTokens()];

        //정답출력
        for (int i = 0; i < answer.length; i++) {
            answer[i] = st.nextToken();
        }
        for (String s : answer) {
            System.out.print(s + " ");
        }
        //return answer;


    }

    static void dfs(int depth, String current, String path, String[][] tickets) {
        if (depth == tickets.length) {
            answerList.add(path);
        }
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(current) && !used[i]) {
                used[i] = true;
                dfs(depth + 1, tickets[i][1], path + " " +tickets[i][1], tickets);
                used[i] = false;
            }
        }
    }

}

