package dmoj;

public class TooSimple {

	static class Hello {

	}

	class World {

	}

	public static void main(String[] args) {
		String hello = Hello.class.getSimpleName();
		String world = World.class.getSimpleName();

		int one = Integer.MAX_VALUE / Integer.MAX_VALUE;
		int two = one + one;
		int four = two + two;
		int eight = four + four;
		int sixteen = eight + eight;
		int thirtytwo = sixteen + sixteen;

		char space = (char) thirtytwo;
		char exc = (char) (space + one);
		char comma = (char) (thirtytwo + eight + four);
		System.out.println(hello + comma + space + world + exc);
	}

}
