package ccc.senior.y2011;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int K = s.nextInt();
		int baseState = 0;
		for (int digit = 0; digit < K; digit++) {
			if (s.nextInt() == 1)
				baseState |= 1 << digit;
		}
//		System.out.println(Integer.toBinaryString(baseState));
		Queue<Integer> toExpand = new LinkedList<>();
		Queue<Integer> count = new LinkedList<>();
		boolean[] visited = new boolean[1 << K];
		toExpand.add(baseState);
		count.add(0);
		while (!toExpand.isEmpty()) {
			int currentState = toExpand.remove();
			int currentCount = count.remove();

//			System.out.println(currentCount + ":" + Integer.toBinaryString(currentState));

			if (visited[currentState])
				continue;

//			System.out.println("notvisidted");

			// remove consecutive sequences:
			int consecCount = 0;
			int startIdx = -1;
			for (int digitIdx = 0; digitIdx < K; digitIdx++) {
				boolean digit = (1 & (currentState >> digitIdx)) == 1;
				if (digit) {
					consecCount++;
//					System.out.println(consecCount + " consec");
					if (startIdx == -1)
						startIdx = digitIdx;
				} else {
					if (consecCount >= 4) {
						for (int idx = startIdx; idx < digitIdx; idx++) {
							currentState ^= 1 << idx;
						}
					}
					consecCount = 0;

					startIdx = -1;
				}
			}
			if (consecCount >= 4) {
				for (int idx = startIdx; idx < K; idx++) {
					currentState ^= 1 << idx;
				}
			}

//			System.out.println(currentCount + ":" + Integer.toBinaryString(currentState));

			// test base cases:
			if (visited[currentState])
				continue;

			if (currentState == 0) {
				System.out.println(currentCount);
				break;
			}

//			System.out.println("expand");

			for (int digitIdx = 0; digitIdx < K; digitIdx++) {
				if (((currentState >> digitIdx) & 1) != 1) {
					toExpand.add(currentState | (1 << digitIdx));
					count.add(currentCount + 1);
				}
			}

			visited[currentState] = true;
		}
		s.close();
	}

}
