import java.io.*;
import java.util.*;

class pair implements Comparable<pair> {
    int first, second;

    pair(int left, int right) {
        this.first = left;
        this.second = right;
    }
    
    public int compareTo(pair other) {
        return Integer.compare(other.first, first);
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt(), DP[] = new int[N + 1];
        ArrayList<pair> G[] = new ArrayList[N + 1];
        PriorityQueue<pair> Q = new PriorityQueue<pair>();
        for (int i = 1; i <= N; i++) {
            G[i] = new ArrayList<>();
            DP[i] = readInt();
            Q.add(new pair(DP[i], i));
        }
        for (int i = 0; i < M; i++) {
            int a = readInt(), b = readInt(), c = readInt();
            G[a].add(new pair(b, c));
            G[b].add(new pair(a, c));
        }
        while (!Q.isEmpty()) {
            pair cur = Q.poll();
            if (cur.first >= DP[cur.second]) {
                for (pair U : G[cur.second]) {
                    if (cur.first - U.second > DP[U.first]) {
                        DP[U.first] = cur.first - U.second;
                        Q.add(new pair(DP[U.first], U.first));
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) System.out.println(DP[i]);
    }

    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
}