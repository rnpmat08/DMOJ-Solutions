import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static char P[][];

    static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) System.out.print(P[i][j]);
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        N = readInt(); M = readInt(); int R = readInt(), C = readInt(); P = new char[N][M];
        if ((N == R && M % 2 == 0 && C % 2 == 1) || (M == C && N % 2 == 0 && R % 2 == 1)) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) P[i][j] = 'a';
        if (N == R && M != C) {
            for (int i = 0; i < M; i++) P[0][i] = 'b';
            if (C % 2 == 1) P[0][M / 2] = 'a';
            for (int i = 0; i < C / 2; i++) {
                P[0][i] = 'a'; P[0][M - i - 1] = 'a';
            }
            print();
            return;
        }
        if (M == C && N != R) {
            for (int i = 0; i < N; i++) P[i][0] = 'b';
            if (R % 2 == 1) P[N / 2][0] = 'a';
            for (int i = 0; i < R / 2; i++) {
                P[i][0] = 'a'; P[N - i - 1][0] = 'a';
            }
            print();
            return;
        }
        if (N != R) for (int i = 0; i < N - R; i++) P[i][0] = 'b';
        if (M != C) for (int i = 0; i < M - C; i++) P[0][i] = 'b';
        if (N - R != 0 && M - C != 0) P[0][0] = 'c';
        print();
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