import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        int K = readInt(), V = 0;
        List<int[]> G = new ArrayList<>();
        for (int N = 5000; N >= 2; N--) {
            while (K >= N * (N - 1) / 2) {
                int S = V + 1, E = V + N;
                if (V > 0) G.add(new int[] { V, S });
                for (int i = S; i < E; i++) G.add(new int[] { i, i + 1 });
                G.add(new int[] { E, S });
                K -= N * (N - 1) / 2;
                V += N;
            }
        }
        System.out.println(V + " " + G.size());
        for (int[] X : G) System.out.println(X[0] + " " + X[1]);
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
