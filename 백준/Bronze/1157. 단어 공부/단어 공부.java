import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        str = str.toUpperCase();

        int max = 0;
        char result = 'a';

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            } else if (entry.getValue() == max) {
                result = '?';
            }
        }

        System.out.println(result);
    }
}
