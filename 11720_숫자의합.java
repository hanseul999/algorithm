/*
11720 숫자의 합
문자열로 받은뒤 -> 문자로 하나씩 넣어줌
parseInt쓰려고 문자 하나를 문자열로 바꿔줬는데
number[i] - '0';으로 바로 문자를 정수형으로 변환도 가능
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String input = sc.next();
        char[] number = input.toCharArray();
        int total = 0;

        for(int i=0;i<n;i++){
            total+=Integer.parseInt(String.valueOf(number[i]));
        }

        System.out.println(total);
    }
}