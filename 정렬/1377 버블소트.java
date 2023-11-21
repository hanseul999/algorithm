/**
 * 1377 버블소트
 *
 * 최대 500,000 개의 입력과 제한시간이 2초이기 때문에 그냥 버블정렬을 구현하면 시간초과
 *
 * 문제의 코드는 버블정렬을 사용하여 더 이상 swap이 일어나지 않는 인덱스를 출력하는 코드
 * (외부 for문이 몇 번 돌아가는지)
 *
 * -> 버블 소트를 이용하는 것이 아닌 버블 소트 과정에서 보여지는 규칙을 이용하는 문제
 *
 * 앞 쪽 칸으로 많이 이동한 숫자의 인덱스가 정답이 된다
 * 해당 인덱스의 숫자가 이동할동안 나머지 숫자의 이동은 이미 끝나있기 때문
 *
 * 따라서 Arrays.sort로 일단 정렬을 해주고
 * 정렬 전 배열과 정렬 후 배열을 비교하여 앞쪽으로 이동한 방향이 가장 큰 요소의 이동량이 정답
 * 추가적으로 문제의 C++ 코드가 for문을 한 바퀴 돈 뒤에 break 하므로 +1 하여 출력
 *
 * 입력이 크므로 배열 대신 Point 클래스 사용 + Scanner 대신 BufferedReader 사용
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static class Point implements Comparable<Point> {
        int value; // 숫자
        int index; // 인덱스

        Point(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        @Override
        public int compareTo(Point o) { // value 비교 - Arrays.sort의 정렬기준
            return Integer.compare(value, o.getValue());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Point[] arr = new Point[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new Point(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(arr);

        int max = 0;
        for(int i = 0; i < N; i++){
            //새로운 index - 기존 index 로 그 정도가 가장 큰 값 찾기
            max = Math.max(max, arr[i].index - i);
        }

        System.out.println(max + 1);
    }

}