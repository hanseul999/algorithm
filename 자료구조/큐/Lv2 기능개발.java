/*
    프로그래머스 Lv2 기능개발
    앞쪽에 있는걸 먼저 끝내야 그 이후 작업이 가능하므로 큐 사용
 */


import java.util.*;

class Main {
    public static void main(String[] args){
        // 입력 예제
        int[] progresses = {95, 90, 99, 99, 80, 99}; //배포되어야하는 순서대로 적힌 작업의 진도
        int[] speeds = {1, 1, 1, 1, 1, 1}; //각 작업의 개발 속도
            //각 배포마다 몇 개의 기능이 배포되는지 return
        //

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int leftDay = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                leftDay += 1;
            }
            queue.offer(leftDay);
        }

        List<Integer> list = new ArrayList<>();
        int day = 0;
        while (!queue.isEmpty()) {
            int stackSize = queue.size();
            int temp = 0;
            for (int i = 0; i < stackSize; i++) {
                if (day >= queue.peek()) {
                    queue.poll();
                    temp++;
                }else{
                    break;
                }
            }
            if (temp != 0) {
                list.add(temp);
            }
            day++;
        }

        //정답출력
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        for (int a : answer) { //return answer;
            System.out.println(a);
        }


    }



}

