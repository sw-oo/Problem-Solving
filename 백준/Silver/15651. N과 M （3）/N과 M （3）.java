import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[K];

        bt(0);
        System.out.println(sb);
    }

    static void bt(int depth) {
        if(depth == K) {
            for(int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1 ; i <= N; i++) {
            arr[depth] = i;
            bt(depth + 1);
        }
    }
}
