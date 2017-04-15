package codejam.y2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class PancakeFlipper2 {

	static int k;
	static char[] arr;

	static void flip(int idx) {
		for (int i = idx; i < idx + k; i++) {
			if (arr[i] == '-') {
				arr[i] = '+';
			} else {
				arr[i] = '-';
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc ;
		sc= new Scanner(new File("A-large.in"));
//		sc=new Scanner(System.in);
		PrintStream out;
		out= new PrintStream("A_large_output1.txt");
//		out=System.out;
		int t = sc.nextInt();
		outer: for (int test = 1; test <= t; test++) {

			String s = sc.next();
			int n = s.length();
			arr = new char[n];
			for (int i = 0; i < n; i++) {
				arr[i] = s.charAt(i);
			}

			k = sc.nextInt();

			int flipcnt = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i] == '-') {
					if (i + k > n) {
						out.println("Case #" + test + ": IMPOSSIBLE");
						continue outer;
					}
					flipcnt++;
					flip(i);
				}
			}

			out.println("Case #" + test + ": " + flipcnt);

		}
		sc.close();
		out.close();
	}

}
