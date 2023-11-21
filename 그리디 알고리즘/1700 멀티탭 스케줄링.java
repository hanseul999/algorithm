import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); //멀티탭 구멍 갯수
        int K = Integer.parseInt(st.nextToken()); //전자기기 사용 횟수
        int arr[] = new int[K]; //사용할 순서
        int use[] = new int[N]; //사용중인 콘센트
        boolean buff[] = new boolean[K+1]; //전기용품이 사용중인지 담아둠 1~K까지 두겠음
        int answer=0; //뽑는 횟수

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < K; i++) { //사용할 순서 받아줌
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(buff, false);

        int head = 0;
        int useTemp = 0;


        while (useTemp < N) {//N개는 바로 콘센트에 꽂아줌

            if (!buff[arr[head]]) { //이미 꽂아져있는건지 아닌지 판단, 꽂혀져있지 않다면
                use[useTemp]=arr[head]; //꽂기
                buff[arr[head]] = true;
                useTemp++;
            }
            head++;

        }

        int afterUse[] = new int[K+1]; ////우선순위를 담음 마찬가지로 1~K

        while (head < K) {

            Arrays.fill(afterUse, K);


            if (!buff[arr[head]]) { //이미 꽂아져있는건지 아닌지 판단
                //꽂혀져있지 않다면 뽑아야함

                int orderNum=1; //사용순위 1순위부터

                //뽑기 위해 후에 써야할 전자기기 우선순위 부여
                for (int i = head + 1; i < K; i++) {
                    if (afterUse[arr[i]] == K) {
                        afterUse[arr[i]] = orderNum;
                        orderNum++;
                    }
                }



                int temp=K;
                boolean find = false;

                //진짜 뽑아줌
                while (!find) {

                    for (int i = 1; i < K+1; i++) { //우선순위 뒤부터 돌아줌
                        if (buff[i] == true && afterUse[i] == temp) { //뽑고 꽂기
                            buff[i] = false; //뽑기
                            buff[arr[head]] = true; //꽂기
                            head++;
                            answer++;
                            find=true;

                            break;
                        }
                    }
                    temp--;
                }

            }else{
                head++;
            }


        }

        System.out.println(answer);


    }
}