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

        for(int i = 1; i < N; i++) {
            arr[i] += arr[i-1];
        }

        int s = 0;
        int e = 0;
        int count = 0;
        while(e <= arr.length-1 && s <= e) {
            if(s == e) {
                if(arr[e] >= M) { count = 1; break; }
                else e++;
            } else {
                if(s == 0) {
                    if(arr[e]>= M) {
                        count = e+1;
                        s++;
                    }
                    else e++;
                }
                else {
                    if(arr[e] - arr[s] >= M) {
                        count = Math.min(count, e-s);
                        s++;
                    } else e++;
                }
            }
        }
        System.out.println(count);
    }
}