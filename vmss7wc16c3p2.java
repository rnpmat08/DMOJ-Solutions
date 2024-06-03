import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        int N = readInt(), M = readInt(), A = readInt(), B = readInt();
        List<Integer> G[] = new ArrayList[N + 1];
        boolean[] V = new boolean[N + 1];
        V[A] = true;
        for (int i = 1; i <= N; i++) G[i] = new ArrayList();
        for (int i = 0; i < M; i++) {
            int X = readInt(), Y = readInt();
            G[X].add(Y); G[Y].add(X);
        }
        Queue<Integer> Q = new LinkedList<>();
        Q.add(A);
        while (!Q.isEmpty()) {
            int C = Q.poll();
            for (int i : G[C]) {
                if (!V[i]) {
                    V[i] = true;
                    Q.add(i);
                }
            }
        }
        if (V[B]) {
            System.out.println("GO SHAHIR!");
        } else {
            System.out.println("NO SHAHIR!");
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
}