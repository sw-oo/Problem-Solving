import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] map;
    static StringTokenizer st;
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            sb.append(findLeastLarva(M, N, K)).append("\n");
        }

        System.out.println(sb);
    }

    static int findLeastLarva(int M, int N, int K) throws IOException {
        boolean[][] map = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        int[] dr = new int[]{0, 0, -1, 1};
        int[] dc = new int[]{-1, 1, 0, 0};
        int count = 0;
        // 배추 위치 입력
        for(int i = 0; i < K; i ++) {
            st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            map[row][col] = true;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j]) {
                    count++;
                    q.add(new int[]{i, j});
                    map[i][j] = false;
                    while(!q.isEmpty()) {
                        int[] c = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nr = c[0] + dr[k];
                            int nc = c[1] + dc[k];
                            if (nr < 0 || nc < 0 || nr >= N || nc >= M || !map[nr][nc]) continue;
                            map[nr][nc] = false;
                            q.add(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
        return count;
    }
}