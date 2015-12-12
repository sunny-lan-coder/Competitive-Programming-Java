package classq.cups;

public class Cup {
	public final int capacity;
	public final int value;

	public Cup(int capacity, int value) {
		if (!(capacity > 0))
			throw new IllegalArgumentException(
					"Capacity must be bigger than zero");
		this.capacity = capacity;
		this.value = value;
	}

	public Cup fill() {
		return new Cup(capacity, capacity);
	}

	public Cup empty() {
		return new Cup(capacity, 0);
	}

	public Cup pourTo(Cup cup) {
		return new Cup(capacity,
				Math.max(0, value - (cup.capacity - cup.value)));
	}

	public Cup add(Cup scooper) {
		int t = scooper.value;
		// scooper = scooper.empty();
		return new Cup(capacity, Math.min(capacity, value + t));
	}

	@Override
	public String toString() {
		return "Cup with " + value + "/" + capacity + " L";
	}
}
