package duwei.p1328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		String[] tmp;
		outer: for (int t = 0; t < m; t++) {
			tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int k = Integer.parseInt(tmp[1]);
			ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
			for (int i = 0; i < n; i++) {
				adj.add(new ArrayList<Integer>());
			}
			for (int i = 0; i < k; i++) {
				tmp = br.readLine().split(" ");
				int a = Integer.parseInt(tmp[0]) - 1;
				int b = Integer.parseInt(tmp[1]) - 1;
				adj.get(a).add(b);
				adj.get(b).add(a);
			}

			boolean[] visited = new boolean[n];
			boolean[] rasict = new boolean[n];
			while (true) {
				int val = -1;
				for (int i = 0; i < n; i++) {
					if (!visited[i]) {
						val = i;
						break;
					}
				}
				if (val == -1)
					break;
				Queue<Integer> q = new LinkedList<Integer>();
				q.add(val);
				while (!q.isEmpty()) {
					int curr = q.remove();

					if (visited[curr])
						continue;

					for (int a : adj.get(curr)) {
						if (!visited[a]) {

							rasict[a] = !rasict[curr];
							q.add(a);
						} else {
						}

					}

					visited[curr] = true;
				}
			}

			int a = 0;
			int b = 0;
			for (int i = 0; i < n; i++) {
				if (rasict[i])
					a++;
				else
					b++;
			}

			boolean thing;
			if (a > b) {
				thing = true;
				System.out.println(a);
			} else {
				thing = false;
				System.out.println(b);
			}

			for (int i = 0; i < n; i++) {
				if (rasict[i] == thing) {
					System.out.print(i + 1 + " ");
				}
			}
			System.out.println();
			br.readLine();
		}
		br.close();
	}

}
