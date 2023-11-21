import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int answer=0;
        int N = Integer.parseInt(st.nextToken());
        int [] a = new int[N];

        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        int v = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            if(a[i]==v)
                answer++;
        }
        System.out.println(answer);
    }
}