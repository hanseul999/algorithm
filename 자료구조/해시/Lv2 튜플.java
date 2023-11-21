/*
    프로그래머스 Lv2 튜플
    2019 카카오 개발자 겨울 인턴십

    한 개를 담고있는 집합의 원소는 a1만을,
    두 개를 담고있는 집합의 원소는 a1, a2만을 가지고 있다
    즉 n개짜리 집합에는 최대 an 원소까지만 담고 있으므로
    집합이 순서대로 {a1}, {a1, a2}, {a1, a2, a3}, {a1, a2, a3, a4}.. 이렇게 정렬되어 있을 때
    an을 구하기 위해선 전에 나오지 않는 숫자를 알면 됨
    -> set 이용
    TreeSet으로 원소 갯수대로 {a1}, {a1, a2}, {a1, a2, a3}, {a1, a2, a3, a4}.. 를 만들고
    LinkedHashSet으로  {a1, a2, a3, a4} 을 만든다

 */


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {

    public static void main(String[] args){
        // 문제 입력 예제
        String s = 	"{{123}}"; // 중복되는 원소가 없는 튜플
        //String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        //String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

            // s가 표현하는 튜플을 배열에 담아 return
        //


        // 원소의 길이순대로( {a1}, {a1,a2} 이렇게 오게) 정렬
        Set<String> set = new TreeSet<>(Comparator.comparingInt(String::length));

        // 집합별로 TreeSet에 담기
        for (int i = 1; i < s.length()-1; i++) {
            if (s.charAt(i) == '{') {
                i++;
                StringBuilder sb = new StringBuilder();
                while (i < s.length() - 1 && s.charAt(i) != '}') {
                    sb.append(s.charAt(i));
                    i++;
                }
                set.add(String.valueOf(sb));
            }
        }


        Set<Integer> hs = set.stream()
                .flatMap(str -> Stream.of(str.split(","))) // 각 문자열을 ','를 기준으로 분할
                .map(Integer::parseInt)                // 분할된 문자열들을 숫자로 변환
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int[] answer = hs.stream().mapToInt(i -> i).toArray();

        for (int n : answer) {
            System.out.println(n);
        }
        //return answer;

    }

    
}

