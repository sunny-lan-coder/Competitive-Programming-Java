package classq.bag;

import java.util.ArrayList;

public class DPSolution {

	static final Item zero;
	static {
		zero = new Item();
		zero.V = 0;
		zero.W = 0;
	}

	public static void solve(int W, ArrayList<Item> items) {
		State[] states = new State[W + 1];
		for (int i = 0; i <= W; i++) {
			states[i] = new State();
		}
		for (Item i : items) {
			for (int iS = i.W; iS <= W; iS++) {
				State currentState = states[iS];
				int currentVal = currentState.i.V
						+ states[currentState.state].totalV;
				int newState = iS - i.W;
				int newValue = states[newState].totalV + i.V;
				if (newValue > currentVal) {
					currentState.totalV = newValue;
					currentState.state = newState;
					currentState.i = i;
				} else {
					currentState.totalV = currentVal;
				}
			}
		}

		System.out.println(states[W].totalV);
		for (int i = W; i >= 0; i++) {
			int currState;
			for (currState = i; states[currState].i != zero;) {
				System.out.println(states[currState]);
				currState = states[currState].state;
			}
			if (currState == 0)
				return;
		}
	}

	static class State {
		public Item i = zero;
		public int state = 0;
		public int totalV = 0;

		public String toString() {
			return "S{" + i + ",s{" + state + "},V{" + totalV + "}}";
		}
	}

	static class Item {
		public int W;
		public int V;

		public String toString() {
			return "I{W{" + W + "},V{" + V + "}}";
		}
	}
}
