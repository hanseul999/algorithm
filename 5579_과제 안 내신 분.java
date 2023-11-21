import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int [] a = new int[31];
        for(int i=0;i<28;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            a[Integer.parseInt(st.nextToken())] = 1;
        }

        for(int i=1;i<a.length;i++){
            if(a[i]!=1){
                System.out.println(i);
            }
        }

    }
}