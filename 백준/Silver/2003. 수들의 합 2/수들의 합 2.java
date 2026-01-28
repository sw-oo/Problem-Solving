import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫째 줄 입력 받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 둘째 줄 담을 배열 선언
        int[] arr = new int[N];

        // 둘째 줄 입력받기
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 로직 구현
        int count = 0;
        for(int i = 0; i < N; i++) {
            int prefixSum = 0;
            for(int j = i; j < N; j++) {
                if(prefixSum >= M) {
                    break;
                } else {
                    prefixSum += arr[j];
                }
            }
            if(prefixSum == M) {
                count++;
            }
        }

        System.out.println(count);
    }
}
