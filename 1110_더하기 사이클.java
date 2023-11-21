/**
 * 1110번 더하기 사이클
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int cnt=0;

        String N = st.nextToken();

        if(N.length()==1)
            N = "0"+N;
        

        String buff = N;

        while(N.length()==2){

            int a = N.charAt(0) - '0';
            int b = N.charAt(1) - '0';
            N = String.valueOf((a + b));



            if(N.length()==2){
                N = Integer.toString(b) + Integer.toString((N.charAt(1) - '0'));
            }
            else{
                N = b + N;
            }

            cnt++;

            if(N.equals(buff))
                break;

        }

        System.out.println(cnt);
    }

}