/*
11286 절댓값 힙
compare를 절댓값을 기준으로 오름차순 정렬을 하게끔 오버라이드
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>(
                new Comparator<Long>() {
                    @Override
                    public int compare(Long o1, Long o2) {

                        long O1 = Math.abs(o1);
                        long O2 = Math.abs(o2);

                        if (O1 == O2) {
                            if (o1 > o2) {
                                return 1; //o1이 o2보다 뒤에 위치하게됨
                            }else{
                                return -1; //o1이 o2보다 앞에 위치하게됨
                            }
                        }else{
                            return (int) (O1 - O2); 
                            // o1의 절댓값이 더 큰 경우 양수를 return하여 o1이 o2보다 뒤에 위치하게됨
                            // o2의 절댓값이 더 큰 경우 음수를 return하여 o1이 o2보다 앞에 위치하게됨
                            // 둘의 절댓값이 같은 경우 0을 return 하여 o1와 o2가 동일한 순서로 정렬됨 
                        }
                    }
                }
        );

        Long x;
        for (int i = 0; i < N; i++) {
            x = Long.valueOf(br.readLine());
            if (x.equals(0L)) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                }else{
                    sb.append(pq.poll()).append("\n");
                }
            }else{
                pq.add(x);
            }
        }

        System.out.println(sb);

    }
}