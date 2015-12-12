package classproblems;

import java.util.HashSet;
import java.util.PriorityQueue;

public class UglyNumber2 {

	public static void main(String[] args) {
		int x = 2000;
		PriorityQueue<Long> queue = new PriorityQueue<>();
		queue.add(1l);

		int cnt = 0;

		HashSet<Long> visited = new HashSet<>();
		long y = 0;
		while (cnt != x) {
			y = queue.remove();
			if (!visited.contains(y)) {
				queue.add(y * 2);
				queue.add(y * 3);
				queue.add(y * 5);
				visited.add(y);
				cnt++;
			}
		}
		System.out.println(y);
	}

}