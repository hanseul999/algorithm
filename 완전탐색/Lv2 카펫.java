/*
    프로그래머스 Lv2 카펫
    부르트포스 알고리즘

    area의 약수를 구한 뒤
    제한사항과 조건에 일치하는지 검사

 */


class Main {
    public static void main(String[] args) {
        // 입력 예제
        int brown = 18;
        int yellow = 6;
            /*
                갈색이 한줄 테두리를 두르고 노란색이 그 안에 있을 때의 카펫의 가로, 세로 return
                단, 가로의 길이가 세로보다 길거나 같아야 한다
             */
        //
        int area = brown + yellow; //전체 넓이

        int[] answer = new int[2];
        int x = 0; //가로
        int y = 0; //세로
        //brown은 8 이상이므로 2x2의 카펫이 나올 수 없음 -> 3부터 검사
        for (int i = 3; i < area; i++) {
            int j = area / i;
            if ((area % i == 0) && j >= 3) {
                x = area / i;
                y = area / j;
                if (x >= y && ((x*2) + ((y-2)*2)) == brown) { // 조건
                    answer[0] = x;
                    answer[1] = y;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
        //return answer;


    }

}

