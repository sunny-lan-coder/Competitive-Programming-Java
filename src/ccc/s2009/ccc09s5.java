package ccc.s2009;

import java.util.Scanner;

public class ccc09s5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int k = s.nextInt();
		int[] x = new int[k];
		int[] y = new int[k];
		int[] r = new int[k];
		int[] b = new int[k];
		int[][] map=new int[n][m];
		for (int i = 0; i < k; i++) {
			x[i] = s.nextInt();
			y[i] = s.nextInt();
			r[i] = s.nextInt();
			b[i] = s.nextInt();
			
		}
		s.close();
		
		
	}

}
