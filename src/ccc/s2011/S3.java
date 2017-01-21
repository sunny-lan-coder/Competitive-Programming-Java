package ccc.s2011;

import java.util.Scanner;

public class S3 {

	public static void main(String[] args) {
		powers = new long[14];
		powers[0] = 1;
		for (int i = 1; i <= 13; i++) {
			powers[i] = powers[i - 1] * 5;
		}
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int test = 0; test < t; test++) {
			int m=s.nextInt();
			long x=s.nextLong();
			long y=s.nextLong();
			if(y<getHeight(m,x)){
				System.out.println("crystal");
			}else{
				System.out.println("empty");
			}
		}
		s.close();
	}

	static final long[] base = { 0, 1, 2, 1, 0 };

	static long[] powers;

	 static long getHeight(int m, long x) {
		if (m == 1) {
			return base[(int) x];
		}
		
		int baseloc=(int) (x / powers[m - 1]);
		
		if(baseloc==0 || baseloc==4)
			return 0;

		return base[baseloc]*powers[m-1] + getHeight(m - 1, x % powers[m-1]);

	}

}