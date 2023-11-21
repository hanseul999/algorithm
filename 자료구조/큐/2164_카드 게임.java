import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++){
            queue.add(i);
        }
        while (queue.size() != 1) {
            queue.poll();
            int buff = queue.poll();
            queue.add(buff);
        }
        System.out.println(queue.poll());
    }
}