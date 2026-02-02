import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        if(str.startsWith("_") || str.endsWith("_") || str.contains("__") || Character.isUpperCase(str.charAt(0)) || str.matches(".*_.*[A-Z].*|.*[A-Z].*_.*")) {
            System.out.println("Error!");
        } else if(str.matches("^[a-zA-Z]+$")) {
            System.out.println(changeToC(str));
        } else if (str.matches("^[a-z_]+$")) {
            System.out.println(changeToJava(str));
        }
    }

    static String changeToJava(String str) {

        StringBuilder sb = new StringBuilder();
        boolean check = false;

        for(int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if(currentChar == '_') {
                check = true;
                continue;
            }

            if(check) {
                sb.append(Character.toUpperCase(currentChar));
                check = false;
            }

            else sb.append(currentChar);
        }

        return sb.toString();
    }

    static String changeToC(String str) {

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < str.length(); i++) {
            if(Character.isUpperCase(str.charAt(i))) {
                char lowerChar = Character.toLowerCase(str.charAt(i));
                sb.append("_" + lowerChar);
                continue;
            }

            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

}
