import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[][] G = new int[4][4];
		int E = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				G[i][j] = readInt();
				G[j][i] = G[i][j];
			}
		}
		for (int i = 0; i < 4; i++) {
			boolean C = false;
			for (int j = i + 1; j < 4; j++) {
				if (G[i][j] == 1) {
					C = true;
					E++;
				}
			}
			if (C == false) {
				System.out.println("No");
				return;
			}
		}
		if (E == 6) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
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
