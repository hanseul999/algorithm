// LV 1 약수의 합
// 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.


import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 16;

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(n); i++) { // 제곱근 까지만 확인해도 됨
            if (n % i == 0){
                if (i * i == n) { // 제곱근인 경우
                    list.add(i);
                }else{ // 아니면 몫까지 약수
                    list.add(i);
                    list.add(n / i);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i);
        }

        System.out.println(answer);

    }
}