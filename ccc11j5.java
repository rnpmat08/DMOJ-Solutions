import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        int n = readInt(), w[] = new int[n + 1];
        for (int i = 1; i <= n; i++) w[i] = 1;
        for (int i = 1; i <= n - 1; i++) w[readInt()] *= w[i] + 1;
        System.out.println(w[n]);
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
