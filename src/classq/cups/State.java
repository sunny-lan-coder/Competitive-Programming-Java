package classq.cups;

import java.util.ArrayList;

public class State {
	public static final ArrayList<StateAction> possibleActions;
	static {
		possibleActions = new ArrayList<StateAction>();
		possibleActions.add(new StateAction() {

			@Override
			public State apply(State s) {
				// fill a
				Cup a = s.a.fill();
				Cup b = s.b;
				return new State(a, b);
			}

			@Override
			public String toString() {
				return "action:fill a";
			}
		});
		possibleActions.add(new StateAction() {

			@Override
			public State apply(State s) {
				// fill b
				Cup a = s.a;
				Cup b = s.b.fill();
				return new State(a, b);
			}

			@Override
			public String toString() {
				return "action:fill b";
			}
		});
		possibleActions.add(new StateAction() {

			@Override
			public State apply(State s) {
				// empty a
				Cup a = s.a.empty();
				Cup b = s.b;
				return new State(a, b);
			}

			@Override
			public String toString() {
				return "action:empty a";
			}
		});
		possibleActions.add(new StateAction() {

			@Override
			public State apply(State s) {
				// empty b
				Cup a = s.a;
				Cup b = s.b.empty();
				return new State(a, b);
			}

			@Override
			public String toString() {
				return "action:empty b";
			}
		});
		possibleActions.add(new StateAction() {

			@Override
			public State apply(State s) {
				// scoop smaller cup out of larger
				Cup a;
				Cup b;
				a = s.a.pourTo(s.b);
				b = s.b.fill();
				return new State(a, b);
			}

			@Override
			public String toString() {
				return "action:pour cup a into cup b";
			}
		});

		possibleActions.add(new StateAction() {

			@Override
			public State apply(State s) {
				Cup a;
				Cup b;

				a = s.a.fill();
				b = s.b.pourTo(s.a);

				return new State(a, b);
			}

			@Override
			public String toString() {
				return "pour cup b into a";
			}
		});

		possibleActions.add(new StateAction() {

			@Override
			public State apply(State s) {
				// add cup a to cup b
				Cup a = s.a.empty();
				Cup b = s.b.add(s.a);
				return new State(a, b);
			}

			@Override
			public String toString() {
				return "action:pour a into b";
			}
		});
		possibleActions.add(new StateAction() {

			@Override
			public State apply(State s) {
				// add cup b to cup a
				Cup a = s.a.add(s.b);
				Cup b = s.b.empty();
				return new State(a, b);
			}

			@Override
			public String toString() {
				return "action:pour b into a";
			}
		});
	}

	public final Cup a;
	public final Cup b;

	public State(Cup a, Cup b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof State) {
			State s = (State) o;
			return (s.a.capacity == a.capacity) && (s.b.capacity == b.capacity)
					&& (s.a.value == a.value) && (s.b.value == b.value);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return a.value * a.capacity + b.value;
	}

	@Override
	public String toString() {
		return "state:cup a = " + a.toString() + ", cup b = " + b.toString();
	}
}
