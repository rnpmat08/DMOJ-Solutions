import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        int H = readInt();
        for (int i = 1; i < H - 1; i += 2) {
            for (int j = 0; j < i; j++) System.out.print("*");
            for (int j = 0; j < (H - i) * 2; j++) System.out.print(" ");
            for (int j = 0; j < i; j++) System.out.print("*");
            System.out.println();
        }
        for (int i = 0; i < 2 * H; i++) System.out.print("*");
        System.out.println();
        for (int i = 1; i < H - 1; i += 2) {
            for (int j = 0; j < H - i - 1; j++) System.out.print("*");
            for (int j = 0; j < (i + 1) * 2; j++) System.out.print(" ");
            for (int j = 0; j < H - i - 1; j++) System.out.print("*");
            System.out.println();
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