/*
    백준 2805 실버2 나무 자르기
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static long[] tree;
    static long H; // 절단기의 높이
    static long M; // 필요한 나무 M미터
    static long sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken()); // 나무 수
        M = Long.parseLong(st.nextToken());
        tree = new long[(int) N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Long.parseLong(st.nextToken());
        }

         /*
            이분탐색으로 자르는 위치를 구한다.
            mid 에서 잘랐을때의 합을 구하고
            sum > 필요한 나무 -> 덜 잘라야되니 left = mid + 1 << 여기서 덜자르면 아무것도 안남는 경우가 있음
            sum < 필요한 나무 -> 더 잘라야되니 right = mid - 1
         */

        Arrays.sort(tree); //가장 높은 나무를 기준으로 자르기 위해
        recursion(1, (int) tree[tree.length - 1]);

        if (sum < M) { //덜 잘라도 돼서 높였는데 그게 끝인경우가 있음. 그런경우 줄여줌 ( ex - 3 1  /  1 2 2 )
            H -= 1;
        }
        System.out.println(H);
    }

    static void recursion(long left, long right) {


        if (right < left) {
            return;
        }

        long mid = (left + right) / 2;

        sum = 0;
        for (int i = 0; i < tree.length; i++) {
            long t = tree[i] - mid; // 잘리고 남은거
            if (t > 0) {
                sum += t;
            }
            if (sum > M) {
                break;
            }
        }

        H = mid;

        if (sum < M) { // 덜 잘라야되는 경우
            recursion(left, mid - 1);
        } else if(sum > M){ // 더 잘라야되는 경우
            recursion(mid + 1, right);
        }


    }

}