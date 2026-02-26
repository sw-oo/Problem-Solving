import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int max = 0;
        for(int i = N-1; i >= 0; i--) {
            for(int j = i-1; j >= 0; j--) {
                if(M - arr[i] <= arr[j]) continue;
                for(int k = 0; k < j; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum > M) continue;
                    else if (sum == M) {
                        System.out.println(M);
                        return;
                    }
                    else max = Math.max(sum, max);
                }
            }
        }
        System.out.println(max);
    }
}