import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static List<Integer> result;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        result = new ArrayList<>();
        list = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            list.add(i);
        }

        int index = 0;
        while(list.size() != 0) {
            index = index + K-1;
            if(index >= list.size() - 1) {
                int temp = index / list.size();
                index = index - (list.size() * temp);
            }
            result.add(list.get(index));
            list.remove(list.get(index));
        }

        System.out.print("<");
        for (int i = 0 ; i < result.size(); i++) {
            if (i == result.size() -1) {
                System.out.print(result.get(i));
            }
            else System.out.print(result.get(i) + ", ");
        }
        System.out.println(">");

    }
}
