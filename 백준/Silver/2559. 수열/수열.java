import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] result = new int[N];
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i > 0) arr[i] += arr[i-1];
        }

        for(int i = M-1; i < N; i++) {
            if(i == M-1) result[i] = arr[i];
            else result[i] = arr[i] - arr[i-M];
            max = Math.max(result[i], max);
        }

        System.out.println(max);
    }
}