package classq.cups;

public class WinningState extends State {
	private final int wantedVal;

	public WinningState(int wantedVal) {
		super(null, null);
		this.wantedVal = wantedVal;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof State) {
			State s = (State) o;
			return (s.a.value == wantedVal && s.b.value == 0)
					|| (s.a.value == 0 && s.b.value == wantedVal)
					|| (s.a.value + s.b.value == wantedVal);
		}
		return false;
	}
}
