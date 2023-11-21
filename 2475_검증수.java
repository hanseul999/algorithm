import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2475
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] arr = new int[5];
        int buff;
        int answer=0;

        for(int i=0;i<arr.length;i++){
            buff = Integer.parseInt(st.nextToken());
            answer += buff*buff;

        }


        System.out.println(answer%10);


    }
}