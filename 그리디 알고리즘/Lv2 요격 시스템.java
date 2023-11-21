/*
    프로그래머스 Lv1 요격시스템

    미사일 구간을 끝나는 위치 순으로 오름차순 정렬하여 순차적으로 돌면서
    끝 구간 까지 있는 미사일들을 모두 터트림
    -> 그 이전 구간은 볼 필요 없으므로 end에 해당 구간의 끝을 넣음
    또 넣어준 end가 다른 start보다 작으면 또 터트리고 반복 

 */


import java.util.Arrays;
import java.util.Comparator;

class Main {


    public static void main(String[] args) {
        // 입력 예제
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
        //


        int end = 0;
        int answer = 0;

        Arrays.sort(targets, Comparator.comparingInt(o -> o[1])); // 두번째 요소를 기준으로 오름차순 정렬



        for (int i = 0; i < targets.length; i++) {
            int s = targets[i][0];
            int e = targets[i][1];

            if(s >= end){
                end = e;
                answer++;
            }
        }

        System.out.println(answer);

    }



}

