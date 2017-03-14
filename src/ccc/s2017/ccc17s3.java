package ccc.s2017;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc17s3 {

	static BufferedReader br;
	static String[] tmp;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = readInt();
		int[] l = new int[n];
		splitRead();
		int[] count = new int[2001];
		for (int i = 0; i < n; i++) {
			l[i] = Integer.parseInt(tmp[i]);
			count[l[i]]++;
		}
		br.close();

		int[] heightAchieved = new int[4002];
		for (int i = 0; i <= 2000; i++) {
			for (int j = i; j <= 2000; j++) {
				int sum = i + j;
				int num;
				if (i == j)
					num = count[i] / 2;
				else
					num = Math.min(count[i], count[j]);

				heightAchieved[sum] += num;
			}
		}

		int max = 0;
		int maxcount = 0;
		for (int i = 0; i < 4002; i++) {
			if (heightAchieved[i] == max) {
				maxcount++;
			}
			if (heightAchieved[i] > max) {
				max = heightAchieved[i];
				maxcount = 1;
			}
		}
		System.out.println(max + " " + maxcount);
	}

	static int readInt() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static long readLong() throws IOException {
		return Long.parseLong(br.readLine());
	}

	static void splitRead() throws IOException {
		tmp = br.readLine().split(" ");
	}
}
