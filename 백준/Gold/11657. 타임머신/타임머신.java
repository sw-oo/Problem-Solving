import java.util.*;
import java.io.*;

public class Main {
    static final long INF = Long.MAX_VALUE;
    static int[][] edges;
    static int V, E;
    static long[] costs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        edges = new int[E][3];
        costs = new long[V+1];
        Arrays.fill(costs, INF);

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }

        long[] result = search();

        StringBuilder sb = new StringBuilder();
        if(result.length == 1) {
            sb.append(result[0]);
        } else {
            for(int i = 2; i < result.length; i++) {
                if(result[i] == INF) result[i] = -1;
                if(i == result.length-1) sb.append(result[i]);
                else sb.append(result[i]).append("\n");
            }
        }

        System.out.print(sb);
    }

    static long[] search() {
        costs[1] = 0;

        for(int i = 1; i <= V; i++) {
            for(int j = 0; j < E; j++) {
                int s = edges[j][0];
                int e = edges[j][1];
                int w = edges[j][2];
                if(costs[s] != INF && costs[e] > costs[s] + w) costs[e] = costs[s] + w;
            }
        }

        for(int i = 0; i < E; i++) {
            int s = edges[i][0];
            int e = edges[i][1];
            int w = edges[i][2];
            if(costs[s] != INF && costs[e] > costs[s] + w) {
                return new long[] {-1};
            }
        }

        return costs;
    }
}
