import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static int N, M, V;
    static boolean[][] map;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        map = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            map[s][e] = true;
            map[e][s] = true;
        }

        sb = new StringBuilder();
        System.out.println(dfs(V));

        Arrays.fill(visited, false);

        sb = new StringBuilder();
        System.out.println(bfs(V));

    }

    static StringBuilder dfs(int s) {
        visited[s] = true;
        sb.append(s).append(" ");
        for(int e = 0; e < map[0].length; e++) {
            if(map[s][e] && !visited[e]) {
                dfs(e);
            }
        }
        return sb;
    }

    static StringBuilder bfs(int s) {
        Queue<Integer> q = new LinkedList<>();

        q.add(s);
        visited[s] = true;
        sb.append(s).append(" ");
        while(!q.isEmpty()) {
            int v = q.poll();
            for(int e = 1; e < map[0].length; e++) {
                if(map[v][e] && !visited[e]){
                    q.add(e);
                    visited[e] = true;
                    sb.append(e).append(" ");
                }
            }
        }
        return sb;
    }
}
