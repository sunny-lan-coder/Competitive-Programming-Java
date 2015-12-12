package dmoj.contest.y2015.december;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P2 {

	static class LeastCmp implements Comparator<Long> {

		@Override
		public int compare(Long o1, Long o2) {
			// TODO Auto-generated method stub
			return (int) (o1 - o2);
		}

	}

	static class MostCmp implements Comparator<Long> {

		@Override
		public int compare(Long o1, Long o2) {
			// TODO Auto-generated method stub
			return (int) (o2 - o1);
		}

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		PriorityQueue<Long> leastQ = new PriorityQueue<>(N, new LeastCmp());
		PriorityQueue<Long> mostQ = new PriorityQueue<>(N, new MostCmp());
		for (int i = 0; i < N; i++) {
			long t = s.nextLong();
			leastQ.add(t);
			mostQ.add(t);
		}
		long time = 0;
		// Distribution loop
		while (true) {
			Long most = mostQ.remove();
			Long least = leastQ.remove();
			if (least == most) {
				System.out.println(time);
				s.close();
				break;
			}
			if(least-most==1){
				System.out.println("Impossible");
			}
			Long nextMost = mostQ.peek();

			long a;
			a = Math.min(most - least, Math.max(most - nextMost,1));
			if (a % 2 == 0) {
				a = a / 2;
			} else {
				a = (long) Math.floor(a / 2d);
			}

			most -= a;
			least += a;
			time += a;
			mostQ.add(most);
			leastQ.add(least);
		}
	}

}
