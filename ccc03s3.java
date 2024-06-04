import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C;
    static char[][] G;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int BFS(int SR, int SC) {
        int S = 1;
        G[SR][SC] = 'V';
        Queue<Integer> RQ = new LinkedList<>(), CQ = new LinkedList<>();
        RQ.add(SR); CQ.add(SC);
        while (!RQ.isEmpty()) {
            int row = RQ.poll(), col = CQ.poll();
            for (int i = 0; i < 4; i++) {
                int NR = row + dir[i][0], NC = col + dir[i][1];
                if (NR >= 0 && NR < R && NC >= 0 && NC < C && G[NR][NC] == '.') {
                    G[NR][NC] = 'V';
                    RQ.add(NR);
                    CQ.add(NC);
                    S++;
                }
            }
        }
        return S;
    }

    public static void main(String[] args) throws IOException {
        int F = readInt(), A = 0; R = readInt(); C = readInt(); G = new char[R][C];
        for (int i = 0; i < R; i++) G[i] = next().toCharArray();
        ArrayList<Integer> rooms = new ArrayList<>();
        for (int i = 0; i < R; i++) for (int j = 0; j < C; j++) if (G[i][j] == '.') rooms.add(BFS(i, j));
        Collections.sort(rooms); Collections.reverse(rooms);
        for (int i : rooms) {
            if (F >= i) {
                F -= i;
                A++;
            } else {
                break;
            }
        }
        System.out.print(A + " room");
        if (A != 1) System.out.print("s");
        System.out.println(", " + F + " square metre(s) left over");
    }

    static String next () throws IOException {
        while (st == null || ! st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}