import java.util.*;
import java.io.*;

public class Main {
    static int N, B, W;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, N);

        System.out.println(W);
        System.out.println(B);
    }

    static void dfs(int r, int c, int size) {
        // size가 1일 경우 색 확인하고 return
        if(size == 1 && map[r][c] == 1) { B++; return; }
        if(size == 1 && map[r][c] == 0) { W++; return; }
        
        // 탐색 구간의 색이 다른지 같은지 판별할 변수 선언
        boolean isDifferent = false;

        // 맨 처음의 색 저장
        int firstColor = map[r][c] == 0 ? 0 : 1;

        // 다음 사이즈 및 구간 설정
        int ns = size / 2;
        int[] dr = new int[] {0, ns, 0, ns};
        int[] dc = new int[] {0, 0, ns, ns};

        // 탐색 구간의 색 확인
        loop1 :
        for(int i = r; i < r + size; i++) {
            for(int j = c; j < c + size; j++) {
                if(map[i][j] != firstColor) { isDifferent = true; break loop1; }
            }
        }

        // 탐색 구간의 색이 다를 경우 4구간으로 쪼개어 재 탐색
        if(isDifferent) {
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                dfs(nr, nc, ns);
            }
        } else {
            // 탐색 구간의 색이 일치할 경우 return
            if(firstColor == 1) B++;
            else W++;
        }
    }
}