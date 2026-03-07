import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = new StringBuilder(st.nextToken()).reverse().toString();
        String M = new StringBuilder(st.nextToken()).reverse().toString();

        int num01 = Integer.parseInt(N);
        int num02 = Integer.parseInt(M);

        System.out.println(Math.max(num01, num02));
    }
}