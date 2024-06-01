import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		for (int a = 0; a < 10; a++) {
			int N = readInt(), M = readInt(), D = readInt(), CD = 1, L = 0, TC = N, A[] = new int[D + 1];
			for (int i = 0; i < M; i++) A[readInt()]++;
			for (int i = 1; i <= D; i++) {
				if (N == 0) {
					L++; N = TC;
				}
				N--; TC += A[i]; N += A[i];
			}
			System.out.println(L);
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
