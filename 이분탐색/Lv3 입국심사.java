/*
    프로그래머스 Lv3 입국심사

    이분탐색
    mid를 통해 각 심사관이 몇 명을 심사할 수 있는지 확인


 */


import java.util.Arrays;

class Main {


    public static void main(String[] args) {
        // 입력 예제
        int n = 6;   // 입국심사 대기 인원
        int[] times = {7, 10};  //각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열
        //

        Arrays.sort(times);

        long answer = 0;
        long left = 0;
        long right = (long) times[times.length - 1] * n; //최악의 경우

        while (left <= right) {
            long mid = (left + right) / 2; //소요시간 

            long sum = 0; //처리 가능 인원수 
            for (int t : times) {
                sum += mid / t;
            }

            if (sum >= n) {
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}

