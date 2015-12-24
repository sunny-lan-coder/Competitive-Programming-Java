package ccc.prac.y2015;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import static java.lang.Math.*;

public class J4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int M = s.nextInt();
		char[] T = new char[M];
		int[] X = new int[M];
		HashSet<Integer> friends = new HashSet<>();
		int N = 101;
		for (int i = 0; i < M; i++) {
			T[i] = s.next().charAt(0);
			X[i] = s.nextInt();
			if (T[i] == 'R' || T[i] == 'S') {
				friends.add(X[i]);
			}
		}
		s.close();

		int[] lastRecieve = new int[N];
		Arrays.fill(lastRecieve, -1);
		int[] sum = new int[N];
		int time = 0;
		for (int i = 0; i < M; i++) {

			if (T[i] == 'R') {
				lastRecieve[X[i]] = time;
			}
			if (T[i] == 'S') {
				int current = sum[X[i]];
				int wait = time - lastRecieve[X[i]];
				sum[X[i]] = current + wait;
				lastRecieve[X[i]] = -1;
			}

			if (T[i] == 'W') {
				time += X[i] - 1;
			} else {
				time++;
			}

		}

		for (int i = 0; i < N; i++) {
			if (friends.contains(i)) {
				System.out.print(i);
				System.out.print(" ");
				if (lastRecieve[i] == -1) {
					System.out.println(sum[i]);
				} else {
					System.out.println("-1");
				}
			}
		}
	}

}
