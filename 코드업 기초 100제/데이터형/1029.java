// 큰 범위의 실수 11자리 까지 출력하기

import java.math.BigDecimal;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("%.11f", sc.nextBigDecimal());
    }
}