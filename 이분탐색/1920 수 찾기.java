/*
 * 1920 수 찾기
 * Map으로도 가능하지만 이분탐색을 사용
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int item = Integer.parseInt(st.nextToken());
            arr[i] = item;
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int[] check = new int[M];

        for (int i = 0; i < M; i++) {
            int item = Integer.parseInt(st.nextToken());
            check[i] = item;
        }

        for (int i = 0; i < M; i++) { // check 요소들이 arr에 있는지 없는지 확인
            int c = check[i];
            int left = 0;
            int right = N - 1;
            int mid;
            while (true) {
                mid = (left + right) / 2;
                if (arr[mid] == c) {
                    sb.append(1 + "\n");
                    break;
                }
                if (right <= left) {
                    sb.append(0 + "\n");
                    break;
                }
                if (arr[mid] > c) {
                    right = mid - 1;
                } else if (arr[mid] < c) {
                    left = mid + 1;
                }

            }
        }
        System.out.println(sb);
    }
}