/**
 * 10817 세 수
 * 버블정렬, 선택정렬, 삽입정렬,
 * 계수정렬
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N = 3; //배열크기

    //계수정렬에서 사용
    static int[] result = new int[N];
    static int[] count;
    static int[] sum;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[N];

        max = 0; //계수정렬에서 사용
        for (int i = 0; i < N; i++) {
            int value = sc.nextInt();
            max = Math.max(max, value);
            arr[i] = value;
        }
        count = new int[max + 1]; //max 인덱스까지 사용하므로 +1 
        sum = new int[max + 1];


        //bubble(arr);
        //selection(arr);
        //insertion(arr);
        counting(arr);



        /*
         * 계수정렬은 result에,
         * 나머지는 arr원본에서 정렬
         */


    }

    static void bubble(int[] arr) {
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
    static void selection(int[] arr) {

        for (int i = 0; i < N - 1; i++) {
            int minIndex = i;
            for (int j = i; j < N; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    static void insertion(int[] arr) {
        for(int i = 1 ; i < N ; i++){
            int temp = arr[i]; //삽입할 요소
            int j; //삽입할 위치
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1]; // 오른쪽으로 밀림
            }
            arr[j] = temp; // 삽입
        }
    }

    static void counting(int[] arr) {

        for (int i = 0; i < N; i++) { //2번
            count[arr[i]]++;
        }

        int total = 0;
        for (int i = 0; i <= max; i++) { //3번
            total += count[i];
            sum[i] = total;
        }

        for (int i = N - 1; i >= 0; i--) { //4번
            int num = arr[i];
            result[sum[num] - 1] = num; // n번째에 위치하는 거고, 인덱스는 0부터 시작하니 -1
            sum[num]--; //다음 동일 값을 위해 -1
        }

    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}