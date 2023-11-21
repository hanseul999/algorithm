/*
    프로그래머스 Lv1 같은 숫자는 싫어
    주어진 배열 arr에 연속적으로 나타나는 숫자는 제거

    스택사용
    1. 스택에 넣고 peek해서 연속된 수인지 확인 - 연속되지 않았다면 집어넣어줌
    2. 스택사이즈의 answer배열 만들고 역순으로 집어넣어주기(후입선출)
 */


import java.util.Stack;

class Main {
    public static void main(String[] args){
        // 문제 입력 예제
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        //
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() != arr[i]) { //스택에 들어가있는것과 같다면 넘어감
                stack.push(arr[i]);
            }
        }

        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        for (int n : answer) {
            System.out.println(n);
        }

        //return answer;


    }
    
}