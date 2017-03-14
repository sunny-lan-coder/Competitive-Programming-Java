package ccc.s2017;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

//FFFFFFFF   UU     UU     CCCCCCC
//FF         UU     UU     CC
//FFFFFF     UU     UU     CC
//FF         UU     UU     CC
//FF         UU     UU     CC
//FF         UUUUUUUUU     CCCCCCC

public class ccc17s4 {
	static class T3 {
		public final int a;
		public final long b;
		public final boolean active;

		public T3(int a, long b, boolean active) {
			this.a = a;
			this.b = b;
			this.active = active;
		}
	}

	static BufferedReader br;
	static String[] tmp;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		splitRead();
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		int d = Integer.parseInt(tmp[2]);
		long oldcost = 0;
		ArrayList<ArrayList<T3>> adj = new ArrayList<>();
		ArrayList<HashSet<Integer>> inold = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
			inold.add(new HashSet<>());
		}
		for (int i = 0; i < m; i++) {
			splitRead();
			int a = Integer.parseInt(tmp[0]) - 1;
			int b = Integer.parseInt(tmp[1]) - 1;
			long c = Long.parseLong(tmp[2]);

			if (i < n - 1) {
				// active
				oldcost += c;
				adj.get(a).add(new T3(b, c, true));
				adj.get(b).add(new T3(a, c, true));
				inold.get(a).add(b);
				inold.get(b).add(a);
			} else {

				adj.get(a).add(new T3(b, c, false));
				adj.get(b).add(new T3(a, c, false));
			}
		}
		br.close();

		// find mst

		ArrayList<HashSet<Integer>> inMst = new ArrayList<>();

		long[] du = new long[n];
		ArrayList<HashSet<Integer>> v = new ArrayList<>();
		int[] from = new int[n];
		for (int i = 0; i < n; i++) {
			du[i] = -1;
			inMst.add(new HashSet<>());
			from[i] = -1;
			v.add(new HashSet<>());
		}
		du[0] = 0;
		boolean[] visited = new boolean[n];

		while (true) {
			int minidx = -1;
			for (int i = 0; i < n; i++) {
				if (!visited[i] && du[i] != -1 && (minidx == -1 || du[i] < du[minidx])) {
					minidx = i;
				}
			}
			if (minidx == -1)
				break;
			for (T3 neigh : adj.get(minidx)) {
				if (visited[neigh.a])
					continue;
				long u = neigh.b;
				if (u == du[neigh.a]) {
					int olda = from[neigh.a];
					int oldb = minidx;

					int newa = neigh.a;
					int newb = minidx;

					boolean beforebad = inold.get(olda).contains(oldb);
					boolean afterbad = inold.get(newa).contains(newb);

					boolean beforenew = false;
					boolean afternew = true;

					boolean beforeold = true;
					boolean afterold = false;

					int acnew = 0;
					int deacnew = 0;

					int acold = 0;
					int deacold = 0;

					if (!afternew && afterbad) {
						acnew++;
					}

					if (beforenew && !beforebad) {
						acnew++;
					}

					if (!afterold && afterbad) {
						acold++;
					}

					if (beforeold && !beforeold) {
						acold++;
					}

					// find the mst with the least work
					if (Math.max(acnew, deacnew) < Math.max(acold, deacold)) {
						du[neigh.a] = u;
						if (from[neigh.a] != -1) {
							inMst.get(neigh.a).remove(from[neigh.a]);
							inMst.get(from[neigh.a]).remove(neigh.a);
						}

						inMst.get(minidx).add(neigh.a);
						inMst.get(neigh.a).add(minidx); // <--duplicate?

						from[neigh.a] = minidx;
						visited[neigh.a]=true;
					}
				} else if (u < du[neigh.a] || du[neigh.a] == -1) {
					du[neigh.a] = u;
					if (from[neigh.a] != -1) {
						inMst.get(neigh.a).remove(from[neigh.a]);
						inMst.get(from[neigh.a]).remove(neigh.a);
					}

					inMst.get(minidx).add(neigh.a);
					inMst.get(neigh.a).add(minidx); // <--duplicate?

					from[neigh.a] = minidx;
					visited[neigh.a]=true;
				}
			}
			visited[minidx] = true;
		}

		int activate = 0;
		int deactivate = 0;
		long newcost = 0;
		for (int i = 0; i < n; i++) {
			for (T3 neigh : adj.get(i)) {
				if (v.get(i).contains(neigh.a) || v.get(neigh.a).contains(i))
					continue;
				boolean inmst = false;
				if (inMst.get(i).contains(neigh.a))
					inmst = true;
				if (inMst.get(neigh.a).contains(i))
					inmst = true;
				boolean old = inold.get(i).contains(neigh.a);

				if (inmst)
					newcost += neigh.a;

				// activate
				if (inmst == true && old == false) {
					activate++;
				}

				// deactivate
				if (old == true && inmst == false) {
					deactivate++;
				}
				
				v.get(i).add(neigh.a);
			}
		}
		if (newcost == oldcost)
			System.out.println(0);
		else
			System.out.println(Math.max(activate, deactivate));

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
