package codeforces.canadacup2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JumpingBall {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		br.close();

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '>')
				break;
			cnt++;
		}

		for (int i = n - 1; i >= 0; i--) {
			if (s.charAt(i) == '<')
				break;
			cnt++;
		}

		System.out.println(cnt);
	}

}
