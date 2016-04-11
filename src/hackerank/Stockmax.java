package hackerank;

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stockmax {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int z = 0; z < T; z++) {
			int N = Integer.parseInt(in.readLine());
			String[] line = in.readLine().split(" ");
			int[] v = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				v[i] = Integer.parseInt(line[i - 1]);
			}

			int[] dp1;
			int[] dp2 = new int[1];
			for (int i = 0; i < N; i++) {
				dp1 = dp2;
				dp2 = new int[dp2.length + 1];
				for (int j = 0; j <= i; j++) {
					dp2[j] = max(dp2[j], dp1[j]);
					for (int k = 0; k < j; k++)
						dp2[k] = max(dp2[k], dp1[j] + (j * v[i + 1]));
					dp2[j + 1] = dp1[j] - v[i + 1];
				}
			}

			System.out.println(dp2[0]);
		}
	}

}
