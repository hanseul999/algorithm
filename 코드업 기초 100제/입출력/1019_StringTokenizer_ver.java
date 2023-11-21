import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.next(), ".");
        String year = st.nextToken() + ".";
        String month = st.nextToken() + ".";
        String day = st.nextToken();
        if (month.length() == 2) {
            month = "0" + month;
        }
        if (day.length() == 1) {
            day = "0" + day;
        }
        System.out.println(year + month + day);
    }
}