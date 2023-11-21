/*
    프로그래머스 Lv1 덧칠하기
 */

import java.util.Arrays;

class Solution {

    /**
     *
     * @param n : 벽의 길이 - 구역은 1미터씩 n개로 나눔
     * @param m : 롤러의 길이
     * @param section : 다시 페인트를 칠하기로 정한 구역들의 번호
     * @return : 롤러로 페인트칠해야 하는 최소 횟수
     */
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] painted = new boolean[n + 1];
        Arrays.fill(painted, true);
        for (int i = 0; i < section.length; i++) {
            painted[section[i]] = false;
        }

        for (int i = 1; i < painted.length; i++) {
            if (!painted[i]) { //안칠해져 있는 부분을 칠해줌
                for (int j = i; ((j < i + m) && (j < n + 1)); j++) { //롤러 길이만큼-배열에서 벗어나지 않게
                    painted[j] = true;
                }
                answer++;
                i += (m-1); //칠해준 만큼은 건너 뛰도록
            }
        }
        return answer;
    }
}


/*
    프로그래머스 Lv1 덧칠하기
    section이 오름차순이므로 배열을 사용하지 않아도 됨
 */


class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        int idx = 0; //section idx
        for (int i = 1; i <= n && idx < section.length; i++) { // i : location

            if (section[idx] == i) {
                i += (m - 1); //칠해준만큼 location 이동
                idx++;
                answer++;
                for (int j = idx; j < section.length; j++) {
                    //section 위치가 이미 칠해진 구역이면 idx 증가
                    if (section[idx] <= i) {
                        idx++;
                    }else{
                        break;
                    }
                }
            }
        }
        return answer;

    }
}