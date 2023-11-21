import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[20][20];

        for (int i = 1; i <= 19; i++) { 
            for (int j = 1; j <= 19; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();


            for (int j = 0; j < 20 ; j++) {
                if (arr[x][j] == 1) {
                    arr[x][j] = 0;
                } else arr[x][j] = 1;
            }

            for (int j = 0; j < 20 ; j++) {
                if (arr[j][y] == 1) {
                    arr[j][y] = 0;
                } else arr[j][y] = 1;
            }
        }

        for (int i = 1; i < 20 ; i++) {
            for (int j = 1; j < 20 ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}