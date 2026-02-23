import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int j = 0;
        for(int i = 0; i < N; i = i+j) {
            j++;
            if(N <= i * 6 + 1) {
                System.out.println(j);
                break;
            }
        }
    }
}