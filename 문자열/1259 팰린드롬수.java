/**
 * 1259 팰린드롬수
 * StringBuilder는 비교시 ==와 equals()사용 불가
 * 객체의 주소값을 비교함
 * StringBuilder로 reverse한뒤에 String으로 형변환함
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb;
        String s;


        while(!((s=bf.readLine()).equals("0"))){
            sb = new StringBuilder(s);
            String reverse = String.valueOf(sb.reverse());

            if (s.equals(reverse)) {
                System.out.println("yes");
            }
            else
                System.out.println("no");

        }

    }
}