package classproblems;

import java.util.Scanner;

public class Coins {

	static final int infinity = -1;

	public static void main(String[] args) {
		int numCoinSet = 3;
		int[] coinSet = { 3, 5, 11 };
		int x;
		{
			Scanner s = new Scanner(System.in);
			x = s.nextInt();
			s.close();
		}
		int n = x + 1;
		int[] sums = new int[n];

		int[] coins = new int[n];

		int[] costs = new int[n];
		for (int i = 0; i <= x; i++) {
			costs[i] = infinity;
		}
		costs[0] = 0;
		coins[0] = 0;

		outer: for (int currentState = 0; currentState <= x; currentState++) {
			//System.out.println("state number " + i);
			for (int coinIndex = 0; coinIndex < numCoinSet; coinIndex++) {
				int coin = coinSet[coinIndex];
		//		System.out.println("	coin " + coin);
				if (coin > currentState) {
				//	System.out.println("		exit");
					continue outer;
				}

				int term2 = currentState - coin;
			//	System.out.println("		completor " + term2);
				int term2Cost = costs[term2];
				//System.out.println("		cost " + term2Cost);
				int newCost = term2Cost + 1;
			//	System.out.println("		newcost " + newCost);
				if (term2Cost != infinity) {
					if (sl(newCost, costs[currentState])) {
						costs[currentState] = newCost;
						coins[currentState] = coin;
						sums[currentState] = term2;
					//	System.out.println("		update");
					}
				} else {
				//	System.out.println("		no solution");
				}
			}
		}

		int currentState = x;
	//	for (int i : costs) {
		//	System.out.println(i);
	//	}
		if (costs[currentState] == infinity) {
			System.out.println("FAILURE");
			return;
		}
		int sum = 0;
		System.out.println(costs[currentState]);
		while (sum != x) {
			System.out.print(coins[currentState]+", ");
			sum += coins[currentState];
			currentState = sums[currentState];
		}
	}

	static boolean sl(int a, int b) {
		if (a == infinity && b != infinity)
			return false;
		if (a != infinity && b == infinity)
			return true;
		if (a == infinity && b == infinity)
			return false;
		return a < b;
	}

}
