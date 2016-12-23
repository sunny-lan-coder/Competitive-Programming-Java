package ccc.j2013;

import java.util.Arrays;
import java.util.Scanner;

public class J4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int C = s.nextInt();
		int[] time = new int[C];
		for (int i = 0; i < C; i++) {
			time[i] = s.nextInt();
		}
		s.close();
		Arrays.sort(time);
		int tot = 0;
		int count = 0;
		for (int i = 0; i < C; i++) {
			tot += time[i];
			if (tot > T)
				break;
			count++;
		}
		System.out.println(count);
	}

}
