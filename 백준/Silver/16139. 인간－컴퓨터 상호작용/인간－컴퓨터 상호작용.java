import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[arr.length][26];

        for(int i = 0; i < arr.length; i++) {
            int current = arr[i] - 'a';
            if(i == 0) map[i][current] = 1;
            else {
                for(int j = 0; j < 26; j++) {
                    map[i][j] += map[i-1][j];
                    if(j == current) map[i][j]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(s == 0) sb.append(map[e][a]).append("\n");
            else sb.append(map[e][a] - map[s-1][a]).append("\n");
        }

        System.out.println(sb);
    }
}