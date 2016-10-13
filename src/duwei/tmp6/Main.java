package duwei.tmp6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<Integer> perms;
	static int b;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			b = s.nextInt();
			perms = new ArrayList<>();
			int[] a = new int[b];
			for (int i = 1; i <= b; i++) {
				a[i - 1] = i;
			}
			generate(b, a);
			Collections.sort(perms);
			for (int i = perms.size() - 1; i >= 0; i--) {
				System.out.println(perms.get(i));
			}
		}
		s.close();
	}

	static void generate(int n, int[] a) {
		if (n == 1) {
			String perm = "";
			for (int i = 0; i < b; i++) {
				perm += (a[i]) + "";
			}
			perms.add(Integer.parseInt(perm));
		} else {
			for (int i = 0; i < n - 1; i++) {
				generate(n - 1, a);
				int tmp;
				if (n % 2 == 0) {
					tmp = a[i];
					a[i] = a[n - 1];
					a[n - 1] = tmp;
				} else {
					tmp = a[0];
					a[0] = a[n - 1];
					a[n - 1] = tmp;
				}
			}
			generate(n - 1, a);
		}
	}

}
