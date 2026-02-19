import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int d;
        int c;

        public Node(int d, int c) {
            this.d = d;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] visited = new int[101];
        int result = 0;

        Map<Integer, Integer> lmap = new HashMap<>();
        Map<Integer, Integer> smap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        for(int i = 0; i < l + s; i++) {
            st = new StringTokenizer(br.readLine());
            if(i < l) {
                lmap.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else
                smap.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        q.add(new Node(1, 0));
        visited[1] = 0;

        loop1 :
        while(!q.isEmpty()) {
            Node cn = q.poll(); // currentNode
            int v = cn.d; // value = currentNode.data;
            int c = cn.c; // count = currentNode.count;

            if(visited[v] != 0 && visited[v] < c) continue;
            visited[v] = c;

            for(int i = 1; i <= 6; i++) {
                int n = v + i;

                if(n > 100) continue;

                if(lmap.containsKey(n)) {
                    n = lmap.get(n);
                    q.add(new Node(n, c+1));
                }
                else if(smap.containsKey(n)) {
                    n = smap.get(n);
                    q.add(new Node(n, c+1));
                }
                else q.add(new Node(n, c+1));
                if(visited[n] > c+1) visited[n] = c+1;
            }
        }
        System.out.print(visited[100]);
    }
}