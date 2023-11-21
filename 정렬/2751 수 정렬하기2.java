/**
 * 2751 수 정렬하기 2
 * 입력이 최대 1,000,000 이므로 O(n^2) 알고리즘으로 풀면 안됨
 * 병합정렬
 *      - sorted 배열을 mergeSort에서 할당하면 함수가 호출될때마다 할당됨
 *      - 크기가 N인 메모리를 할당하는 것은 O(N) 시간이 걸리고, mergeSort는 N번 호출되기 때문에
 *      - 시간 복잡도가 O(n^2)가 되어버림
 *      - 따라서 미리 배열을 할당해줌
 *
 */

import java.io.*;

public class Main {

    static int N;
    static int[] sorted; // 합치는 과정에서 정렬하여 원소를 담을 임시배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        sorted = new int[N];

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
        }

        mergeSort(arr, 0, arr.length - 1);


        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();

    }

    static void mergeSort(int[] arr, int left, int right) {

        if (left == right) { //부분 리스트가 1개의 원소만 갖고있는 경우
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid); //절반 중 왼쪽 부분 리스트
        mergeSort(arr, mid + 1, right); //절반 중 오른쪽 부분 리스트

        merge(arr, left, mid, right); //병합

    }

    static void merge(int[] arr, int left, int mid, int right) {
        int l = left;     // 왼쪽 부분 리스트 시작점
        int r = mid + 1;  // 오른쪽 부분 리스트 시작점
        int index = left;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) { //왼쪽이 더 큰경우 배열에 왼쪽원소 넣기
                sorted[index] = arr[l];
                l++;
            }
            else { //아니라면 오른쪽원소 넣기
                sorted[index] = arr[r];
                r++;
            }
            index++;
        }

        if(l > mid) { //왼쪽 부분리스트가 먼저 모두 배열에 채워졌을 경우
                      // == 오른쪽 부분리스트가 남아있을 경우
            while(r <= right) { // 나머지 오른족 부분리스트 넣어주기
                sorted[index] = arr[r];
                index++;
                r++;
            }
        }
        else { // 오른쪽 부분리스트가 먼저 모두 배열에 채워져있을 경우
            while(l <= mid) { // 나머지 왼쪽 부분 리스트 넣어주기
                sorted[index] = arr[l];
                index++;
                l++;
            }
        }
        for(int i = left; i <= right; i++) { //정렬된 내용을 기존 배열에 복사
            arr[i] = sorted[i];
        }
    }


}