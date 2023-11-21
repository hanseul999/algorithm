/*
9012
괄호
스택 문제
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int t = Integer.parseInt(st.nextToken());

       String input[] = new String[t];

        for(int i=0;i<t;i++){


 		st = new StringTokenizer(bf.readLine());
            input[i] = st.nextToken();

            Stack<Character> stack = new Stack<Character>();
            boolean finish = false;


            for(int j=0;j<input[i].length();j++){
                char c = input[i].charAt(j);

                if(c=='('){
                    stack.push(c);
			}
                else if(stack.empty()){ //스택이 비어있는 경우
                    System.out.println("NO");
                    finish = true;
                    break;
                }
                else{
                    stack.pop();
                }

            }

            if(!finish){
                //스택잔여 검사
                if(stack.empty()){ //스택이 비어있는 경우
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }




        }


    }
}