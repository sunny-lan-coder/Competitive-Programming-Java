package dmoj.contest.y2015.c2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4 {

	public static void main(String[] args) throws IOException {
		//Read input
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(in.readLine());
		long[] R = new long[N];
		long[] L = new long[N];
		long[] H = new long[N];
		String[] tokenize;
		for (int i = 0; i < N; i++) {
			tokenize = in.readLine().split(" ");
			R[i] = Long.valueOf(tokenize[0]);
			L[i] = Long.valueOf(tokenize[1]);
			H[i] = Long.valueOf(tokenize[2]);
		}
		in.close();
		
		
	}

}
