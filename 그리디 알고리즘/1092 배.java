import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *  백준 1092번 배
 *  크레인이 옮길 수 있는
 *  가장 무거운 박스를 찾아서 옮김
 *
 *  원소 접근을 많이 하므로 ArrayList 사용
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int craneCount = sc.nextInt();
        ArrayList<Integer> craneWeight = new ArrayList<>();
        for (int i = 0; i < craneCount; i++) {
            craneWeight.add(sc.nextInt());
        }
        int boxCount = sc.nextInt();
        ArrayList<Integer> boxWeight = new ArrayList<>();
        for (int i = 0; i < boxCount; i++) {
            boxWeight.add(sc.nextInt());
        }

        Collections.sort(craneWeight, Collections.reverseOrder());
        Collections.sort(boxWeight, Collections.reverseOrder());

        if(boxWeight.get(0) > craneWeight.get(0)) { //확인 안해주면 시간초과 문제 생김
            System.out.println(-1);
            return;
        }

        int time = 0;

        while (!boxWeight.isEmpty()){
            int temp = 0;
            for (int i = 0; i < craneCount;) {
                if(temp == boxWeight.size()) break;
                else if (craneWeight.get(i) >= boxWeight.get(temp)) { //박스를 들 수 있으면
                    boxWeight.remove(temp); //박스제거
                    i++;
                }else{
                    temp++; //아니면 그 다음박스 들라고 해봄
                }
            }
            time++;
        }

        System.out.println(time);
    }
}
