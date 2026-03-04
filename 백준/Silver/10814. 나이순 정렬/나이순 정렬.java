import java.util.*;
import java.io.*;

import static java.util.Comparator.comparingInt;

public class Main {
    static class Node {
        int age;
        String name;

        public Node(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        list.sort(comparingInt(n -> n.age));

        StringBuilder sb = new StringBuilder();
        for(Node n : list) {
            sb.append(n.age).append(" ").append(n.name).append("\n");
        }
        System.out.println(sb);
    }
}