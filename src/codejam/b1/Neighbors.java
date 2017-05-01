package codejam.b1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Neighbors {

	static int n, r, o, y, g, b, v;
	static boolean[][][][] visited;
	static int[] cl;
	static int[] ans;
	static int idx = 0;
	static int startcl;

	static void pi() {
		for (int i = 0; i < idx; i++)
			System.out.print(" ");
	}

	static void canMake(int tr, int tb, int ty, int last) {
		
		if (ans != null)
			return ;
		if(visited[tr][tb][ty][last])
			return;
		visited[tr][tb][ty][last]=true;
		if (tr > r || tb > b || ty > y) {
//			pi();
//			System.out.println("too many");
			return ;
		}
//		pi();
//		System.out.println("r=" + tr + ", b=" + tb + ", y=" + ty + ", last=" + last+", arr="+Arrays.toString(cl));
		

		cl[tr + tb + ty ] = last;
		
		if ((idx==n-1||tr == r && tb == b && ty == y )&& last != startcl) {
//			pi();
//			System.out.println("Found ans");
			ans = Arrays.copyOf(cl, cl.length);
			return ;
		}
		

		// red
		if (last == 0) {
			idx++;
			
			canMake(tr, tb + 1, ty, 1);
			canMake(tr, tb, ty + 1, 2);
			idx--;
			return ;
		}

		// blue
		if (last == 1) {
			idx++;
			canMake(tr + 1, tb, ty, 0);
			canMake(tr, tb, ty + 1, 2);
			idx--;
			return;
		}

		// yellow
		if (last == 2) {
			idx++;
			canMake(tr, tb + 1, ty, 1);
			canMake(tr + 1, tb, ty, 0);
			idx--;
			return;
		}

		throw new RuntimeException("err");
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s;
		 s= new Scanner(new File("B-small-attempt1.in"));
//		s = new Scanner(System.in);
		PrintStream out;
		 out = new PrintStream("B_small_output1.txt");
//		out = System.out;
		int t = s.nextInt();
		for (int test = 1; test <= t; test++) {
			n = s.nextInt();
			r = s.nextInt();
			o = s.nextInt();
			y = s.nextInt();
			g = s.nextInt();
			b = s.nextInt();
			v = s.nextInt();

			cl = new int[r + b + y + 3];
			Arrays.fill(cl, -1);
			visited = new boolean[r + 5][b + 5][y + 5][3];
			ans = null;
			startcl = 0;
//			System.out.println("sc=0");
			canMake(1, 0, 0, 0);
			startcl = 1;
//			System.out.println("sc=1");
			canMake(0, 1, 0, 1);
			startcl = 2;
//			System.out.println("sc=2");
			canMake(0, 0, 1, 2);

			if (ans != null) {
				out.print("Case #" + test + ": ");
				for (int i =1; i <= n; i++) {
					if (ans[i] == 0)
						out.print("R");
					if (ans[i] == 1)
						out.print("B");
					if (ans[i] == 2)
						out.print("Y");
				}
				out.println();
			} else {
				out.println("Case #" + test + ": IMPOSSIBLE");
			}
			System.out.println("Done case "+test);
		}
		s.close();
		out.close();
	}

}
