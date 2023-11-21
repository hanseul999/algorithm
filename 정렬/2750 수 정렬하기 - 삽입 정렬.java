import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 2750 수 정렬하기
 * 삽입 정렬
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        int buff;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }


        for(int i=1 ; i<N ; i++){
            int k = i;
            buff = arr[i]; //삽입할 요소
            while (k > 0 && arr[k - 1] >buff) {
                arr[k] = arr[k - 1]; //오른쪽으로 밀림
                k--;
            }
            arr[k] = buff; //삽입
        }


        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}

