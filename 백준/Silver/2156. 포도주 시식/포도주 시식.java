import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        for(int i = 0; i < N; i++) {
            if(i == 1) dp[i] = arr[i-1] + arr[i];
            if(i == 2) dp[i] = Math.max(arr[i-2], arr[i-1]) + arr[i];
            if(i == 3) dp[i] = Math.max(dp[i-3] + arr[i-1], dp[i-2]) + arr[i];
            if(i >= 4) dp[i] = Math.max(Math.max(dp[i-4], dp[i-3]) + arr[i-1], dp[i-2]) + arr[i];
        }

        if(N < 3) System.out.println(dp[N-1]);
        else System.out.println(Math.max(Math.max(dp[N-3], dp[N-2]), dp[N-1]));
    }
}