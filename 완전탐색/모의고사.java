/*
   프로그래머스 Lv1 모의고사
 */

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[3]; //점수
        score[0] = func(first, answers);
        score[1] = func(second, answers);
        score[2] = func(third, answers);
        

        int max = 0; //최대점수 찾기
        for (int i = 0; i < 3; i++) { 
            if (max < score[i]) {
                max = score[i];
            }
        }

        List<Integer> list = new ArrayList<>();
        // 최대점수면 리스트에 넣기 
        for (int i = 0; i < 3; i++) {
            if (max == score[i]) {
                list.add(i+1);
            }
        }
        
        //배열로 반환 
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;

    }
    private static int func(int[] arr, int[] answers) {

        int answer = 0;

        for (int i = 0; i < answers.length; i++) {
            if (arr[i % arr.length] == answers[i]) {
                answer++;
            }
        }

        return answer; //맞은 문제 갯수 반환 
    }
}