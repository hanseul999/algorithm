/*
    프로그래머스 Lv1 실패율
    2019 KAKAO BLIND RECRUITMENT


 */


import java.util.*;
import java.util.List;

class Main {

    public static class DoublePoint {
        public int x;
        public double y;

        public DoublePoint(int x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        // 문제 입력 예제
        int N = 5; // 전체 스테이지의 개수

        //게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
            /*
                실패율이 높은 스테이지부터 내림차순으로
                스테이지의 번호가 담겨있는 배열을 return
                - 단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
                - 실패율이 같다면 작은 번호의 스테이지를 먼저
             */
        //

        //double[] pers = new double[N + 1]; // 1~N 사용
        List<DoublePoint> pers = new ArrayList<>();
        Arrays.sort(stages);
        boolean[] check = new boolean[N + 1];
        double challenger = stages.length; //도전자 수
        double cnt = 1; // 해당 스테이지에서 멈춰있는 사람의 수
        for (int i = 0; i < stages.length; i++) {
            if (((i + 1 < stages.length) && stages[i] != stages[i + 1])
                    || (i + 1 == stages.length)) { // 끝이거나 다음에 다른 스테이지가 오는 경우
                if (stages[i] != N + 1) { //마지막 스테이지는 무시
                    pers.add(new DoublePoint(stages[i], cnt / challenger));
                    check[stages[i]] = true;
                    challenger -= cnt; // 해당 스테이지의 도전자수만큼 줄임
                    cnt = 1;
                }
            } else {
                cnt++;
            }
        }

        for (int i = 1; i <= N; i++) { // 위의 예시에서의 스테이지 5같이 빠진 부분 보완
            if (!check[i]) {
                pers.add(new DoublePoint(i, 0));
            }
        }

        Collections.sort(pers, new Comparator<DoublePoint>() {
            @Override
            public int compare(DoublePoint o1, DoublePoint o2) {
                // y 값을 기준으로 내림차순 정렬
                int yComparison = Double.compare(o2.y, o1.y);
                if (yComparison != 0) {
                    return yComparison;
                }
                // y 값이 같으면 x 값을 기준으로 오름차순 정렬
                return Integer.compare(o1.x, o2.x);
            }
        });

        //정답 배열에 옮겨주기
        int[] answer = pers.stream().mapToInt(p -> p.x).toArray();


        for (int num : answer) {
            System.out.println(num);
        }//return answer;

    }

}

