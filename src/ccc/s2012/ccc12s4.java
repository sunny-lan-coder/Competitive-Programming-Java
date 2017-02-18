package ccc.s2012;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ccc12s4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n;
		outer: while ((n = s.nextInt()) != 0) {

			int startstate = 0;
			int endstate = 0;
			for (int i = 0; i < n; i++) {
				int val = (s.nextInt() - 1);
				startstate |= i << (val * 3);
				endstate |= i << (i * 3);
			}
			boolean[] visited = new boolean[(2 << n * 3) - 1];
			Queue<Integer> states = new LinkedList<>();
			Queue<Integer> levels = new LinkedList<>();
			states.add(startstate);
			levels.add(0);
			while (!levels.isEmpty()) {
				int currstate = states.remove();
				int currlevel = levels.remove();
				if (currstate == endstate) {
					System.out.println(currlevel);
					continue outer;
				}

				if (visited[currstate])
					continue;

				for (int coin = 0; coin < n; coin++) {
					int pos = (currstate >> (coin * 3)) & 7;
					int newstate = currstate;
					newstate &= ~(7 << (coin * 3)); // clear old bits

					// search if can move left or right
					boolean left = true;
					boolean right = true;
					for (int j = 0; j < coin; j++) {
						int cpos = (currstate >> (j * 3)) & 7;
						if (cpos == pos - 1)
							left = false;
						if(cpos==pos){
							left=right=false;
							break;
						}
						if (cpos == pos + 1)
							right = false;
					}

					if (left && pos > 0) {// can go left
						states.add(newstate | ((pos - 1) << (coin * 3)));
//						System.out.println(" move coin "+coin+" left to "+String.format("%" + n * 3 + "s", Integer.toBinaryString(newstate | ((pos - 1) << (coin * 3)))).replace(' ', '0'));
						levels.add(currlevel + 1);
					}

					if (right && pos < n - 1) {// can go right
						states.add(newstate | ((pos + 1) << (coin * 3)));
//						System.out.println(" move coin "+coin+" right to "+String.format("%" + n * 3 + "s", Integer.toBinaryString(newstate | ((pos + 1) << (coin * 3)))).replace(' ', '0'));
						levels.add(currlevel + 1);
					}

				}
				visited[currstate] = true;
			}
			System.out.println("IMPOSSIBLE");
		}
		s.close();
	}

}
