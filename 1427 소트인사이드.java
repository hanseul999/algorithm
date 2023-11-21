/**
 * 1427 소트인사이드
 * sort()를 사용해서 정렬이라기보단 
 * 문자열 연산..
 * 나중에 카운팅 정렬로 해보기
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        StringBuilder buff = new StringBuilder();


        String N = bf.readLine();


        int arr[] = new int[N.length()];


        for (int i = 0; i < N.length(); i++) {
            arr[i] = N.charAt(i)-'0';
        }


        Arrays.sort(arr);

        for (int i = 0; i < N.length(); i++) {
            buff.append(arr[i]);
        }


        String reverse = String.valueOf(buff.reverse());
        System.out.println(reverse);


    }

}