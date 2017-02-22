package ccc.s2015;

import java.util.Scanner;
import java.util.Stack;

public class ccc15s1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		Stack<Integer> numbers = new Stack<>();
		for (int i = 0; i < k; i++) {
			int n = s.nextInt();
			if (n == 0) {
				numbers.pop();
			} else {
				numbers.push(n);
			}
		}
		s.close();
		int sum = 0;
		while (!numbers.isEmpty())
			sum += numbers.pop();
		System.out.println(sum);
	}
}
