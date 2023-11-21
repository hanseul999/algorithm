/*
1655 가운데를 말해요
두 개의 우선순위 큐를 만들고

두 우선순위 큐의 크기가 같다면 maxHeap에 입력값 추가
    입력값이 최소힙의 값보다 크다면 둘의 값 swap

두 우선순위 큐의 크기가 다르다면 minHeap에 입력값 추가
    입력값이 최대힙의 값보다 크다면 둘의 값 swap

하여 최대힙에 가운데 값이 오게 한다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //오름차순 - 작은값이 우선순위를 가짐
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());  //내림차순 - 큰 값이 우선순위를 가짐

        int n;
        for (int i = 0; i < N; i++) {
            n = Integer.parseInt(br.readLine());
            if (minHeap.size() == maxHeap.size()) {
                maxHeap.add(n);
                if ((!minHeap.isEmpty()) && (n > minHeap.peek())) {
                    swap(minHeap, maxHeap);
                }

            }else{
                minHeap.add(n);
                if ((!maxHeap.isEmpty()) && (n < maxHeap.peek())) {
                    swap(minHeap, maxHeap);
                }
            }
            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.println(sb);
    }

    public static void swap(PriorityQueue<Integer> a, PriorityQueue<Integer> b) {
        Integer n = a.poll();
        Integer m = b.poll();
        a.add(m);
        b.add(n);
    }
}