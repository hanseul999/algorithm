/*
    프로그래머스 Lv2 구명보트

    오름차순으로 정렬 후
    제일 가벼운 사람과 제일 무거운 사람의 무게가 limit를 넘어서면
    무거운 사람은 다른 사람과 탈 수 없음 << 필요한 보트 수 증가 (answer++)
    아니라면 그 둘을 보트에 세우고 다음 가벼운 사람부터 검사

 */

import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        // 문제 입력 예제
        int[] people = {70, 50, 80, 50}; // 갇힌 사람
        int limit = 100; // 구명보트 무게제한

            /*
                모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return
             */

        //
        Arrays.sort(people);
        int answer = 0;
        int idx = 0;
        for (int i = people.length - 1; i >= idx; i--) {
            if (people[i] + people[idx] <= limit) {
                idx++;
                answer++;
            }else{
                answer++;
            }
        }

        System.out.println(answer);
        //return answer;

    }

}

