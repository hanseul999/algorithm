/*
    프로그래머스 LV2 더 맵게

    우선순위 큐 사용

    가장 맵지 않은 음식, 두번째로 맵지 않은 음식을 꺼내서 섞은 뒤
    다시 넣고 제일 안매운 음식의 스코빌 지수 확인
    음식이 하나 남았는데도 K를 넘지 못하면 -1 return

 */


import java.util.PriorityQueue;

class Main {

    public static void main(String[] args){
        //문제 입력 예제
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        //

        PriorityQueue<Integer> food = new PriorityQueue<>();
        for (int j : scoville) {
            food.add(j);
        }

        int answer = 0; //섞은 횟수
        while (food.size() >= 2) {
            if (food.peek() >= K) { 
                System.out.println(answer); //return answer;
            }

            int n = food.poll();
            int m = food.poll();

            food.add(n + (m * 2));
            answer++;
        }

        if (food.peek() >= K) { //음식이 섞이고 나서 하나만 남을때도 K를 넘을 수 있음
            System.out.println(answer); //return answer;
        }else{
            System.out.println(-1); //return -1;
        }

    }


}