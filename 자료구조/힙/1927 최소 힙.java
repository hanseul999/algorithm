/*
1927 최소 힙
PriorityQueue 사용
 */

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> q = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                q.add(x);
            }else if(q.isEmpty()){
                sb.append(0 + "\n");
            }else{
                Integer poll = q.poll();
                sb.append(poll).append("\n");
            }
        }

        System.out.println(sb);

    }
}