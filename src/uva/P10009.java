package uva;

import java.util.HashMap;
import java.util.Scanner;

public class P10009 {

	static final int infinity = -1;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int c = 0; c < t; c++) {
			int m = s.nextInt();
			int n = s.nextInt();
			HashMap<String, Integer> citiesTmp = new HashMap<String, Integer>();
			int[][] adjmatrix = new int[m + 1][m + 1];
			int count = 0;
			String[] cities = new String[m + 1];
			citiesTmp.put("Rome", 0);
			cities[count] = "Rome";
			count++;
			for (int i = 0; i < m + 1; i++) {
				for (int j = 0; j < m + 1; j++) {
					adjmatrix[i][j] = infinity;
				}
			}
			for (int l = 0; l < m; l++) {
				String[] link = new String[2];
				for (int i = 0; i < 2; i++) {
					String city = link[i] = s.next();
					// System.out.print(city+" ");
					if (!citiesTmp.containsKey(city)) {
						citiesTmp.put(city, count);
						cities[count] = city;
						count++;
					}
				}
				System.out.println(
						link[0] + "[" + citiesTmp.get(link[0]) + "] - " + link[1] + "[" + citiesTmp.get(link[1]) + "]");
				adjmatrix[citiesTmp.get(link[1])][citiesTmp.get(link[0])] = 1;
				adjmatrix[citiesTmp.get(link[0])][citiesTmp.get(link[1])] = 1;
			}

			System.out.println(adjmatrix.length + "," + adjmatrix[0].length);

			for (int i = 0; i < m + 1; i++) {
				adjmatrix[i][i] = 0;
			}

			for (int[] row : adjmatrix) {
				for (int num : row) {
					if (num == -1) {
						System.out.print("x ");
					} else {
						System.out.print(num + " ");
					}
				}
				System.out.println(0);
			}

			for (int q = 0; q < n; q++) {
				String[] link = new String[2];
				for (int i = 0; i < 2; i++) {
					link[i] = s.next();
				}
				System.out.println(
						link[0] + "[" + citiesTmp.get(link[0]) + "] - " + link[1] + "[" + citiesTmp.get(link[1]) + "]");

				int city1 = citiesTmp.get(link[0]);
				int city2 = citiesTmp.get(link[1]);

				boolean[] visited = new boolean[m + 1];
				int[] pointers = new int[m + 1];
				int[] du = new int[m + 1];
				for (int i = 1; i < m + 1; i++) {
					du[i] = infinity;
				}
				du[city1] = 0;

				while (true) {
					int minNode = infinity;
					int minValue = infinity;
					for (int i = 0; i < m + 1; i++) {
						if (!visited[i]) {
							if (sl(du[i], minValue)) {
								minNode = i;
								minValue = du[i];
							}
						}
					}
					if (minNode == infinity)
						break;
					if (visited[city2])
						break;
					// System.out.println("select node " + minNode + ", du=" +
					// minValue);

					visited[minNode] = true;

					for (int j = 0; j < m + 1; j++) {
						if (!visited[j] && adjmatrix[minNode][j] != infinity) {
							// System.out.print(" select subnode " + j + ", du="
							// +
							// du[j]);
							if (sl(minValue + adjmatrix[minNode][j], du[j])) {
								pointers[j] = minNode;
								du[j] = minValue + adjmatrix[minNode][j];
								// System.out.print(", update value to " +
								// du[j]);
							}
							// System.out.println();
						}
					}
				}
				int cC = city2;
				String r = "";
				while (cC != 0) {
					r = cities[cC].charAt(0) + r;
					cC = pointers[cC];
				}
				System.out.println(r);
			}
		}
		s.close();
	}

	static boolean sl(int a, int b) {
		if (a == infinity && b != infinity)
			return false;
		if (a != infinity && b == infinity)
			return true;
		if (a == infinity && b == infinity)
			return false;
		return a < b;
	}

}
