package ccc.junior.y2014;

import java.util.Arrays;
import java.util.Scanner;

public class J5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		String[] people = new String[N];
		for (int personNum = 0; personNum < N; personNum++) {
			people[personNum] = s.next();
		}

		Arrays.sort(people);
		int[][] adjMatrix = new int[N][N];

		for (int personNum = 0; personNum < N; personNum++) {
			adjMatrix[personNum][Arrays.binarySearch(people, s.next())] = 1;
		}

		// test for self
		for (int personNum = 0; personNum < N; personNum++) {
			if (adjMatrix[personNum][personNum] == 1) {
				System.out.println("bad");
				s.close();
				return;
			}
		}

		// confirm symmetry
		for (int personNum = 0; personNum < N; personNum++) {
			for (int partnerNum = 0; partnerNum < personNum; partnerNum++) {
				if (adjMatrix[personNum][partnerNum] != adjMatrix[partnerNum][personNum]) {
					System.out.println("bad");
					s.close();
					return;
				}
			}
		}
		System.out.println("good");
		s.close();
	}

}
