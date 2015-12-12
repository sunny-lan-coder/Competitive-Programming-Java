package classq.bag;


public class DynamicSubset {

	public static boolean solve2(int[] set, int x) {
		int splitPoint = (int) Math.floor(set.length / 2);
		int[] setA = new int[splitPoint];
		int i;
		for (i = 0; i < splitPoint; i++) {
			setA[i] = set[i];
		}

		int max = 0;
		for (int e : setA) {
			max += e;
		}
		boolean[] hashA = new boolean[max + 1];
		int lim = 2 << setA.length - 1;
		for (int j = 0; j < lim; j++) {
			int tmp = j;
			int sum = 0;
			for (int k = 0; k < setA.length; k++) {
				if ((tmp & 1) == 1) {
					sum += set[j];
				}
				tmp = tmp >> 1;
			}
			hashA[sum] = true;
		}

		int[] setB = new int[set.length - splitPoint];
		for (; i < set.length; i++) {
			setB[i - splitPoint] = set[i];
		}
		for (int e : setA) {
			max += e;
		}
		boolean[] hashB = new boolean[max + 1];
		lim = 2 << setB.length - 1;
		for (int j = 0; j < lim; j++) {
			int tmp = j;
			int sum = 0;
			for (int k = 0; k < setB.length; k++) {
				if ((tmp & 1) == 1) {
					sum += set[j];
				}
				tmp = tmp >> 1;
			}
			hashB[sum] = true;
		}

		for (int e = 0; e < hashA.length; e++) {
			if (hashA[e]) {
				int term = x - e;
				if (term < hashB.length) {
					if (hashB[term]) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean solve(int[] set, int x) {
		State[] states = new State[x + 1];
		for (int i = 0; i <= x; i++) {
			states[i] = new State();
		}
		states[0].solved = true;
		for (int num : set) {
			for (int iS = num; iS <= x; iS++) {
				State currentState = states[iS];
				boolean currentSolved = states[currentState.state].solved;
				int newState = x - num;
				boolean newSolved = states[newState].solved;
				if ((!currentSolved) && newSolved) {
					currentState.state = newState;
					currentState.solved = true;
					currentState.val = num;
				}
			}
		}
		return states[x].solved;
	}

	static class State {
		int val;
		int state;
		boolean solved = false;
	}
}
