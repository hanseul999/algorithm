/**
 * 10828 스택
 * 스택 구현하기
 * 주어진 시간이 짧으므로 BufferReader & StringBuilder
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    static String[] stack;
    static int size = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        stack = new String[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch (s) {
                case "push":
                    String item = st.nextToken();
                    push(item);
                    break;
                case "pop":
                    pop();
                    break;
                case "size":
                    sb.append(size).append("\n");
                    break;
                case "empty":
                    if (size == 0) {
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "top":
                    if (size == 0) {
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(stack[size - 1]).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(String item) {
        stack[size] = item;
        size++;
    }

    public static void pop() {
        if (size == 0) {
            sb.append(-1).append("\n");
        }else{
            sb.append(stack[size - 1]).append("\n");
            size--;
        }
    }

}