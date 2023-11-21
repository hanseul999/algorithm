/*
11660 구간 합 구하기 5
2차원 배열로 구간 합 구하기
-> 가로 + 세로 - 중복부분 + 그자리 일반 배열
구간 합 출력하기
->  (x1, y1) (x2, y2)
에서 큰 네모 - 가로 네모(x2,y1-1) - 세로 네모( x1-1 , y2 ) + 중복제거된 부분 (x1-1, y1-1)
헷갈리면 네모 그려서
++

BufferedReader + StringTokenizer로 바꾼 코드

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] array = new int[N+1][N+1];
        int x1, y1, x2, y2;

        int[][] D = new int[N+1][N+1]; // i부터 j까지의 합 배열

        for(int i=1;i<=N;i++){ //표 입력받음
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=N;j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }

        }
        for(int i=1;i<=N;i++){ //구간 합 배열 구하기

            for(int j=1;j<=N;j++){

                D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + array[i][j];

            }


        }


        for(int i=0;i<M;i++){ //출력

            st = new StringTokenizer(bf.readLine());

            x1=Integer.parseInt(st.nextToken());
            y1=Integer.parseInt(st.nextToken());

            x2=Integer.parseInt(st.nextToken());
            y2=Integer.parseInt(st.nextToken());
            System.out.println(D[x2][y2] - D[x2][y1-1] - D[x1-1][y2] + D[x1-1][y1-1] );

        }

    }
}