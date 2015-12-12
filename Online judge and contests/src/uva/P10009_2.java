package uva;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class P10009_2 {
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
				// System.out.println(
				// link[0] + "[" + citiesTmp.get(link[0]) + "] - " + link[1] +
				// "[" + citiesTmp.get(link[1]) + "]");
				adjmatrix[citiesTmp.get(link[1])][citiesTmp.get(link[0])] = 1;
			}

			for (int[] row : adjmatrix) {
				for (int num : row) {
					if (num == -1) {
						// System.out.print("x ");
					} else {
						// System.out.print(num + " ");
					}
				}
				// System.out.println(0);
			}

			for (int q = 0; q < n; q++) {
				String[] link = new String[2];
				for (int i = 0; i < 2; i++) {
					link[i] = s.next();
				}
				// System.out.println(
				// link[0] + "[" + citiesTmp.get(link[0]) + "] - " + link[1] +
				// "[" + citiesTmp.get(link[1]) + "]");

				int city1 = citiesTmp.get(link[0]);
				int city2 = citiesTmp.get(link[1]);

				ArrayList<Integer> tmp;

				int[] citylist1;
				int[] citylist2;

				int cC = city1;
				// System.out.println("path to " + cities[cC]);
				tmp = new ArrayList<Integer>();
				tmp.add(cC);
				// System.out.print(cities[cC] + " ");
				while (cC != 0) {
					for (int i = 0; i < m + 1; i++) {
						if (adjmatrix[cC][i] != infinity) {
							cC = i;
							tmp.add(i);

							// System.out.print(cities[i]);
							break;
						}
					}
				}
				Collections.reverse(tmp);
				// System.out.println();
				citylist1 = new int[tmp.size()];
				for (int i = 0; i < citylist1.length; i++) {
					citylist1[i] = tmp.get(i);
				}

				cC = city2;
				// System.out.println("path to " + cities[cC]);
				tmp = new ArrayList<Integer>();
				tmp.add(cC);
				// System.out.print(cities[cC] + " ");
				while (cC != 0) {
					for (int i = 0; i < m + 1; i++) {
						if (adjmatrix[cC][i] != infinity) {
							cC = i;
							tmp.add(i);
							// System.out.print(cities[i]);
							break;
						}
					}
				}
				Collections.reverse(tmp);
				citylist2 = new int[tmp.size()];
				for (int i = 0; i < citylist2.length; i++) {
					citylist2[i] = tmp.get(i);
				}
				// System.out.println();

				int intersection = 0;
				for (int i = 0; i < Math.min(citylist1.length, citylist2.length); i++) {
					// System.out.println(cities[citylist1[i]] + " - " +
					// cities[citylist2[j]]);
					if (citylist1[i] == citylist2[i]) {
						// System.out.println("eq");
						intersection = i;
					} else {
						break;
					}
				}

				// System.out.println(intersection1);

				String result = "";
				for (int i = citylist1.length - 1; i > intersection; i--) {
					// System.out.println(cities[citylist1[i]]);
					result = result + cities[citylist1[i]].charAt(0);
				}

				// result += cities[citylist2[intersection2]].charAt(0);

				for (int i = intersection; i < citylist2.length; i++) {
					// System.out.println(cities[citylist2[i]]);
					result = result + cities[citylist2[i]].charAt(0);
				}

				System.out.println(result);
			}
		}
		s.close();
	}
}
