import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N = readInt(), ans = 0, D[] = new int[N];
		for (int i = 0; i < N; i++) {
			D[i] = readInt();
		}
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				int[] P = Arrays.copyOfRange(D, i, j);
				double A = 0; int avg = 0;
				for (int k : P) A += k;
				A /= P.length; avg = (int) A;
				if (avg == A) {
				    for (int k : P) {
						if (k == avg) {
							ans++;
							break;
						}
					}
				}
			}
		}
		System.out.println(ans);
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
