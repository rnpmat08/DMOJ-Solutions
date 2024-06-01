import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int X = readInt();
		String[] X1 = new String[X], X2 = new String[X];
		for (int i = 0; i < X; i++) {
			X1[i] = next(); X2[i] = next();
		}
		int Y = readInt();
		String[] Y1 = new String[Y], Y2 = new String[Y];
		for (int i = 0; i < Y; i++) {
			Y1[i] = next(); Y2[i] = next();
		}
		int G = readInt();
		Map<String, Integer> M = new HashMap<>();
		for (int i = 0; i < G; i++) {
			String A = next(), B = next(), C = next();
			M.put(A, i); M.put(B, i); M.put(C, i);
		}
		int V = 0;
		for (int i = 0; i < X; i++) {
		    int A = M.get(X1[i]), B = M.get(X2[i]);
		    if (A != B) V++;
		}
		for (int i = 0; i < Y; i++) {
		    int A = M.get(Y1[i]), B = M.get(Y2[i]);
		    if (A == B) V++;
		}
		System.out.println(V);
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
