import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char a = sc.next().charAt(0);

        for (int i = 97; i <= a; i++) {
            System.out.print((char)i+" ");
        }
    }
}