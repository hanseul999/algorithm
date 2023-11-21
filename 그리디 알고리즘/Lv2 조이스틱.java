/*
    프로그래머스 Lv2 조이스틱
    좌우 이동량 주의 
 */

class Solution {
    public int solution(String name) {
        int answer = 0;
        int idx;
        int move = name.length() - 1; //그냥 쭉 앞으로만 이동하면 움직이게 되는 값
        for (int i = 0; i < name.length(); i++) {

            //상하 이동량 확인
            answer +=  Math.min(Math.abs(name.charAt(i) - (int) 'A'),
                    Math.abs(name.charAt(i) - 91)); // 91 -> 뒤로가는 A

            //연속되는 A수 확인
            idx = i + 1;
            while(idx < name.length() && name.charAt(idx) == 'A'){
                idx++;
            }


            //그냥 직진하는것과 뒤로가는것중 최솟값 구하기
            move = Math.min(move, i * 2 + name.length() - idx);


            //뒤로 갔다가 앞으로 다시 오는것도 확인 ex)BBBBAAB
            move = Math.min(move, (name.length() - idx) * 2 + i);

        }


        return answer + move;
    }
}