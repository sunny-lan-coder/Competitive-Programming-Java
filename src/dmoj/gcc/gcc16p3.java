package dmoj.gcc;

import java.util.Scanner;

public class gcc16p3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int q = s.nextInt();
		int[] h = new int[n];
		int[] v = new int[n];
		int[] d = new int[n];
		for (int i = 0; i < n; i++) {
			h[i] = s.nextInt();
			v[i] = s.nextInt();
			d[i] = s.nextInt();
		}
		for (int i = 0; i < q; i++) {
			int b = s.nextInt()-1;
			int m = s.nextInt();
			int currh = h[b];
			int sum = 0;
			for (int j = b; j < n; j++) {
				if (h[j] >= currh) {
					break;
				}
				sum += v[j];
			}
			System.out.println(sum);
		}
		s.close();
	}

}
