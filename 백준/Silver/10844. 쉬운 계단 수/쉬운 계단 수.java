import java.io.*;

public class Main {
    static final int M = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[N][10];

        for(int i = 0; i < N ; i++) {
            for(int j = 0; j < 10; j++) {
                if(i == 0 & j== 0) arr[i][j] = 0;
                else if (i == 0) arr[i][j] = 1;
                else {
                    if(j == 0) arr[i][j] = arr[i-1][j+1] % M;
                    else if(j == 9) arr[i][j] = arr[i-1][j-1] % M;
                    else {
                        arr[i][j] = arr[i-1][j-1] + arr[i-1][j+1] % M;
                    }
                }
            }
        }

        long sum = 0;
        for(int i = 0; i < 10; i++) {
            sum += arr[N-1][i];
        }

        System.out.println(sum % 1000000000);
    }
}
