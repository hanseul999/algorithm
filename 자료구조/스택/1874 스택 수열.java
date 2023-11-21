/*
1874번
스택에 집어넣는 수는 1부터 1씩 증가
- 세 가지 케이스로 분리
- 필요한 값 < 집어넣을 수 && 필요한 값 > peekNum 이면
  입력된 수열을 만들 수 없음 -> exit

+ 출력할 문자들을 문자열로 엮으면 메모리 초과가 발생.
    //String 객체는 immutable이라 한 번 생성되면 수정되지 않고
    //새로운 String객체에 덧붙이는 방식으로 하기 때문
    => StringBuilder로 해결
 */

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //String print =""; << String으로 하면 메모리 초과
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[]a = new int[n];

        int peekNum=0;

        Stack<Integer> stack = new Stack<>();

        int number=1; //스택에 push할 자연수

        for(int i=0;i<n;i++){ // 입력을 배열에 저장
            st = new StringTokenizer(bf.readLine());
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n;i++){
            int num = a[i]; //구해야할 숫자

            if( num >= number){
                while(peekNum != num){ //원하는 수가 될때 까지 push해줌
                    stack.push(number++);
                    peekNum = stack.peek();
                    sb.append("+\n");

                }
                stack.pop(); //원하는 수를 pop으로 얻음
                sb.append("-\n");
            }
            else{
                peekNum = stack.pop();
                   if(peekNum < num){
                       System.out.println("NO");
                       System.exit(0);
                    }
               else{
                    sb.append("-\n");
                }
            }


        }
        sb = new StringBuilder(sb.substring(0, sb.length() - 1));
        System.out.println(sb);
    }

}