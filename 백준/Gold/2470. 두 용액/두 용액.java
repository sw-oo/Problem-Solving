import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int s = 0;
        int e = arr.length -1;
        int rs = 0;
        int re = 0;
        int prev = Integer.MAX_VALUE;

        if(arr[s] >= 0) System.out.println(arr[0] + " " + arr[1]);
        else if (arr[e] <= 0) System.out.println(arr[e-1] + " " + arr[e]);
        else {
            while(s < e) {
                int curr = Math.abs(arr[s]+arr[e]);
                if(prev > curr) {
                    prev = curr;
                    rs = arr[s];
                    re = arr[e];
                }

                if(Math.abs(arr[s+1] + arr[e]) > Math.abs(arr[s] + arr[e-1])) {
                    e--;
                }
                else {
                    s++;
                }
            }
        }
        System.out.println(rs + " " + re);
    }

}
