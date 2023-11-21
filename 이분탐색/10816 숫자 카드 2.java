/*
    10816 숫자 카드 2
    가지고 있는 카드를 정렬한뒤 숫자가 존재하는지 이분탐색으로 알아낸다
    그냥 이분탐색 + 같은 숫자가 있는지 확인하는 경우 << 같은 원소가 많으면 최악의 경우 원소 전체를 살펴봐야함

    따라서 lower bound 와 upper bound 사용

    찾으려는 값이 N일때
    Lower Bound: N보다 크거나 같은 첫 번째 원소의 위치
    Upper Bound: N보다 큰 첫 번째 원소의 위치

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static Map<Integer, Integer> map = new HashMap<>();  //몇 번 나오는지 저장
    static int[] cards;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //가지고 있는 숫자 카드의 개수
        cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            find(num);

            Optional<Integer> n = Optional.ofNullable(map.get(num));
            if (n.isPresent()) {
                sb.append(n.get()).append(" ");
            }else{
                sb.append("0 ");
            }
        }

        System.out.println(sb);



    }

    static void find(int num) {
        int lower = lowerBound(num);
        int upper = upperBound(num);

        // 동일한 값의 개수 : upper - lower
        if (lower != N && cards[lower] == num) {
            map.put(num, upper - lower);
        }

    }


    static int lowerBound(int num) {
        int left = 0, right = N;
        while (left < right) {
            int mid = (left + right) / 2;
            if (cards[mid] >= num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static int upperBound(int num) {
        int left = 0, right = N;
        while (left < right) {
            int mid = (left + right) / 2;
            if (cards[mid] <= num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}