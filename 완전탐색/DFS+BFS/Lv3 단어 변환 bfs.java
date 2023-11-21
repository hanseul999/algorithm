/*
    프로그래머스 Lv3 단어 변환
    begin -> target으로 변환하는 가장 짧은 변환 과정 찾기 - 최소 몇 단계의 과정을 거치는지 return 
    1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
    2. words에 있는 단어로만 변환할 수 있습니다.
    3. 변환할 수 없는 경우에는 0를 return 합니다.

    bfs 사용
    이동할 수 있다면 이동 - 이전 이동값 + 1 을 value로 한쌍으로 저장
    target을 찾는다면 이동값 return
    queue가 비었는데도 못찾는다면 0 return 

 */


import java.util.*;

class Main {
    static boolean[] map;
    public static void main(String[] args){
        //문제 입력 예제
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};
        //
        map = new boolean[words.length];
        int answer = bfs(words, begin, target);
        System.out.println(answer);
    }

    static int bfs(String[] words, String begin, String target) {

        Queue<Map.Entry<String, Integer>> queue = new LinkedList<>();
        queue.add(new AbstractMap.SimpleEntry<>(begin, 0));


        int n = begin.length(); // 단어의 길이 - 모든 단어의 길이는 같다
        int temp = 0;

        while (!queue.isEmpty()) {

            Map.Entry<String, Integer> current = queue.poll();

            if (current.getKey().equals(target)) {
                return current.getValue();
            }

            for (int i = 0; i < words.length; i++) { // 단어 검사

                for (int j = 0; j < n; j++) { // char 단위 검사
                    if (current.getKey().charAt(j) != words[i].charAt(j)) {
                        temp++;
                    }
                }

                if (temp == 1 && !map[i]) { // 한 글자만 다른 알파벳으로 이동 가능
                    queue.add(new AbstractMap.SimpleEntry<>(words[i], current.getValue()+1));
                    map[i] = true;
                }
                temp = 0;
            }
        }

        return 0; // 변활할수 없는 경우

    }

}