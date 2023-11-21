/*
프로그래머스 Lv2 캐시
2018 KAKAO BLIND RECRUITMENT
 */


import java.util.Arrays;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        cities = Arrays.stream(cities)
                .map(String::toLowerCase)
                .toArray(String[]::new);


        String[] cacheArray = new String[cacheSize];
        int[] used = new int[cacheSize]; //LRU

        Arrays.fill(used, 0);
        Arrays.fill(cacheArray, "");

        int maxIndex = 0;
        boolean cacheHit;
        for (int i = 0; i < cities.length; i++) {

            cacheHit = false;

            for (int j = 0; j < cacheSize; j++) {
                used[j] += 1;
            }

            for (int j = 0; j < cacheSize; j++) {
                if (cacheArray[j].equals(cities[i])) { //cache hit
                    answer += 1;
                    used[j] = 0;
                    cacheHit = true;
                    break;
                }
            }

            if (cacheHit) {
                continue;
            }

            //cache miss
            maxIndex = 0;
            for (int j = 1; j < cacheSize; j++) {
                //가장 오랫동안 참조되지 않은 페이지 검색
                if (used[maxIndex] < used[j]) {
                    maxIndex = j;
                }
            }

            cacheArray[maxIndex] = cities[i];
            used[maxIndex] = 0;
            answer += 5;

        }

        return answer;
    }
}