/*
 * 10773 제로
 *
 * 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다. << 스택 구현
 *
 * 입력이 크므로 BufferedReader 사용
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = 0;
        int k = Integer.parseInt(br.readLine());
        String[] stack = new String[k];

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("0")) {
                size--;
            }else{
                stack[size] = s;
                size++;
            }
        }
        int answer = 0;
        for (int i = 0; i < size; i++) {
            answer += Integer.parseInt(stack[i]);
        }
        System.out.println(answer);
    }
}