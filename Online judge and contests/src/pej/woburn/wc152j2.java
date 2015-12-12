package pej.woburn;

import java.util.Scanner;

public class wc152j2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int count = 0;
		for (int j = 0; j < N; j++) {
			int Wj=s.nextInt();
			if (Wj <= M)
				count+=Wj;
		}
		System.out.println(count);
		s.close();
	}

}
