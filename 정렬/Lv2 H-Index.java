/*
    프로그래머스 Lv2 H-Index
 */

class Main {

    public static void main(String[] args) {
        //문제 입력 예제
        int[] citations = {3, 0, 6, 1, 5};
        //

        for (int i = 0; i < citations.length; i++) { //선택정렬
            int minIdx = i;
            for (int j = i; j < citations.length; j++) {
                if (citations[minIdx] > citations[j]) {
                    minIdx = j;
                }
            }
            //swap
            int temp = citations[minIdx];
            citations[minIdx] = citations[i];
            citations[i] = temp;
        }

        int answer = 0;
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                answer = h; //만족하는 값이 최댓값 
                break;
            }
        }

        System.out.println(answer);

    }
}