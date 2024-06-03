import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), M, ans = 10000, D[] = new int[N + 1]; boolean V[] = new boolean[N + 1];
        List<Integer> E = new ArrayList<>(), B[] = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            B[i] = new ArrayList<>();
            M = readInt();
            for (int j = 0; j < M; j++) B[i].add(readInt());
            if (M == 0) E.add(i);
        }
        Queue<Integer> Q = new LinkedList<>(); Q.add(1); D[1] = 1; V[1] = true;
        while (!Q.isEmpty()) {
            int C = Q.poll();
            for (int i : B[C]) {
                if (!V[i]) {
                    V[i] = true;
                    D[i] = D[C] + 1;
                    Q.add(i);
                }
            }
        }
        boolean R = true;
        for (int i = 1; i <= N; i++) {
            if (!V[i]) {
                R = false;
                break;
            }
        }
        if (R) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }
        for (int i : E) if (D[i] > 1 && D[i] < ans) ans = D[i];
        System.out.println(ans);
    }

    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}