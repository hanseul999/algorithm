/*
   4673 셀프 넘버
 */

import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] arr;
    public static void main(String[] args){
        int N = 10000;

        arr = new boolean[N + 1];
        Arrays.fill(arr, false);

        for (int i = 1; i <= arr.length; i++) {
            int n = func(i);
            if (n <= N) {
                arr[n] = true;
            }
        }


        for (int i = 1; i < arr.length; i++) {
            if (!arr[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);

    }

    public static int func(int N) { //N으로 만들 수 있는 수 찾기 

        int sum = N;

        while (N != 0) { //각 자릿수 더하기 
            sum += N % 10;
            N /= 10;
        }

        return sum;

    }


}
