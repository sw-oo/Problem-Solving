import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int count = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        for(int i = 0; i < arr.length; i++) {
            int s = 0;
            int e = arr.length-1;
            while(s < e) {
                if(s == i || e == i) {
                    if(s == i) s++;
                    if(e == i) e--;
                    continue;
                }             
                if(arr[s] + arr[e] < arr[i]) {
                    s++;
                }
                else if(arr[s] + arr[e] > arr[i]) {
                    e--;
                }
                else {
                    count++;
                    s++;
                    e--;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}