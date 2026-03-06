import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] GPAList = new String[] {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P"};
        Map<String, Double> map = new HashMap<>();
        double j = 4.5;
        double multi = 0;
        double unitSum = 0;
        for(int i = 0; i < GPAList.length; i++) {
            if(i == GPAList.length-2 || i == GPAList.length-1) map.put(GPAList[i], 0.0);
            else map.put(GPAList[i], j);
            j = j - 0.5;
        }

        for(int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double unit = Double.parseDouble(st.nextToken());
            String GPA = st.nextToken();
            if(GPA.equals("P")) continue;
            unitSum += unit;
            multi += map.get(GPA) * unit;
        }
        System.out.println(multi / unitSum);
    }
}