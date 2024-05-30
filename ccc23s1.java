import java.io.*;
import java.util.StringTokenizer;

public class Trianglane {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int C = readInt(), L[][] = new int[2][C], A = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < C; j++) {
				L[i][j] = readInt();
			}
		}
		for (int i = 0; i < C; i++) {
			if (L[0][i] == 1) {
				A += 3;
				if (i > 0 && L[0][i - 1] == 1) {
                    A -= 2;
                }
			}
			if (L[1][i] == 1) {
                A += 3;
                if (i > 0 && L[1][i - 1] == 1) {
                    A -= 2;
                }
                if (i % 2 == 0 && L[0][i] == 1) {
                    A -= 2;
                }
            }
		}
		System.out.println(A);
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