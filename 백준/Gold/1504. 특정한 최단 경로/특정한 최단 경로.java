import java.util.*;
import java.io.*;

class Node {
    int v;
    int w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> list;
    static boolean[] visited;
    static boolean isValid;
    static int[] costs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        costs = new int[V+1];
        visited = new boolean[V+1];
        isValid = false;
        list = new ArrayList<>();

        for(int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(u).add(new Node(v, w));
            list.get(v).add(new Node(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int EV1 = Integer.parseInt(st.nextToken());
        int EV2 = Integer.parseInt(st.nextToken());

        int[] path1 = new int[] {1, EV1, EV2, V, 0};
        int[] path2 = new int[] {1, EV2, EV1, V, 0};

        for(int i = 1; i < 4; i++) {
            path1[4] += search(path1[i-1], path1[i]);
            path2[4] += search(path2[i-1], path2[i]);
            if(!isValid) break;
        }

        System.out.println(!isValid ? -1 : Math.min(path1[4], path2[4]));
    }

    static int search(int start, int end) {

        if(start == end) return 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
        Arrays.fill(costs, INF);
        Arrays.fill(visited, false);
        costs[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node c = pq.poll();

            // visit
            if(visited[c.v]) continue;
            visited[c.v] = true;

            // find next
            for(int i = 0; i < list.get(c.v).size(); i++) {
                Node n = list.get(c.v).get(i);

                // update cost
                if(!visited[n.v] && costs[n.v] > costs[c.v] + n.w) {
                    costs[n.v] = costs[c.v] + n.w;
                    pq.add(new Node(n.v, costs[n.v]));
                }
            }
        }
        isValid = costs[end] != INF;
        return costs[end];
    }
}