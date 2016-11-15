package duwei.p1252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			int m = Integer.parseInt(br.readLine());
			String[] tmp;
			int[] deltaD = new int[n+1];
			for (int i = 0; i < m; i++) {
				tmp = br.readLine().split(" ");
				int l = Integer.parseInt(tmp[0]) - 1;
				int r = Integer.parseInt(tmp[1]) - 1;
				int d = Integer.parseInt(tmp[2]);
				deltaD[l] += d;
				deltaD[r+1] -= d;
			}
			int currentD = 0;
			int[] valD = new int[n];
			for (int i = 0; i < n; i++) {
				currentD += deltaD[i];
				valD[i] = currentD;
			}

			int sumD = 0;
			int[] total = new int[n+1];
			for (int i = n - 1; i >= 0; i--) {
				sumD += valD[i];
				total[i] = sumD;
			}

			int k = Integer.parseInt(br.readLine());
			int count = k;
			for (int i = 0; i < k; i++) {
				tmp = br.readLine().split(" ");
				int h = Integer.parseInt(tmp[0]);
				int x = Integer.parseInt(tmp[1]) - 1;
				if (total[x] >= h) {
					count--;
				}
			}
			System.out.println(count);
		}
		br.close();
	}

}
