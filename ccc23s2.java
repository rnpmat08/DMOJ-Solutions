import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        int N = readInt(), M[] = new int[N], A[] = new int[N + 1];
        Arrays.fill(A, 500000000);
        for (int i = 0; i < N; i++) M[i] = readInt();
        for (int i = 0; i < N; i++) {
            int S = 0;
            for (int l = i, r = i; l >= 0 && r < N; l--, r++) {
		int D = r - l + 1;
                S += Math.abs(M[l] - M[r]);
                A[D] = Math.min(A[D], S);
            }
            S = 0;
            for (int l = i, r = i + 1; l >= 0 && r < N; l--, r++) {
                int D = r - l + 1;
		S += Math.abs(M[l] - M[r]);
                A[D] = Math.min(A[D], S);
            }
        }
        for (int i = 1; i <= N; i++) System.out.print(A[i] + " ");
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