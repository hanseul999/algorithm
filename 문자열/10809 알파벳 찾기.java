/**
 * 10809 알파벳 찾기
 * 알파벳 배열 만들어줘서
 * 해당 알파벳이 나오면(아스키코드로 소문자가 97~122이라 -97해줌)
 * 해당 위치에 몇번째인지 기록
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[26];
        Arrays.fill(array, -1);

        String answer = bf.readLine();

        for (int i = 0; i < answer.length(); i++) {

            if (array[answer.charAt(i)-97] == -1) {
                array[answer.charAt(i)-97]=i;
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }


    }
}