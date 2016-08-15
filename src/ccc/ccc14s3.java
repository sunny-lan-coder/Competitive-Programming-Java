package ccc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ccc14s3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		outer: for (int i = 0; i < t; i++) {
			int n = s.nextInt();
			int curridx = 1;
			Stack<Integer> top = new Stack<>();
			Stack<Integer> branch = new Stack<>();
			for (int j = 0; j < n; j++) {
				top.push(s.nextInt());
			}
			while ((!top.isEmpty()) || (!branch.isEmpty())) {
				if (!top.isEmpty())
					if (top.peek() == curridx) {
						curridx++;
						top.pop();
						continue;
					}
				if (!branch.isEmpty())
					if (branch.peek() == curridx) {
						curridx++;
						branch.pop();
						continue;

					}

				if (top.isEmpty()) {
					System.out.println("N");
					continue outer;
				} else {
					branch.push(top.pop());
				}

			}
			System.out.println("Y");
		}
		s.close();
	}

}
