/**
 * 10845 큐
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static int back;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        String s;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s = st.nextToken();

            switch (s) {
                case "push":
                    back = Integer.parseInt(st.nextToken());
                    push(back);
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
    private static void push(int x) {
        queue.add(x);
    }
    private static int pop() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.poll();
    }
    private static int size() {
        return queue.size();
    }
    private static int empty() {
        if (queue.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
    private static int front() {
        if (queue.isEmpty()) {
            return -1;
        } else {
            return queue.peek();
        }
    }
    private static int back() {
        if (queue.isEmpty()) {
            return -1;
        } else {
            return back;
        }
    }



}