import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int last = 0;
        int count = 0;

        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        // 끝나는 시간으로 정렬 & 끝나는 시간이 동일할 경우 시작 시간이 짧은 순으로 정렬
        Arrays.sort(time, (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);

        for(int i = 0; i < N; i++) {
            if(last <= time[i][0]) {
                last = time[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}