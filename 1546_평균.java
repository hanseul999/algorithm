import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        double[] score = new double[N];
        double high=0;
        double total=0;

        for(int i=0;i<N;i++){
            score[i] = sc.nextInt();
        }
        for(int i=0;i<N;i++){
            if(high<score[i])
                high = score[i];
            total += score[i];
        }
        System.out.println(total/high*100/N);

    }
}