/*
    프로그래머스 Lv2 주차 요금 계산
    2022 KAKAO BLIND RECRUITMENT

 */

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Main {
    public static void main(String[] args){
        //문제 입력 예제
        int[] fees = {180, 5000, 10, 600}; //주차 요금 - 길이 4 고정
                                           // 순서대로 기본 시간(분), 기본 요금(원), 단위 시간(분), 단위 요금(원)
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}; // 자동차의 입출차 내역

            //차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 return
        //

        Map<Integer, LocalTime> map = new HashMap<>(); // 차랑번호 : 입출차 시간관련
        Map<Integer, Long> result = new TreeMap<>(); // 차량번호 : 누적 주차시간

        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record);
            LocalTime time = LocalTime.parse(st.nextToken(), DateTimeFormatter.ofPattern("HH:mm"));
            int carNum = Integer.parseInt(st.nextToken());
            if (st.nextToken().equals("IN")) { //입차시
                map.put(carNum, time);
            } else { //출차시
                LocalTime inTime = map.get(carNum);
                Duration duration = Duration.between(inTime, time); //시간차이 구하기
                long minutes = duration.toMinutes();
                result.put(carNum, result.getOrDefault(carNum, 0L) + minutes); // result에 차의 누적 min 저장
                map.remove(carNum); // 출차했다면 지워주기 << 남아있는 차를 알기 위해
            }
        }

        Iterator<Map.Entry<Integer, LocalTime>> iterator = map.entrySet().iterator();
        LocalTime endTime = LocalTime.parse("23:59", DateTimeFormatter.ofPattern("HH:mm"));
        for(Map.Entry<Integer, LocalTime> entry :map.entrySet()){
            int carNum = entry.getKey();
            //System.out.println(carNum);
            LocalTime value = entry.getValue();
            Duration duration = Duration.between(value, endTime); //시간차이 구하기
            long minutes = duration.toMinutes();
            result.put(carNum, result.getOrDefault(carNum, 0L) + minutes);
        }


        // 누적 분을 통해 요금을 구하기
        int[] answer = new int[result.size()];
        int idx = 0;
        for(Map.Entry<Integer, Long> entry :result.entrySet()){
            long minutes = entry.getValue();
            int money = fees[1]; //기본요금

            if (minutes > fees[0]) { //기본시간을 넘는다면
                int min = (int) (minutes - fees[0]); // 초과시간
                if (min % fees[2] != 0) { // 초과시간이 단위시간으로 나누어 떨어지지 않는 경우
                    min += fees[2] - (min % fees[2]); //반올림 
                }
                money += (min / fees[2] * fees[3]);
            }
            answer[idx] = money;
            idx++;
        }
        
        for (int m : answer) { //결과
            System.out.println(m);
        }
        //return answer

    }



}