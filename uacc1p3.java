import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char B[][] = new char[8][8];
    static int ans = 0,  dir[][] = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static void DFS(int R, int C, int cap) {
        for (int i = 0; i < 4; i++) {
            int NR = R + dir[i][0], NC = C + dir[i][1], ER = NR + dir[i][0], EC = NC + dir[i][1];
            if (NR >= 0 && NR < 8 && NC >= 0 && NC < 8 && ER >= 0 && ER < 8 && EC >= 0 && EC < 8 && B[NR][NC] == 'B' && B[ER][EC] == '.') {
                B[NR][NC] = '.';
                ans = Math.max(ans, cap + 1);
                DFS(ER, EC, cap + 1);
                B[NR][NC] = 'B';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 8; i++) B[i] = next().toCharArray();
        for (int i = 0; i < 8; i++) for (int j = 0; j < 8; j++) if (B[i][j] == 'A') DFS(i, j, 0);
        System.out.println(ans);
    }

    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
}