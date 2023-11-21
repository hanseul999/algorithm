/*
    프로그래머스 Lv2 가장 큰 수
    주어진 정수를 이어 붙여서 만들 수 있는 가장 큰 수 알아내기
    numbers의 길이는 최대 100,000 이므로 n^2 정렬로 풀면 안됨

    compare(), compareTo() 활용

 */


import java.util.Arrays;
import java.util.Comparator;

class Main {
    public static void main(String[] args){
        //문제 입력 예제
        int[] numbers = {3, 30, 34, 5, 9};
        //

        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
            /*
                두 문자열을 순서대로 붙여서 두 값을 비교
                기준값 : (s2 + s1)
                비교값 : (s1 + s2)
                - compareTo가 기준값이 비교대상보다 크면 양수, 작으면 음수, 같으면 0 반환
                - compare은 return값에 따라 s1, s2의 위치가 변경됨
                  양수인 경우 위치가 바뀜
                     -> (s2 + s1)이 (s1 + s2)보다 크면 양수를 반환.
                        s1 위치와 s2 위치를 바꿈 << s2가 앞으로 오게됨
                     -> (s1 + s2)가 (s1 + s2)보다 크면 음수를 반환.
                        s1 위치와 s2위치를 냅둠 << s1이 앞에있는 순서 그대로
                 단순히 compare나 compareTo나 양수 반환시 순서가 바뀐다는 것을 이용한 것
             */
        });


        if (arr[0].equals("0")) {
            System.out.println("0");
            //return "0";
        }

        StringBuilder answer = new StringBuilder();
        for (String s : arr) {
            answer.append(s);
        }

        System.out.println(answer);
        //return String.valueOf(answer);

    }




}