/*
    백준 2750 수 정렬하기 - 퀵 정렬
 */


import java.util.Scanner;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        leftPivotSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.println(num);
        }

    }

    /**
     *
     * @param arr   : 정렬할 배열
     * @param lo    : 현재 부분 배열의 왼쪽
     * @param hi    : 현재 부분 배열의 왼쪽
     */
    private static void leftPivotSort(int[] arr, int lo, int hi) { // 왼쪽 피벗 선택 방식

        if (lo >= hi) {
            // 정렬할 원소가 1개 이하인 경우
            return;
        }
        int pivot = partition(arr, lo, hi);

        leftPivotSort(arr, lo, pivot - 1); // pivot을 기준으로 쪼개서 왼쪽 부분에 대해 위 과정 반복
        leftPivotSort(arr, pivot + 1, hi);// pivot을 기준으로 쪼개서 오른쪽 부분에 대해 위 과정 반복
    }

    private static int partition(int[] arr, int left, int right) {
        int lo = left;
        int hi = right;
        int pivot = arr[left];	// 부분리스트의 왼쪽 요소를 피벗으로 설정

        while(lo < hi) {

            while(arr[hi] > pivot && lo < hi) {
                // 오른쪽에 있는 요소가 피벗보다 작아질때 까지 hi 감소
                // -> 피벗보다 작은 값을 찾음
                hi--;
            }

            while(arr[lo] <= pivot && lo < hi) {
                // 왼쪽에 있는 요소가 피벗보다 커질때 까지 lo 증가
                // -> 피벗보다 큰 값을 찾음
                lo++;
            }

            // 위에서 찾은 두 요소를 swap
            swap(arr, lo, hi);
        }

        swap(arr, left, lo); // 피벗과 lo 교환

        return lo;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}