/*
    프로그래머스 Lv2 k진수에서 소수 개수 구하기
    2022 KAKAO BLIND RECRUITMENT

    정수 n을 k진수로 바꿨을 때 변환된 수 안에
    - P0처럼 소수 양쪽에 0이 있는 경우
    - P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
    - 0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
    - P처럼 소수 양쪽에 아무것도 없는 경우
    - 단, P는 각 자릿수에 0을 포함하지 않는 소수입니다
    - P를 10진법으로 보았을 때 소수여야함
    - 중복 포함
    해당 조건에 맞는 소수가 몇 개인지 알아보기

    수를 k진법으로 전환한뒤 조건에 맞춰 숫자를 list에 저장
        - n이 최대 백만자리이므로 해당 StringBuilder를 정수형으로 변환시 long 타입으로 해야함
          또한 아리스토테네스의 체를 사용하기엔 메모리 소비가 큼(배열 사용시 범위가 되지도 않음)
    그리고 소수인지 아닌지 검사


 */


import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args){
        // 문제 입력 예제
        int n = 437674;
        int k = 3;
        //

        StringBuilder sb = new StringBuilder(Integer.toString(n, k));
        sb.insert(0, 0);
        sb.insert(sb.length(), 0);

        List<StringBuilder> list = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                if (temp.length() >= 1) {
                    list.add(temp);
                    temp = new StringBuilder();
                }
            }else{
                temp.append(sb.charAt(i));
            }
        } // 조건에 맞는 수 리스트에 넣기

        int answer = 0;
        for (StringBuilder s : list) {
            long num = Long.parseLong(s.toString());
            boolean b = isPrime(num);
            if (b) {
                answer++;
            }
        }
        System.out.println(answer);
        //return answer;

    }

    private static boolean isPrime(long n) {
        if (n == 1) { // 1은 소수가 X
            return false;
        }
        long a = (long) Math.sqrt(n);
        for (int i = 2; i <= a; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}

