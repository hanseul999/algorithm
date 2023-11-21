/*
    프로그래머스 Lv2 순위 검색
    2021 KAKAO BLIND RECRUITMENT

    이분탐색 / 해시 / dfs

    효율성 부문을 위해 이분탐색 사용
    1. 입력받은 지원자의 정보들로 만들어 질 수 있는
       모든 경우의 수를 map에 담아 줌
       -> 각 경우의 수로 조합된 문자열이 key값 , 점수가 value가 된다
    2. 이분탐색을 위해 점수 데이터를 정렬하고
       이분탐색 진행 - Lower bound로 score보다 크거나 같은 원소의 시작 인덱스를 구하여 
       코딩 테스트 점수를 n점 이상 받은 사람을 구함 

 */


import java.util.*;

class Main {
    static Map<String, List<Integer>> map = new HashMap<>();
    public static void main(String[] args) {
        // 문제 입력 예제
            //{ "언어", "직군", "경력", "소울푸드",  "점수" }
        String[] info = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", //문의 조건
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};
            //각 문의조건에 해당하는 사람들의 숫자를 순서대로 배열에 담아 return
        //

        for (String str : info) {
            // map의 key에 info의 각 값들이 통과할 수 있는 조건을 모두 조합해 넣고,
            // value에는 코딩테스트 점수를 넣기
            String[] arr = str.split(" ");
            dfs("", 0, arr); //dfs로 조합
        }

        for (String key : map.keySet()) { // value 정렬
            Collections.sort(map.get(key));
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {

            String[] arr = query[i].split(" and ");
            int score = Integer.parseInt(arr[3].split(" ")[1]);
            query[i] = arr[0] + arr[1] + arr[2] + arr[3].split(" ")[0];

            if (map.containsKey(query[i])) {
                answer[i] = binarySearch(query[i], score);
            }

        }

        for (int n : answer) {
            System.out.println(n);
        }
        //return answer;


    }

    /**
     *
     * @param query : 해당 문자열을 키로 점수 목록을 가져옴
     * @param score : 찾고자 하는 점수
     * @return : (리스트 총 길이 - score보다 크거나 같은 원소의 시작 인덱스)
     *              ->  query 문자열에 연관된 점수 목록에서 score보다 크거나 같은 점수의 수를 반환
     */
    private static int binarySearch(String query, int score) {

        ArrayList<Integer> list = (ArrayList<Integer>) map.get(query); //점수 목록

        int start = 0;
        int end = list.size();

        // Lower Bound
        while(start < end) {
            int mid = (start + end) / 2;

            if (list.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return list.size() - start;
    }

    static void dfs(String str, int depth, String [] arr) {
        if (depth == 4) {
            int score = Integer.parseInt(arr[4]); //점수
            if (map.containsKey(str)) {
                map.get(str).add(score);
            }
            else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(score);
                map.put(str, temp);
            }
            return;
        }

        dfs(str + "-", depth + 1, arr);
        dfs(str + arr[depth], depth + 1, arr);
    }

}

