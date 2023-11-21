import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        int N = 0;
        while(true){
            N += i;
            if (N >= n) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }
}