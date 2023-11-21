/*
프로그래머스 Lv1 완주하지 못한 선수
동명이인이 있을 수 있으므로 
HashMap을 사용하여 참가자의 value를 조절
 */


import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> hm = new HashMap();

        for(int i=0; i<participant.length ; i++){
            hm.put(participant[i], hm.getOrDefault(participant[i], 0)+1);
        }

        for(int i=0; i < completion.length ; i++){
            hm.put(completion[i], hm.get(completion[i]) - 1);
        }

        for (String key : hm.keySet()) {
            if ( hm.get(key) != 0 ) { //완주하지 못한 선수
                answer = key;
            }
        }

        return answer;

    }
}
