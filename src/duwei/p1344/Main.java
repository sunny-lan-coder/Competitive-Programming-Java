package duwei.p1344;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static ArrayList<String> res;

	static void f(int n, int l, String s) {

		if (l < 0)
			return;
		
		if (n == 0) {
			if (l == 0) {
				res.add(s);
			}
			return;
		}
		
		f(n - 1, l - 1, s + ")");
		f(n - 1, l + 1, s + "(");
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		res = new ArrayList<>();
		s.close();
		f(n*2, 0, "");
		Collections.sort(res);
		for (String t : res) {
			System.out.println(t);
		}
	}

}
