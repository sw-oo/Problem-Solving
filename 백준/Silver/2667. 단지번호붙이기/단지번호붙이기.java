import java.util.*;
import java.io.*;

public class Main {
    
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static Map<Integer, Integer> count;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = 1;
        map = new int[N][N];
        visited = new boolean[N][N];
        count = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        // search
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] != 0 && !visited[i][j]) {
                    search(i, j);
                    M++;
                } else visited[i][j] = true;
            }
        }

        // count
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] != 0) {
                    count.put(map[i][j], count.getOrDefault(map[i][j], 0) + 1);
                }
            }
        }

        // print
        List<Integer> list = new ArrayList<>(count.values());
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(M-1).append("\n");
        for(int i = 0; i < list.size(); i++) {
            if(i != list.size()-1) sb.append(list.get(i)).append("\n");
            else sb.append(list.get(i));
        }

        System.out.println(sb);
    }

    static void search(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        int[] cur = new int[] {row, col};
        visited[row][col] = true;
        map[row][col] = M;
        int[] dr = new int[] {0, 0, -1, 1};
        int[] dc = new int[] {1, -1, 0, 0};
        q.add(cur);

        while(!q.isEmpty()) {
            cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 0 || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                map[nr][nc] = M;
                q.add(new int[] {nr, nc});
            }
        }
    }
}
