import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 변수 선언
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        
        // input map
        for(int i = 0 ; i < N; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        System.out.println(searchMaze(map, N, M));
    }
    
    static Integer searchMaze(int[][] map, int N, int M) {
        // 이동할 방향 배열 선언
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        // q에 값이 존재한다면 반복
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int count = curr[2];
            
            if(r == N-1 && c == M-1) return count;
            
            for(int i = 0 ; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                // 범위 밖으로 나갈경우 스킵
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                
                if(visited[nr][nc] || map[nr][nc] == 0) continue;
                
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc, count+1});
            }
        }
        
        return -1;
    }
}