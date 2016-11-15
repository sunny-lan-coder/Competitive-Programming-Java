package wcipeg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class wc15fs2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		int k = Integer.parseInt(tmp[2]);
		int[] c = new int[n];
		int[] t = new int[n];
		for (int i = 0; i < n; i++) {
			c[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < m; i++) {
			t[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		
	}
}
