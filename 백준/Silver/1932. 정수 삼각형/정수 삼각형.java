import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i+1; j++) {
                if(j==0) arr[i][j] = arr[i-1][j] + arr[i][j];
                else arr[i][j] = Math.max(arr[i-1][j-1], arr[i-1][j]) + arr[i][j];
            }
        }
        int result = 0;
        for(int i = 0; i < arr[N-1].length; i++) {
            result = Math.max(arr[N-1][i], result);
        }

        System.out.println(result);
    }
}
