package wcipeg.woburn;

import java.util.Arrays;
import java.util.Scanner;

public class wc151j3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] T = new int[N];
		for (int songIdx = 0; songIdx < N; songIdx++) {
			T[songIdx] = s.nextInt();
		}

		Arrays.sort(T);

		int song1 = T[N - 1];
		int song2 = T[N - 2];

		int sum = song1 * 2;
		sum += song2 * 2;

		for (int songIdx = 0; songIdx < N - 2; songIdx++) {
			sum += T[songIdx];
		}

		System.out.println(sum + 10);

		s.close();
	}

}
