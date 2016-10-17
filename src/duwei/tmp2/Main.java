package duwei.tmp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[][] map;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] line = br.readLine().split(" ");
			m = Integer.parseInt(line[0]);
			n = Integer.parseInt(line[1]);
			if (m == 0)
				break;
			map = new char[m][n];
			for (int i = 0; i < m; i++) {
				String row = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = row.charAt(j);
				}
			}

			int count = 0;

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == '@') {
						count++;
						dfs(i, j);
					}
				}
			}

			System.out.println(count);
		}
		br.close();
	}

	static void dfs(int i, int j) {
		if (i < 0 || j < 0 || i >= m || j >= n)
			return;

		if (map[i][j] != '@')
			return;
		
		map[i][j]='*';

		dfs(i + 1, j);
		dfs(i - 1, j);
		dfs(i, j + 1);
		dfs(i, j - 1);
		dfs(i+1,j+1);
		dfs(i-1,j+1);
		dfs(i+1,j-1);
		dfs(i-1,j-1);
	}

}
