/*
프로그래머스 Lv1 폰켓몬
중복값을 제거하기 위해 HashSet 사용

중복값을 제거한 포켓몬 수 > 가질 수 있는 포켓몬
라면 가질 수 있는 포켓몬 수만큼만 가질 수 있고
아니라면 중복을 제외한 포켓몬 수만큼 가질 수 있다 

 */

import java.util.*;

class Solution {
    public int solution(int[] nums) {


        int n = nums.length / 2; //가질 수 있는 포켓몬 수

        Set hs = new HashSet();


        for(int i=0; i< nums.length ; i++){
            hs.add(nums[i]);
        }

        if (hs.size() > n) {
            return n;

        }else{
            return hs.size();
        }

    }
}