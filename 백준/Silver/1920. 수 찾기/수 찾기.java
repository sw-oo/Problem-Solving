import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            sb.append(binarySearch(Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.println(sb);
    }

    static int binarySearch(int n) {
        int low = 0;
        int high = arr.length-1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(n < arr[mid]) {
                high = mid - 1;
            } else if (n > arr[mid]) {
                low = mid + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
