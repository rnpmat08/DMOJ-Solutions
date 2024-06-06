import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        int N = readInt(), H = readInt(), P = readInt();
        long A[] = new long[N], S = 0;
        for (int i = 0; i < N; i++) {
            A[i] = readLong();
            S += A[i];
        }
        Arrays.sort(A);
        long T = S * P;
        for (int i = 0; i < N; i++) {
            T = Math.min(T, A[i] * H + (S - A[i] * (N - i)) * P);
            S -= A[i];
        }
        System.out.println(T);
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
}