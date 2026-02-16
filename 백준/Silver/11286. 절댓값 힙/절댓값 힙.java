import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if(abs1 == abs2) return o1 - o2;
            return abs1 - abs2;
        });

        for(int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            if(M != 0) pq.add(M);
            else System.out.println(pq.isEmpty() ? 0 : pq.poll());
        }
    }
}
