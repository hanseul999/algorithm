import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            char a = sc.next().charAt(0);
            System.out.println(a);
            if (a == 'q') {
                break;
            }
        }

    }
}