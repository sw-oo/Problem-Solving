import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int count = 0;
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            if (arr[s] + arr[e] < M) {
                s++;
            } else if(arr[s] + arr[e] > M) {
                e--;
            } else {
                count++;
                s++;
                e--;
            }
        }

        System.out.println(count);
    }
}