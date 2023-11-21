/**
 * 9934 완전 이진 트리
 *
 * 중위순회로 입력이 들어온다
 * 트리의 노드를 제일 상위부터 레벨별로 왼쪽 노드부터 출력한다
 *
 * 중위순회의 특징을 이용하여 문제해결
 * 중위순회의 가운데 값은 해당 트리의 루트이므로
 * 가운데를 기준으로 재귀함수를 진행하여 서브트리를 깊이별로 순회한다
 *
 */

import java.io.IOException;
import java.util.Scanner;



public class Main {

    static int k;
    static int[] arr;
    static StringBuilder[] answer;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt(); //트리의 깊이
        int n = (int) (Math.pow(2, k) - 1);  //완전 이진트리이기 때문에 노드의 개수는 2^k -1

        arr = new int[n];
        answer = new StringBuilder[k];

        for (int i = 0; i < k; i++){
            answer[i] = new StringBuilder();
        }


        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        recursive(0, n, 0);


        for (int i = 0; i < k; i++) {
            System.out.println(answer[i]);
        }

    }




    public static void recursive(int start, int end, int depth) {

        if (depth == k) {
            return;
        }

        int mid = (start + end) / 2;
        answer[depth].append(arr[mid]).append(" ");

        recursive(start, mid - 1, depth + 1); //왼쪽 서브트리
        recursive(mid + 1, end, depth + 1); //오른쪽 서브트리
    }

}