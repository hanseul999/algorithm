/*
    프로그래머스 Lv1 체육복
 */

import java.util.Arrays;


class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 전체 학생의 수 n,
        // 체육복을 도난당한 학생들의 번호가 담긴 배열 lost,
        // 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve
        // 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있음
        // 우선적으로 여유분을 가진 학생이 도난당하였으면 자기것을 입어야함\

        int answer = n - lost.length; //도난당하지 않는 학생수에서 시작
        

        /*
        lost 1 2 4
        reverse 3 5
        이런식으로 있을 경우 2가 5껄 먼저 빌려버리면 4가 빌릴게 없어짐.
        정렬후 처리 필요
         */
        Arrays.sort(reserve);
        Arrays.sort(lost);

        //도난당했다면 본인 여유분을 먼저 입어준다
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) { //앞-뒤에 빌릴수 있는지 
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }


        return answer;

    }
}