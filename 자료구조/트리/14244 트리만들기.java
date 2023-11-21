/**
 * 14244 트리 만들기
 * 최하단의 레벨을 제외하고 모든 노드가 일직선으로 연결되는 구조를 만들면 된다
 * 최하단 레벨의 노드는 m-1개로 -> 루트 1개 + 최하단 노드들 m-1개 = 리프가 m개
 *
 */

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n - m; i++) { //일직선 간선
            System.out.println(i + " " + (i + 1));
        }
        int k = n - m;
        for (int i = k; i < n - 1; i++) { //최하단 노드 간선
            System.out.println(k + " " + (i + 1));
        }

    }



}