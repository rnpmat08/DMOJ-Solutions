import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static ArrayList<Integer> adj[];

    public static void dos(int X, int Y) {
        boolean V[] = new boolean[50];
        int D[] = new int[50];
        Queue<Integer> Q = new LinkedList<>();
        Q.add(X);
        V[X] = true;
        D[X] = 0;
        while (!Q.isEmpty()) {
            int C = Q.poll();
            for (int i : adj[C]) {
                if (!V[i]) {
                    V[i] = true;
                    D[i] = D[C] + 1;
                    Q.add(i);
                }
            }
        }
        if (V[Y]) {
            System.out.println(D[Y]);
        } else {
            System.out.println("Not connected");
        }
    }

    public static void fof(int X) {
        boolean V[] = new boolean[50];
        int A = 0;
        Queue<Integer> Q = new LinkedList<>();
        V[X] = true;
        for (int i : adj[X]) {
            V[i] = true;
            Q.add(i);
        }
        while (!Q.isEmpty()) {
            int C = Q.poll();
            for (int i : adj[C]) {
                if (!V[i]) {
                    V[i] = true;
                    A++;
                }
            }
        }
        System.out.println(A);
    }

    public static void f(int X) {
        int A = 0;
        for (int i : adj[X]) {
            A++;
        }
        System.out.println(A);
    }

    public static void main(String[] args) throws IOException {
        adj = new ArrayList[50];
        for (int i = 1; i < 50; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[1].add(6);adj[2].add(6);adj[3].add(4);adj[3].add(5);adj[3].add(6);
        adj[3].add(15);adj[4].add(3);adj[4].add(5);adj[4].add(6);adj[5].add(3);
        adj[5].add(3);adj[5].add(4);adj[5].add(6);adj[6].add(1);adj[6].add(2);
        adj[6].add(3);adj[6].add(4);adj[6].add(5);adj[6].add(7);adj[7].add(6);
        adj[7].add(8);adj[8].add(7);adj[8].add(9);adj[9].add(8);adj[9].add(10);
        adj[9].add(12);adj[10].add(9);adj[10].add(11);adj[11].add(10);
        adj[11].add(12);adj[12].add(9);adj[12].add(11);adj[12].add(13);
        adj[13].add(12);adj[13].add(14);adj[13].add(15);adj[14].add(13);
        adj[15].add(3);adj[15].add(13);adj[16].add(17);adj[16].add(18);
        adj[17].add(16);adj[17].add(18);adj[18].add(16);adj[18].add(17);
        String S = next();
        while (!S.equals("q")) {
            int X = readInt();
            if (S.equals("i")) {
                int Y = readInt();
                adj[X].add(Y);
                adj[Y].add(X);
            } else if (S.equals("d")) {
                int Y = readInt();
                adj[X].remove(adj[X].indexOf(Y));
                adj[Y].remove(adj[Y].indexOf(X));
            } else if (S.equals("n")) {
                f(X);
            } else if (S.equals("f")) {
                fof(X);
            } else { // s == "s"
                int Y = readInt();
                dos(X, Y);
            }
            S = next();
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