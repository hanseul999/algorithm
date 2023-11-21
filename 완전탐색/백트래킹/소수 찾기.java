/*
   프로그래머스 Lv2 소수찾기
   1. 백트래킹으로 가능한 숫자 조합 알아내기
   2. 소수인지 판단
 */


import java.util.*;

class Solution {

    static int[] nums;
    static int[] arr;
    static boolean[] visited;
    static Set<Integer> hs = new HashSet<>(); //중복 제거를 위해 HashSet 사용
    static int cnt;
    static int answer = 0;

    public int solution(String numbers) {

        cnt = numbers.length();

        nums = new int[numbers.length()];
        arr = new int[numbers.length()];
        visited = new boolean[numbers.length()];
        Arrays.fill(visited, false);

        for (int i = 0; i < nums.length; i++) { //수들 분리해서 담아줌
            nums[i] = numbers.charAt(i) - '0';
        }

        for (int i = 1; i <= cnt; i++) {
            recursion(0, i); //각각의 길이만큼의 수 조합
        }

        for (Integer value : hs) {
            find(value); //각각 소수인지 아닌지 검사
        }

        return answer;
    }

    private static void find(int n) { //소수인지 아닌지 판단

        if (n == 1 || n == 0) {
            return;
        }

        for (int i = 2; i < (n / 2) + 1; i++) {
            if (n % i == 0) {
                return;
            }
        }
        answer++;
    }

    private static void recursion(int idx, int r) { //백트래킹

        if (idx == r) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++) {
                sb.append(arr[i]);
            }
            hs.add(Integer.valueOf(String.valueOf(sb)));
            return;
        }

        for (int i = 0; i < cnt; i++) {
            if (!visited[i]) {
                arr[idx] = nums[i];
                visited[i] = true;
                recursion(idx + 1, r);
                visited[i] = false;
            }
        }


    }
}