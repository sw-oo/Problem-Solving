import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // M : col, N : row
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        Map<Integer, int[]> map = new HashMap<>();
        int k = 0; // 시작점의 개수
        int count = 0;
        int kCount = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    map.put(k, new int[]{i, j});
                    k++;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int[] rows = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};
        int p = 0;

        for(int i = 0; i < k; i++) {
            q.add(map.get(i));
        }

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            kCount++; // 시작점 두개라고 가정하고 k = 0, p= 2, k = 1, p = 2
            // q에서 빼준 좌표로부터 상하좌우 검색 후 조건에 맞을 경우 q에 추가
            for(int i = 0; i < 4; i++) {
                int cr = temp[0] + rows[i];
                int cc = temp[1] + col[i];
                if(cr >= 0 && cc >= 0 && cr < N && cc < M && arr[cr][cc] == 0) {
                    p++;
                    arr[cr][cc] = 1;
                    q.add(new int[]{cr, cc});
                }
            }
            if(kCount == k) {
                count++;
                kCount = 0;
                k = p;
                p = 0;
            }
        }

        boolean isAllRipen = true;
        loop1 :
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    isAllRipen = false;
                    break loop1;
                }
            }
        }

        if(isAllRipen) {
            System.out.println(count-1);
        } else
            System.out.println(-1);
    }
}
