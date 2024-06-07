import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        for (int t = readInt(); t > 0; t--) {
            int l = readInt(), w = readInt(), SR = 0, SC = 0, ER = 0, EC = 0, D[][] = new int[w][l], dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            char H[][] = new char[w][l];
            boolean V[][] = new boolean[w][l];
            for (int i = 0; i < w; i++) {
                H[i] = next().toCharArray();
                for (int j = 0; j < l; j++) {
                    if (H[i][j] == 'C') {
                        SR = i;
                        SC = j;
                    }
                    if (H[i][j] == 'W') {
                        ER = i;
                        EC = j;
                    }
                }
            }
            Queue<Integer> RQ = new LinkedList<>(), CQ = new LinkedList<>();
            RQ.add(SR);
            CQ.add(SC);
            D[SR][SC] = 0;
            V[SR][SC] = true;
            while (!RQ.isEmpty()) {
                int R = RQ.poll(), C = CQ.poll();
                for (int k = 0; k < 4; k++) {
                    int NR = R + dir[k][0], NC = C + dir[k][1];
                    if (NR >= 0 && NR < w && NC >= 0 && NC < l && H[NR][NC] != 'X' && !V[NR][NC]) {
                        RQ.add(NR);
                        CQ.add(NC);
                        V[NR][NC] = true;
                        D[NR][NC] = D[R][C] + 1;
                    }
                }
            }
            System.out.println((V[ER][EC] && D[ER][EC] < 60) ? D[ER][EC] : "#notworth");
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}