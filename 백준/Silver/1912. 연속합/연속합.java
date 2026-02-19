import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        int result = -1000;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i == 0) dp[i] = arr[i];
            else dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            result = Math.max(dp[i], result);
        }

        System.out.println(result);
    }
}
