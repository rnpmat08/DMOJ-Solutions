import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        int N = readInt(), M = readInt();
        List<Integer> G[] = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            G[i] = new ArrayList();
        }
        for (int i = 1; i <= M; i++) {
            int U = readInt(), V = readInt();
            G[U].add(V);
            G[V].add(U);
        }
        Queue<Integer> Q = new LinkedList();
        int[] D = new int[N + 1];
        boolean[] V = new boolean[N + 1];
        for (int K = readInt(); K > 0; K--) {
            int X = readInt();
            Q.add(X);
            V[X] = true;
            D[X] = 0;
        }
        int dist = 0;
        while (!Q.isEmpty()) {
            int C = Q.poll();
            dist = D[C];
            for (int next : G[C]) {
                if (!V[next]) {
                    Q.add(next);
                    V[next] = true;
                    D[next] = D[C] + 1;
                }
            }
        }
        System.out.println(dist);
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