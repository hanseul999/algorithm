/*
1715 카드 정렬하기
첫번째, 두번째로 작은 값을 더하고
바로 사용해야하므로 우선순위 큐 사용
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Long.valueOf(br.readLine()));
        }

        int answer = 0;
        long a;
        long b;
        long temp;
        while (pq.size() >= 2) {
            temp = pq.poll() + pq.poll();
            answer += temp;
            pq.add(temp); //합친 묶음 다시 넣기 
        }

        System.out.println(answer);

    }
}