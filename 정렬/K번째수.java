/*
   프로그래머스 Lv1 K번째수
   1. 문제 요구사항대로 잘라주고 정렬
   2. 선택정렬 -> 왼쪽에 정렬되니 num까지만 정렬
 */
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int s = commands[i][0];
            int e = commands[i][1];

            if (s == e) {
                answer[i] = array[s - 1];
                continue;
            }

            int[] temp = new int[e - s + 1]; //자른 배열을 담을 배열


            int l = 0;
            for (int j = s - 1; j < e; j++) { // 배열 자르기
                temp[l] = array[j];
                l++;
            }


            int num = commands[i][2]; // num 번째의 수를 찾으려함
            int minIdx; int t;
            for (int j = 0; j < num; j++) { //선택정렬
                minIdx = j;
                for (int k = j; k < temp.length; k++) {
                    if (temp[minIdx] > temp[k]) {
                        minIdx = k;
                    }
                }
                //swap
                t = temp[j];
                temp[j] = temp[minIdx];
                temp[minIdx] = t;
            }

            answer[i] = temp[num - 1]; // num번재 수-> num-1 index

        }

        return answer;
    }
}