import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        int N = readInt(), M = readInt();
        List<Integer> G[] = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) G[i] = new ArrayList();
        for (int i = 0; i < M; i++) {
            int U = readInt(), V = readInt();
            G[U].add(V);
        }
        int P = readInt(), Q = readInt();
        if (taller(P, Q, N, G)) {
            System.out.println("yes");
        } else if (taller(Q, P, N, G)) {
            System.out.println("no");
        } else {
            System.out.println("unknown");
        }
    }
    
    static boolean taller(int A, int B, int L, List<Integer> G[]) {
        Queue<Integer> Q = new LinkedList();
        boolean[] V = new boolean[L + 1];
        Q.add(A);
        V[A] = true;
        while (!Q.isEmpty()) {
            int C = Q.poll();
            for (int N : G[C]) {
                if (!V[N]) {
                    V[N] = true;
                    Q.add(N);
                }
            }
        }
        return V[B];
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