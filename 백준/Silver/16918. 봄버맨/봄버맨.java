import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        char[][] initMap = new char[N][M];
        char[][] fullBomb = new char[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < M; j++) {
                fullBomb[i][j] = 'O';
                initMap[i][j] = str.charAt(j);
            }
        }
        if (R == 1) {
            System.out.println(print(initMap));
            return;
        }
        if (R % 2 == 0) {
            System.out.println(print(fullBomb));
            return;
        }
        if(R % 4 == 3) System.out.println(print(changeMap(initMap)));
        else System.out.println(print(changeMap(changeMap(initMap))));
    }

    static StringBuilder print(char[][] map) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        return sb;
    }

    static char[][] changeMap(char[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'O') {
                    int[] di = {-1, 1, 0, 0};
                    int[] dj = {0, 0, -1, 1};

                    for (int k = 0; k < 4; k++) {
                        int ni = i + di[k];
                        int nj = j + dj[k];

                        if (ni < 0 || nj < 0 || ni >= N || nj >= M || map[ni][nj] == 'O') continue;
                        map[ni][nj] = '?';
                    }
                }
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == '?' || map[i][j] == 'O') map[i][j] = '.';
                else map[i][j] = 'O';
            }
        }
        return map;
    }
}