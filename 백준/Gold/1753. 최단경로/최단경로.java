import java.util.*;
import java.io.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> list = new ArrayList<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int V, E, start;
    static int[] cost;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점, 간선, 시작지점 입력
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        // cost, visited 배열 초기화
        cost = new int[V+1];
        visited = new boolean[V+1];
        Arrays.fill(cost, INF);

        // 시작점 비용 처리
        cost[start] = 0;

        // 정점의 수만큼 리스트 추가
        for(int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(u).add(new Node(v, w));
        }

        search();

        // cost 배열 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < cost.length; i++) {
            if(i != cost.length-1) {
                if (cost[i] == INF) {
                    sb.append("INF").append("\n");
                    continue;
                }
                sb.append(cost[i]).append("\n");
            } else {
                if(cost[i] == INF) {
                    sb.append("INF");
                    continue;
                }
                sb.append(cost[i]);
            }
        }
        System.out.println(sb);
    }

    static void search() {
        // 시작 지점 큐에 추가
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int current = currentNode.vertex;

            // 방문처리
            if(visited[current]) continue;
            visited[current] = true;

            for(Node node : list.get(current)) {
                int next = node.vertex;
                int weight = node.weight;

                if(cost[current] + weight >= cost[next]) continue;
                else {
                    cost[next] = cost[current] + weight;
                    pq.add(new Node(next, cost[next]));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int vertex;
    int weight;

    public Node(int nextNode, int weight) {
        this.vertex = nextNode;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) { return this.weight - o.weight; }
}
