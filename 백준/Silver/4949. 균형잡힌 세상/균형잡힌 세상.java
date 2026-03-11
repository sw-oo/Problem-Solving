import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = br.readLine();
            if(str.equals(".")) break;

            Stack<Character> st = new Stack<>();
            boolean isValid = true;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == '(' || c == '[') {
                    st.push(c);
                } else if (c == ')') {
                    if (st.isEmpty() || st.peek() != '(') {
                        isValid = false;
                        break;
                    }
                    st.pop();
                } else if (c == ']') {
                    if (st.isEmpty() || st.peek() != '[') {
                        isValid = false;
                        break;
                    }
                    st.pop();
                }
            }

            if (isValid && st.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}