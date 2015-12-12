package classq.cups;

import java.util.HashSet;
import java.util.Stack;

public class Pathfinder {

	static HashSet<State> testedStates;
	static Stack<StateAction> result = null;
	static Stack<StateAction> currentSearch;
	static State target;
	static String prefix = "";

	@SuppressWarnings("unchecked")
	public static boolean leadsToTarget(State s) {

		if (result != null && currentSearch.size() > result.size()) {
			return false;
		}

		if (target.equals(s)) {
			result = ((Stack<StateAction>) currentSearch.clone());
			return true;
		}

		if (testedStates.contains(s)) {
			// System.out.println(prefix + "state already tested");
			return false;
		}

		testedStates.add(s);

		boolean isblocked = false;

		for (StateAction test : State.possibleActions) {
			// System.out.println(prefix + "testing " + test);
			State current = test.apply(s);
			// System.out.println(prefix + "state is " + current);
			currentSearch.push(test);
			// prefix = prefix + "    ";
			isblocked = isblocked | leadsToTarget(current);
			// prefix = prefix.substring(0, prefix.length() - 4);
			currentSearch.pop();
		}

		testedStates.remove(s);

		return isblocked;
	}

	public static void main(String[] args) {
		testedStates = new HashSet<State>();
		currentSearch = new Stack<StateAction>();
		target = new WinningState(5);
		State start = new State(new Cup(7, 0), new Cup(3, 0));
		System.out.println(start);
		if (leadsToTarget(start)) {
			System.out.println("shortest result");
			for (StateAction step : result) {
				System.out.println("    " + step);
				start = step.apply(start);
				System.out.println("    State is now " + start);
			}
		} else {
			System.out.println("No solution");
		}

	}
}
