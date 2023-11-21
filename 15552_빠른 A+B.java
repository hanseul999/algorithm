import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 15552 빠른 A+B
 * Sccaner와 System.out.println 대신
 * BufferedReader와 BufferedWriter를 사용하면 됨
 */

public class Main {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
        //sc.close();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int T = Integer.parseInt(st.nextToken());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            bw.append(String.valueOf(A + B)+"\n");
        }

        bw.flush();
    }
}