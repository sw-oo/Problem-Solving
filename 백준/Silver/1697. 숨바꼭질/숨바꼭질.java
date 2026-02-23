import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int i;
        int c;

        public Node(int i, int c) {
            this.i = i;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if(N == M) { System.out.println(0); return; }
        
        boolean[] visited = new boolean[100001];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, 0));
        
        while (!q.isEmpty()) {
            Node cu = q.poll();
            int i = cu.i;
            int c = cu.c;
            
            int[] next = new int[]{i + 1, i - 1, i * 2};
            for (int k : next) {
                if (k < 0 || k > 100000 || visited[k]) continue;
                if (k == M) {
                    System.out.println(c + 1);
                    return;
                } else {
                    q.add(new Node(k, c + 1));
                    visited[k] = true;
                }
            }
        }
    }
}