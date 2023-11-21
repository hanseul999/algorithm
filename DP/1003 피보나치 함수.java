/*
1003 피보나치 함수
재귀 함수로 풀면 O(n^2)의 시간복잡도가 나오므로 DP로 접근

f(2) = f(1) + f(0) -> 1번 / 1번
f(3) = f(2) + f(1) = f(1) + f(0) + f(1) -> 1번 / 2번
f(4) = f(3) + f(2) -> 3번 / 2번
하위 문제들이 중복되는것을 확인 가능
한 번 탐색시 각 n에 대한 0과 1의 값을 저장해두고
탐색했던 요소인 경우 해당 배열값을 사용한다

	dp[n][0]: fibonacci(n)를 호출했을 때, fibonacci(0)이 몇 번 호출되는지
	dp[n][1]: fibonacci(n)를 호출했을 때, fibonacci(1)이 몇 번 호출되는지

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Integer[][] dp = new Integer[41][2];



    static Integer[] fibonacci(int n) {
        if (dp[n][0] == null || dp[n][1] == null) {
            //이미 계산된 값에 대해서는 중복하여 재귀하지 않도록 
            dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }
        return dp[n];
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        // 초기값 설정
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        int n = 0;
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            fibonacci(n);
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }
        System.out.println(sb);
    }
}