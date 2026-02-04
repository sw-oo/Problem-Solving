import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        boolean flag = false; // 현재 bomb과 비교 중 인지 체크
        int bombCount = 0;

        for(int i = str.length() - 1 ; i >= 0; i--) {
            char cc = str.charAt(i); // string의 현재 문자
            char bcc = bomb.charAt(bomb.length() - 1 - bombCount);
            char bfc = bomb.charAt(0); // bomb의 첫번째 문자
            char blc = bomb.charAt(bomb.length()-1); // bomb의 마지막 문자


            if(cc == bcc && bomb.length() == 1) {
                flag = true;
                continue;
            }

            st.push(cc);

            if(cc == blc && !flag) {
                flag = true;
                sb.append(cc);
                bombCount++;
            }

            else if(flag) {
                if(cc == bcc) {
                    if(cc == bfc) {
                        sb.append(cc);
                        sb.delete(sb.length()-bomb.length(), sb.length());
                        int temp = bomb.length();
                        while(temp > 0) {
                            st.pop();
                            temp--;
                        }
                        if(!st2.isEmpty()) {
                            bombCount = st2.pop();
                        } else {
                            bombCount = 0;
                            flag = false;
                        }
                        continue;
                    }
                    sb.append(cc);
                    bombCount++;
                }
                else if(cc == blc) {
                    st2.push(bombCount);
                    bombCount = 0;
                    sb.append(cc);
                    bombCount++;
                } else {
                    while(!st2.isEmpty()) {
                        st2.pop();
                    }
                    sb.delete(0, sb.length());
                    bombCount = 0;
                    flag = false;
                }
            }
        }
        if(st.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb2 = new StringBuilder();
            while (!st.isEmpty()) {
                sb2.append(st.pop());
            }
            System.out.print(sb2);
        }
    }
}