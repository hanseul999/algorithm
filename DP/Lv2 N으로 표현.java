/*
    프로그래머스 Lv2 N으로 표현
     숫자 N과 number가 주어질 때,
     N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return

    map에 1~8개의 N으로 만들 수 있는 수를 1부터 저장해나감
    ex) 3개로 만들 수 있는 수는 1개로 만들 수 있는 수와 2개로 만들 수 있는 수의 사칙연산으로 이루어짐 
        4개는 1+3 or 2+2 
        하여 예전에 저장해둔 수를 꺼내서 사칙연산에 이용한다 


 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


class Solution {

    static Map<Integer, ArrayList<Integer>> map;

    static void union(ArrayList<Integer> sum,
                      ArrayList<Integer> arr1,
                      ArrayList<Integer> arr2) {

        for (int i = 0; i < arr1.size(); i++) {
            Integer num1 = arr1.get(i);
            for (int j = 0; j < arr2.size(); j++) {
                Integer num2 = arr2.get(j);
                sum.add(num1 + num2);
                sum.add(num1 - num2);
                sum.add(num1 * num2);
                if (num2 != 0) { //분모0 X
                    sum.add(num1 / num2);
                }
            }
        }

    }

    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }

        //초기화
        map = new HashMap<>();
        for (int i = 0; i <= 8; i++) { //최솟값이 8보다 크면 return -1
            map.put(i, new ArrayList<>());
        }
        ArrayList<Integer> arr1 = map.get(1);
        arr1.add(N); //1개로 만들 수 있는건 N 하나
        //

        for (int i = 2; i < 9; i++) { // i개의 N으로 만들 수 있는 수의 집합을 구성
            ArrayList<Integer> list = map.get(i);
            for (int j = 1; j <= i / 2; j++) { // j와 i-j에 해당하는 집합의 순서쌍을 이용(순서쌍이라 i/2까지만 돌려도 됨)
                union(list, map.get(i - j), map.get(j));
                // 연산의 순서로 결과가 달라질 수 있으므로
                // arr1<->>arr2의 순서를 바꿔서 한번 더
                union(list, map.get(j), map.get(i-j));
            }
            String n = Integer.toString(N);
            list.add(Integer.parseInt(n.repeat(i))); // NNN~ 넣기

            for (int k = 0; k < list.size(); k++) {
                // i개로 number를 만들 수 있는지 검사
                int num = list.get(k);
                if (num == number) {
                    return i;
                }
            }
        }

        return -1;
    }
}