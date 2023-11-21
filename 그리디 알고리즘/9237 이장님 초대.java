/**
 * 백준 9237
 * 역순으로 정렬한 뒤에
 * 가장 오래걸리는 나무를 심고
 * 차례대로 나무를 심었을 때 가장 늦게 끝나는 날을 구함 
 *      ㄴ 지난 날 수 + 걸리는 시간 
 */


import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Integer tree[] = new Integer[N];
        for (int i = 0; i < N; i++) {
            tree[i] = sc.nextInt();
        }

        Arrays.sort(tree, Collections.reverseOrder());

        int time = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            max = Math.max(max, time + tree[i]);
            time++;
        }

        System.out.println(max + 2); //심는데 하루 + 그 다음날 이장님 초대 가능
    }
}
