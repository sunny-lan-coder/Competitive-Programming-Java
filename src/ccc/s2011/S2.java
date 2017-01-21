package ccc.s2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] ret = new String[n];
		for (int i = 0; i < n; i++) {
			ret[i] = br.readLine();
		}
		int score = 0;
		for (int i = 0; i < n; i++) {
			if (br.readLine().equals(ret[i]))
				score++;
		}
		br.close();
		System.out.println(score);
	}

}
