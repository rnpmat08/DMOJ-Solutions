import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt(); long K = readLong();
        if ((long) M * (N - M) + (long) M * (M + 1) / 2 < K || K < N) {
            System.out.println("-1");
            return;
        }
        int inc = 1, S[] = new int[(int) N];
        Queue<Integer> Q = new LinkedList<>();
        S[0] = 1;
        K -= N;
        while (K > 0) {
            if (inc < K) {
                K -= inc;
                Q.add(inc);
            } else {
                Q.add((int) K);
                K = 0;
            }
            if (inc + 1 < M && inc + 1 <= K) inc++;
        }
        for (int i = 1; i < N; i++) {
            int C;
            if (!Q.isEmpty()) {
                C = Q.poll();
            } else {
                C = 0;
            }
            if (i - C - 1 >= 0) {
                S[i] = S[i - C - 1];
            } else {
                S[i] = S[i - 1] % M + 1;
            }
            System.out.print(S[i - 1] + " ");
        }
        System.out.println(S[N - 1]);
    }

    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}