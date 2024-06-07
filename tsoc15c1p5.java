import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt(), X, Y, ants[] = new int[N + 1], car[] = new int[N + 1];
        List<Integer> G[] = new ArrayList[N + 1];
        boolean V[] = new boolean[N + 1];
        for (int i = 1; i <= N; i++) G[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            X = readInt(); Y = readInt();
            G[X].add(Y); G[Y].add(X);
        }
        Queue<Integer> Q = new LinkedList<>();
        for (int W = readInt(); W > 0; W--) {
            int disp = readInt();
            Q.add(disp);
            V[disp] = true;
            ants[disp] = 0;
        }
        while (!Q.isEmpty()) {
            int C = Q.poll();
            for (int i : G[C]) {
                if (!V[i]) {
                    V[i] = true;
                    ants[i] = ants[C] + 4;
                    Q.add(i);
                }
            }
        }
        for (int i = 1; i <= N; i++) V[i] = false;
        V[1] = true;
        car[1] = 0;
        Q.add(1);
        while (!Q.isEmpty()) {
            int C = Q.poll();
            for (int i : G[C]) {
                if (!V[i] && ants[i] > car[C] + 1) {
                    V[i] = true;
                    car[i] = car[C] + 1;
                    Q.add(i);
                }
            }
        }
        System.out.println(V[N] ? car[N] : "sacrifice bobhob314");
    }

    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}