package ecoo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ecoo15r1p4 {

	static String[] stuffs = { "ook", "ookook", "oog", "ooga", "ug", "mook", "mookmook", "oogam", "oogum", "ugug" };
	static List<String> derp = Arrays.asList(stuffs);

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		for (int t = 0; t < 10; t++) {
			String v = s.nextLine();
			int N = v.length();
			int[] dp = new int[N + 1];
			dp[0] = 1;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j <= N; j++) {
					// System.out.print("test " + v.substring(i, j) + "... ");
					if (derp.contains(v.substring(i, j))) {
						// System.out.print(
						// "match: dp[" + i + "] + dp[" + j + "] = " + (dp[i] +
						// dp[j]) + " -> dp[" + j + "]");
						dp[j] = dp[i] + dp[j];
					}
					// System.out.println();
				}
			}
			System.out.println(dp[N]);
		}
		s.close();
	}

}
