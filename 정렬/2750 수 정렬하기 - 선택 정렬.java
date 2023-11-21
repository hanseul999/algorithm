/**
 * 2750번 수 정렬하기
 * 선택 정렬
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        int min_index;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        for (int i = 0; i < N-1; i++) {
            min_index = i;
            for (int j = i+1; j < N; j++) {
                if (arr[min_index] > arr[j]) { //최솟값 구하기
                    min_index = j;
                }
            }
            swap(arr, i, min_index);
        }

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void swap(int[] arr, int i, int min_index) {
        int buff;
        buff = arr[min_index];
        arr[min_index] = arr[i];
        arr[i] = buff;
    }
}