/*
      백준 골드5 1717 집합의 표현
      유니온 파인드
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =  new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 0~n 의 집합
        int m = Integer.parseInt(st.nextToken()); // m개의 연산

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }


        StringBuilder sb = new StringBuilder();
        /*
            0 a b -> 합집합
            1 a b -> 둘이 같은 집합인지 판단
         */
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("0")) { //
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            else{
                boolean b = isSameParent(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                if (b) {
                    sb.append("YES").append("\n");
                }else{
                    sb.append("NO").append("\n");
                }
            }
        }

        System.out.println(sb);

    }

    static int find(int x) {
        if(x == parent[x]){
            return x;
        }
        else{
            return parent[x] = find(parent[x]);
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x!=y) { 
            if(x < y) {
                parent[y] = x;
            }
            else {
                parent[x] = y;
            }
        }
    }

    static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }


}

