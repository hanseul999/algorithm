/*
10986
1. % M == 0 이면 answer++
2. (S[j] - S[i]) % M = 0  (나머지 연산은 분배 가능) S[j] % M - S[i] % M = 0
 즉 S[j] % M == S[i] % M 인 i j 쌍의 개수를 구하면 됨 -> 경우의 수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        long [] array = new long[(int) (N+1)]; //일반 배열
        long [] S = new long[(int) (N+1)]; //구간 합 배열
        long [] D = new long[(int) (N+1)]; //나머지 배열
        long buffAnswer[] = new  long[(int) M]; //정답 배열
        long answer=0;

        st = new StringTokenizer(bf.readLine());

        for(int i=1;i<=N;i++){
            array[i] = Integer.parseInt(st.nextToken());
            S[i] = S[i-1] + array[i]; // 구간 합 배열
            D [i] = S[i] % M; // 나머지 배열
            if(S[i]%M==0)//일단 나머지가 0이면 더해줌
                answer++;

            buffAnswer[(int) D[i]]++; //나머지 1~M이 각각 몇개있는지 저장
        }


        for(int i=0;i<M;i++){
            if(buffAnswer[i] >= 1)
                answer+=((buffAnswer[i]*(buffAnswer[i]-1))/2);//경우의 수
        }

        System.out.println(answer);


    }
}