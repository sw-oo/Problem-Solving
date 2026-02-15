import java.util.*;
import java.io.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] result = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i <= N; i++) {
            if(i == 0) arr[i] = INF;
            else arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], i);
        }

        Stack<Integer> stk = new Stack<>();
        stk.push(arr[0]);

        for(int i = 1; i <= N; i++) {
            while(stk.peek() <= arr[i]) {
                stk.pop();
            }
            result[i] = map.get(stk.peek());
            stk.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            if(i == N) sb.append(result[i]);
            else sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}