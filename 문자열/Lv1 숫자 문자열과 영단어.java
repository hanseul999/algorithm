/*
    프로그래머스 Lv1 숫자 문자열과 영단어
    2021 카카오 채용연계형 인턴십
 */


import java.util.LinkedList;
import java.util.Queue;

class Main {

    public static void main(String[] args){
        // 문제 입력 예제
        String s = "one4seveneight";
        //
        String[] n = {"zero", "one", "two", "three", "four", "five", "six",
                    "seven", "eight", "nine"};
        Queue<Integer> queue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));

            for (int j = 0; j <= 9; j++) {
                if (sb.toString().equals(String.valueOf(j))) {
                    queue.add(j);
                    sb = new StringBuilder();
                }
            }
            if (sb.length() >= 3) {
                for (int j = 0; j < n.length; j++) {
                    if (sb.toString().equals(n[j])) {
                        queue.add(j);
                        sb = new StringBuilder();
                    }
                }
            }
        }

        int qSize = queue.size();
        int answer = 0;
        for (int i = 0; i < qSize; i++) {
            answer += (queue.poll() * Math.pow(10, queue.size()));
        }

        System.out.println(answer);
        //return answer;
    }
    
}

/*
    또는 주어진 문자열 s 자체를 바꾸는 방법
    replaceAll 사용
           // replace : 문자열에서 특정 문자나 문자열을 다른 문자나 문자열로 단순히 대체
                        문자열 내의 모든 해당하는 부분을 변경
           replaceAll : 정규 표현식을 사용하여 문자열 내에서 일치하는 패턴을 다른 문자열로 대체
 */
class Solution {
    public int solution(String s) {
        // 문제 입력 예제
        String s = "one4seveneight";
        //
        String[] strArr = {"zero", "one", "two", "three", "four",
                    "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < strArr.length; i++) {
            // strArr크기만큼 돌면서 해당 요소가 s에 있다면 replace해줌
            s = s.replaceAll(strArr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}