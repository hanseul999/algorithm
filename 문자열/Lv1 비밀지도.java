/*
    프로그래머스 Lv1 비밀지도
    2018 KAKAO BLIND RECRUITMENT

    문자열 변환

 */


import java.util.Arrays;

class Main {

    public static void main(String[] args){
        // 문제 입력 예제
        int n = 5; // 한 변의 길이
        int[] arr1 = {9, 20, 28, 18, 11}; // 지도 1
        int[] arr2 = {30, 1, 21, 17, 28}; // 지도 2
            /*
                각각의 지도는 각 가로줄에서
                벽 부분을 1, 공백 부분을 0으로 한 이진수를 십진수로 바꾼 값
                두 지도를 겹쳐서 전체 지도를 만들고 하나라도 벽인 부분은 벽
                전체지도를 만들어서 벽은 '#'으로, 아니면 공백으로 된 문자열 배열 return
             */
        //
        String[][] map = new String[n][n];
        for (String[] m : map) {
            Arrays.fill(m, " ");
        }
        for (int i = 0; i < n; i++) {
            StringBuilder s1 = new StringBuilder(Integer.toBinaryString(arr1[i]));
            StringBuilder s2 = new StringBuilder(Integer.toBinaryString(arr2[i]));

            while (s1.length() < n) {
                s1.insert(0, "0");
            }
            while (s2.length() < n) {
                s2.insert(0, "0");
            }

            for (int j = 0; j < n; j++) {
                if ((s1.charAt(j) == '1') || (s2.charAt(j) == '1')) {
                    map[i][j] = "#";
                }
            }
        }


        String[] answer = new String[n];

        for (int i = 0; i < answer.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < map[i].length; j++) {
                sb.append(map[i][j]);
            }
            answer[i] = String.valueOf(sb);
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        } //return answer;

       

    }
    
}

