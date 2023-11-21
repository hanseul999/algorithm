/*
    프로그래머스 Lv2 주식가격
 */


import java.util.*;

class Main {


    public static void main(String[] args) {
        // 입력 예제
        int[] prices = {2, 2, 3, 1, 5};
                /*
                     초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
                     가격이 떨어지지 않은 기간은 몇 초인지를 return
                 */
        //

        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {

            while (!stack.isEmpty() && prices[i] < prices[stack.peek()] ) { //가격하락
                int idx = stack.pop();
                answer[idx] = i - idx; //유지 시간
            }
            stack.push(i); // idx 저장
        }


        while (!stack.isEmpty()) { //끝까지 하락하지 않은 애들
            int idx = stack.pop();
            answer[idx] = prices.length - idx - 1;
        }

        // 정답
        for (int a : answer) {
            System.out.println(a);
        }

    }
}

