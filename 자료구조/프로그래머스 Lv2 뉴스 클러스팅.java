/*
    프로그래머스 Lv2 뉴스 클러스터링
    2018 KAKAO BLIND RECRUITMENT

    문제설명)
    자카드 유사도
    A 와 B 가 있을 때
    A 와 B 의 자카드 유사도 = A ∩ B / A ∪ B
    이는 원소의 중복을 허용하는 다중 집합에 대해서 확장 할 수 있다.
    예를들어 "FRANCE"와 "FRENCH"가 주어졌을 때
    이를 두 글자씩 끊어서 다중집합을 만들면
    각각 {FR, RA, AN, NC, CE}, {FR, RE, EN, NC, CH}
    이 둘에 대한 교집합은 {FR, NC}, 합집합은 {FR, RA, AN, NC, CE, RE, EN, CH}가 되므로
    두 문자열 사이의 자카드 유사도는 2 / 8 = 4 가 된다.
    - 특수문자가 들어온 경우 특수문자가 들어온 원소쌍은 버린다
    - 대소문자 차이는 무시한다. AB == ab
    ** 중복된 문자도 허용 ** 
    - 모두 공집합인경우 유사도는 1

    검사한 자카드 유사도에 대해 65536을 곱한 후 정수부만 출력


    문자열을 둘면서 특수문자, 숫자, 공백이 아닌 두글자를 리스트에 넣고
    각각의 리스트를 대문자로 통일한 뒤
    교집합과 합집합을 생성


 */


import java.util.*;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args){
        // 문제 입력 예제
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        //

        List<String> list1 = new LinkedList<>();
        List<String> list2 = new LinkedList<>();

        makeSection(list1, str1);
        makeSection(list2, str2);


        list1 = list1.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        list2 = list2.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        double inter = interSection(list1, list2);
        double sum = sumSection(list1, list2);

        if (inter == 0 && sum == 0) {
            System.out.println(65536); //return 65536
        }

        int answer = (int) ((inter / sum) * 65536);
        System.out.println(answer); //return answer;

    }
    private static double interSection(List<String> list1, List<String> list2) { //교집합
        List<String> result = new ArrayList<>();
        for (String item : list1) {
            if (list2.remove(item)) { // 해당 원소가 list2에 존재한다면 remove하고 true를 반환
                result.add(item);
            }
        }
        return result.size();
    }
    private static double sumSection(List<String> list1, List<String> list2) { //합집합
        List<String> result = new ArrayList<>(list1);
        result.addAll(list2);
        return result.size();
    }

    private static void makeSection(List<String> section, String str) {
        for (int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; (j < str.length()) && (j < i + 2); j++) {
                if (Character.isLetter(str.charAt(j))) {
                    sb.append(str.charAt(j));
                }else{
                    break;
                }
            }
            if (sb.length() == 2) {
                section.add(String.valueOf(sb));
            }

        }
    }


}

