import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int n100 = M/100;
        int n10 = (M-(n100*100))/10;
        int n1 = (M-(n100 * 100) - (n10*10));
        
        System.out.println(N * n1);
        System.out.println(N * n10);
        System.out.println(N * n100);
        System.out.println((N * n100)*100 + (N * n10) * 10 + (N * n1));
    }
}
