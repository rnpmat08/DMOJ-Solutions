import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        int C = readInt(), cBest = 0;
        for (int i = 0; i < C; i++) cBest = Math.max(cBest, readInt() * readInt());
        int N = readInt(), nBest = 0;
        for (int i = 0; i < N; i++) nBest = Math.max(nBest, readInt() * readInt());
        if (cBest > nBest) {
            System.out.println("Casper");
        } else if (nBest > cBest) {
            System.out.println("Natalie");
        } else {
            System.out.println("Tie");
        }
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