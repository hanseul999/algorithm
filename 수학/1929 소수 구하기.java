/**
 * 1929 소수 구하기
 *
 * m 이상 n 이하의 모든 소수 구하기
 *
 *  에라토스테네스의 체를 이용
 *
 *  에라토스테네스의 체 : k=2 부터 √n 이하까지 반복하여
 *  자연수들 중 k를 제외한 k의 배수들을 제외시킨다
 */

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        boolean[] arr = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            arr[i] = false;
        }
        //2부터 √n까지 i의 배수들을 배열에서 지움
        for (int i = 2; i <=  Math.sqrt(n); i++) {
            if (arr[i]) {
                continue;
            }
            for (int j = i * i; j < arr.length; j += i) {
                arr[j] = true; //배열에서 지움
            }
        }
        arr[1] = true; //1은 소수가 X
        for (int i = m; i <= n; i++) {
            if (!arr[i]) {
                System.out.println(i);
            }
        }


    }



}