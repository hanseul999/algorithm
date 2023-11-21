/*
    프로그래머스 Lv2 다리를 지나는 트럭

 */

import java.util.*;

        /*
           bridge_length : 다리에 올라갈 수 있는 최대 트럭 수(다리 길이)
           weight : 다리가 버틸 수 있는 무게
           truck_weights : 트럭 별 무게 - 순서대로 지나가야함
           answer : 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지
        */
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {


        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            
            /*
                1. 큐가 비어있는 경우 <- 트럭을 다리에 올린다
                2. 큐가 비어있지 않은 경우
                    2-1 : 더 올릴 수 있는지 확인하고 올린다
                    2-2 : 못올린다면 지나가게 만듦 <<- 0kg 트럭을 태워서 앞으로 진행하게 만듦
                3. 큐가 꽉 찬 경우 : 트럭 통과
                트럭을 올릴때만 시간을 증가하고
                마지막 트럭이 올라가면 트럭을 통과하는것을 기다려야하니 bridge_length 만큼 + 해서 return
             */
            while (true) {

                if (queue.isEmpty()) { // 1
                    queue.add(truck_weights[i]);
                    answer++;
                    break;
                }else{
                    if (queue.size() == bridge_length) { // 3
                        queue.poll();
                    }
                    // 2
                    int sum = 0;
                    for (Integer element : queue) {
                        sum += element;
                    }
                    if ((sum + truck_weights[i]) > weight) {
                        queue.add(0); // 0kg 트럭
                        answer++;
                    }else {
                        queue.add(truck_weights[i]);
                        answer++;
                        break;
                    }
                }
            }

        }

        return answer + bridge_length;
    }
}