/*
프로그래머스 Lv2 최댓값과 최솟값
 */
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s);

        int[] arr = new int[st.countTokens()];
        int i = 0;

        while (st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        Arrays.sort(arr);
        answer = arr[0] + " " + arr[arr.length - 1];
        return answer;
    }
}