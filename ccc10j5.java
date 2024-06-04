import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int SR = readInt(), SC = readInt(), ER = readInt(), EC = readInt();
        Queue<Integer> RQ = new LinkedList<>(), CQ = new LinkedList<>();
        boolean V[][] = new boolean[9][9]; int B[][] = new int[9][9];
        int dir[][] = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        RQ.add(SR); CQ.add(SC); V[SR][SC] = true; B[SR][SC] = 0;
        while (!RQ.isEmpty()) {
            int R = RQ.poll(), C = CQ.poll();
            for (int i = 0; i < 8; i++) {
                int NR = R + dir[i][0], NC = C + dir[i][1];
                if (NR >= 1 && NR <= 8 && NC >= 1 && NC <= 8 && !V[NR][NC]) {
                    V[NR][NC] = true;
                    RQ.add(NR); CQ.add(NC);
                    B[NR][NC] = B[R][C] + 1;
                }
            }
        }
        System.out.println(B[ER][EC]);
    }

    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}