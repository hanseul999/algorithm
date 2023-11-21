/*
    프로그래머스 Lv3 단속카메라
    고속도로를 이동하는 차량의 경로 routes가 매개변수로 주어질 때,
    모든 차량이 한 번은 단속용 카메라를 만나도록 하려면
    최소 몇 대의 카메라를 설치해야 하는지를 return

    프로그래머스 요격 시스템과 비슷하게 두번째 요소를 기준으로 오름차순 정렬하고
    그 끝에 카메라를 세우면 됨

    정확한 비교를 위해 3만을 더해줌 
    
 */


import java.util.Arrays;
import java.util.Comparator;

class Main {
    public static void main(String[] args){
        // 입력 예제
        int[][] routes = {{-20, -15}, {-14, -5},  //고속도로를 이동하는 차량의 경로
                       {-18, -13}, {-5, -3}};
        //


        for (int[] route : routes) {
            route[0] += 30;
            route[1] += 30;
        }

        Arrays.sort(routes, Comparator.comparingInt(o -> o[1])); // 두번째 요소를 기준으로 오름차순 정렬


        //
        int camera = routes[0][1];
        int answer = 1;
        for (int i = 1; i < routes.length; i++) {
            int s = routes[i][0];
            int e = routes[i][1];

            if (s <= camera && e >= camera) {
                continue;
            }else{
                camera = e;
                answer++;
            }
        }

        System.out.println(answer);

    }



}

