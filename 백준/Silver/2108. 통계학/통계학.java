import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int sum = 0;
        int max = 0;
        int temp1 = 4001;
        int temp2 = 4001;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            sum += arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                temp1 = entry.getKey();
                temp2 = 4001;
            } else if (entry.getValue() == max) {
                if(entry.getKey() > temp1) {
                    temp2 = entry.getKey() > temp2 ? temp2 : entry.getKey();
                } else {
                    temp2 = temp1;
                    temp1 = entry.getKey();
                }
            }
        }

        System.out.println(Math.round((double) sum / N));
        System.out.println(arr[(arr.length-1) / 2]);
        System.out.println(temp2 != 4001 ? temp2 : temp1);
        System.out.println(arr[arr.length-1] - arr[0]);
    }
}
