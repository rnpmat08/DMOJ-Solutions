import java.io.*;
import java.util.*;

class pair {
    int R, C;
    pair (int row, int col) {
        this.R = row;
        this.C = col;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int M = readInt(), N = readInt();
        boolean V[][] = new boolean[M + 1][N + 1];
        ArrayList<pair> F[] = new ArrayList[1000001];
        for (int i = 1; i <= 1000000; i++) F[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                int X = readInt();
                pair P = new pair(i, j);
                F[X].add(P);
            }
        }
        Queue<Integer> Q = new LinkedList<>();
        Q.add(M * N);
        while (!Q.isEmpty()) {
            int val = Q.poll();
            for (pair i : F[val]) {
                if (!V[i.R][i.C]) {
                    V[i.R][i.C] = true;
                    Q.add(i.R * i.C);
                }
            }
        }
        if (V[1][1]) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
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