import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int row;
        int column;

        public Node(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Node> q = new LinkedList<>();

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R+1][C+1];

        for(int i = 1; i <= R; i++) {
            String str = br.readLine();
            str.getChars(0, str.length(), map[i], 1);
        }

        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int er = Integer.parseInt(st.nextToken());
        int ec = Integer.parseInt(st.nextToken());

        q.add(new Node(sr, sc));

        while(!q.isEmpty()) {
            Node current = q.poll();
            int cr = current.row;
            int cc = current.column;

            // direction
            int[] dr = {1, -1, 0, 0};
            int[] dc = {0, 0, -1, 1};

            for(int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr <= 0 || nc <= 0 || nr > R || nc > C) continue;

                if(nr == er && nc == ec) {
                    if(map[nr][nc] == 'X') {
                        System.out.println("YES");
                        return;
                    } else {
                        map[nr][nc] = 'X';
                        q.add(new Node(nr, nc));
                    }
                } else if (map[nr][nc] == '.') {
                    map[nr][nc] = 'X';
                    q.add(new Node(nr, nc));
                }
            }
        }
        System.out.println("NO");
    }
}