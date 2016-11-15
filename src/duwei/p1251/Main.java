package duwei.p1251;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n;
		while ((n = s.nextInt()) != 0) {
			int p;
			while ((p = s.nextInt()) != 0) {
				int[] required = new int[n];
				required[0] = p;
				for (int i = 1; i < n; i++) {
					required[i] = s.nextInt();
				}

				Stack<Integer> station = new Stack<Integer>();
				int idx = 0;
				for (int i = 1; i <= n;) {
//					System.out.println("Current: "+i+", Needed: "+required[idx]);
					if (i == required[idx]) {
						idx++;
						i++;
					} else {
						if (!station.isEmpty() && station.peek() == required[idx]) {
							idx++;
							station.pop();
						} else {
							station.push(i);
							i++;
						}
					}
				}
				
				while(!station.isEmpty() && station.peek() == required[idx])
				{
					idx++;
					station.pop();
				}
				
				if (station.isEmpty())
					System.out.println("Yes");
				else
					System.out.println("No");
			}
			System.out.println();

		}
		s.close();
	}

}
