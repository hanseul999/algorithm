/*
    백준 실버5 11723 집합

    메모리 제한이 있는 문제 << bitmask로 메모리를 효율적으로 사용 가능
    int 자료형 변수를 선언하면 4byte(4 * 8bit)를 메모리에 할당받아
    총 32가지의 참, 거짓을 판단할 수 있다
    2^0자리 -> 0의 참,거짓
    2^1자리 -> 1의 참,거짓
    이런식
 */


import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        int bit = 0;

        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        int num;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    bit = bit | (1 << (num - 1));
                    // num - 1 << idx (0번째부터 시작)
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    bit = bit & ~(1 << (num - 1));
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    answer.append((bit & (1 << (num - 1))) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    bit = bit ^ (1 << (num - 1));
                    break;
                case "all":
                    bit = bit | (~0);
                    break;
                case "empty":
                    bit = 0;
                    break;
            }
        }
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

}

