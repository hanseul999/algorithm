/*
    프로그래머스 Lv2 올바르 괄호
    
 */


import java.util.Stack;

class Main {
    public static void main(String[] args){
        // 입력 예제
        String s = "(()(";
        //
        Stack<Character> stack = new Stack<>();
        boolean answer = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }else{
                if (stack.isEmpty()) {
                    // return false;
                    answer = false;
                    break;
                }else{
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            answer = false;
            //return false;
        }else{
            //return true;
        }
        System.out.println(answer); //return answer

    }



}

