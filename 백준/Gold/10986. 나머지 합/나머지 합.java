import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N+1];
        long[] modArr = new long[M];
        long count = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) % M;
            arr[i] += arr[i-1];
        }

        for(int i = 1; i < N+1; i++) {
            arr[i] = arr[i] % M;
            modArr[(int) arr[i]]++;
            if(arr[i] == 0) count++;
        }

        for(long val : modArr) {
            count += val * (val - 1) / 2;
        }

        System.out.println(count);
    }
}