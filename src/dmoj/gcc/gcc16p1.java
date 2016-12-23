package dmoj.gcc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class gcc16p1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		ArrayList<Integer> stuff = new ArrayList<>();
		int N = Integer.parseInt(tmp[0]);
		stuff.add(N);
		stuff.add(N + 1);
		int A = Integer.parseInt(tmp[1]);
		int C = Integer.parseInt(tmp[2]);
		int[] a = new int[A];
		int[] b = new int[A];
		int[] c = new int[C];
		int[] d = new int[C];
		for (int i = 0; i < A; i++) {
			tmp = br.readLine().split(" ");
			a[i] = Integer.parseInt(tmp[0]);
			b[i] = Integer.parseInt(tmp[1]);
			stuff.add(a[i]);
			stuff.add(b[i]);
			stuff.add(a[i] + 1);
			stuff.add(b[i] + 1);

		}
		for (int i = 0; i < C; i++) {
			tmp = br.readLine().split(" ");
			c[i] = Integer.parseInt(tmp[0]);
			d[i] = Integer.parseInt(tmp[1]);
			stuff.add(c[i]);
			stuff.add(d[i]);
			stuff.add(c[i] + 1);
			stuff.add(d[i] + 1);
		}
		br.close();

		Collections.sort(stuff);

		HashMap<Integer, Integer> compress = new HashMap<>();
		HashMap<Integer, Integer> reverse = new HashMap<>();

		int id = 0;
		for (int val : stuff) {
			if (!compress.containsKey(val)) {
				compress.put(val, id);
				reverse.put(id, val);
				id++;
			}
		}

		int nmap = compress.get(N);
		// HashMap<Integer, Integer> avals = new HashMap<>();
		// HashMap<Integer, Integer> bvals = new HashMap<>();
		// HashMap<Integer, Integer> cvals = new HashMap<>();
		// HashMap<Integer, Integer> dvals = new HashMap<>();
		int[] avals = new int[nmap+1];
		int[] bvals = new int[nmap+1];
		int[] cvals = new int[nmap+1];
		int[] dvals = new int[nmap+1];
		for (int i = 0; i < A; i++) {
			avals[compress.get(a[i])]++;
			bvals[compress.get(b[i])]++;
		}

		for (int i = 0; i < C; i++) {
			cvals[compress.get(c[i])]++;
			dvals[compress.get(d[i])]++;
		}

		boolean[] commitment = new boolean[nmap + 1];
		boolean[] anime = new boolean[nmap + 1];

		int level = 0;
		int level2 = 0;
		for (int loc = 0; loc <= nmap; loc++) {

			level += cvals[loc];
			if (level > 0)
				commitment[loc] = true;

			level -= dvals[loc];
			level2 += avals[loc];
			if (level2 > 0)
				anime[loc] = true;
			level2 -= bvals[loc];
		}

		int count = 0;

		for (int i = 0; i <= nmap; i++) {
			if (!commitment[i] && anime[i]) {
				count += reverse.get(i + 1) - reverse.get(i);
			}
		}

		System.out.println(count);
	}

}
