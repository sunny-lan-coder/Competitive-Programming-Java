package wcipej.woburn;

import java.util.Scanner;

public class wc153j2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] H = new int[N];
		for (int i = 0; i < N; i++) {
			H[i] = s.nextInt();
		}
		s.close();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += H[i] + 1;
		}

		sum = sum + H[0];

		for (int i = 1; i < N; i++) {
			int hp = H[i - 1];
			int h = H[i];
			sum=sum+Math.max(hp, h);
		}
		sum=sum+H[N-1];
		System.out.println(sum);
	}

}
