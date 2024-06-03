import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int X = readInt(), Y = readInt(), D[] = new int[100001]; boolean V[] = new boolean[100001];
        Queue<Integer> Q = new LinkedList<>();
        Q.add(X); D[X] = 0; V[X] = true;
        while (!V[Y]) {
            int C = Q.poll();
            if (C > 0 && !V[C - 1]) {
                Q.add(C - 1); V[C - 1] = true; D[C - 1] = D[C] + 1;
            }
            if (C < 100000 && !V[C + 1]) {
                Q.add(C + 1); V[C + 1] = true; D[C + 1] = D[C] + 1;
            }
            if (C <= 50000 && !V[2 * C]) {
                Q.add(C * 2); V[C * 2] = true; D[C * 2] = D[C] + 1;
            }
        }
        System.out.println(D[Y]);
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