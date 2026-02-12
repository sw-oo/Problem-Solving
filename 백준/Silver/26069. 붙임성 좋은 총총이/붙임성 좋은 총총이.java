import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            if(str1.equals("ChongChong") || str2.equals("ChongChong")) {
                set.add(str1);
                set.add(str2);
            }

            if(set.contains(str1)) {
                set.add(str2);
            }

            if(set.contains(str2)) {
                set.add(str1);
            }
        }

        System.out.println(set.size());
    }
}