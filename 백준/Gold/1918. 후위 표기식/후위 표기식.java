import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        Map<String, Integer> priority = new HashMap<>();

        priority.put("(", 3);
        priority.put("+", 1);
        priority.put("-", 1);
        priority.put("*", 2);
        priority.put("/", 2);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, "+-*/()", true);
        while (st.asIterator().hasNext()) {
            list.add(st.nextToken());
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).matches("^[A-Z]*$")) {
                sb.append(list.get(i));
            } else {
                if (list.get(i).equals(")")) {
                    while (!stack.peek().equals("(")) {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    continue;
                }

                if (stack.isEmpty() || priority.get(list.get(i)) > priority.get(stack.peek())) {
                    stack.push(list.get(i));
                } else {
                    while (!stack.isEmpty() && priority.get(list.get(i)) <= priority.get(stack.peek())) {
                        if (stack.peek().equals("(")) {
                            break;
                        }
                        sb.append(stack.pop());
                    }
                    stack.push(list.get(i));
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
