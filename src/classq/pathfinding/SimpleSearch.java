package classq.pathfinding;

import java.util.ArrayList;
import java.util.Stack;

public class SimpleSearch {

	static boolean o = false;
	static boolean l = true;
	static boolean[][] blocked = { { o, o, l, l, o, o, o },
			{ o, l, o, o, o, l, o }, { o, o, o, l, o, o, o },
			{ o, l, o, o, l, o, o }, { o, o, l, l, o, o, l },
			{ o, o, o, l, l, o, o }, { o, o, o, o, o, o, o } };

	static int targetX;
	static int targetY;

	static Stack<Direction> currentSearch;
	static ArrayList<Stack<Direction>> results;

	static String prefix = "";

	public static void main(String[] args) {
		results = new ArrayList<Stack<Direction>>();
		currentSearch = new Stack<Direction>();
		targetX = blocked.length - 1;
		targetY = blocked[0].length - 1;
		if (leadsToTarget(0, 0)) {
			for (Stack<Direction> result : results) {
				System.out.println("result:");
				for (Direction d : result) {
					System.out.println(d.toString());
				}
			}
		} else {
			System.out.println("Cannot find path");
		}
	}

	@SuppressWarnings("unchecked")
	static boolean leadsToTarget(int x, int y) {
		// System.out.println(prefix + "Testing " + x + "," + y);

		// prefix += " ";
		try {
			if (blocked[y][x]) {
				// System.out.println(prefix + " index is blocked");
				// prefix = prefix.substring(0, prefix.length() - 1);
				return false;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// System.out.println(prefix + " index out of bounds");
			// prefix = prefix.substring(0, prefix.length() - 1);
			return false;
		}

		if (x == targetX && y == targetY) {
			results.add((Stack<Direction>) currentSearch.clone());
			// prefix = prefix.substring(0, prefix.length() - 1);
			return true;
		}

		blocked[y][x] = true;

		boolean isblocked = false;

		// System.out.println(prefix + "testing up");
		currentSearch.push(Direction.UP);
		isblocked = isblocked | leadsToTarget(x, y - 1);
		currentSearch.pop();

		// System.out.println(prefix + "testing down");
		currentSearch.push(Direction.DOWN);
		isblocked = isblocked | leadsToTarget(x, y + 1);
		currentSearch.pop();

		// System.out.println(prefix + "testing left");
		currentSearch.push(Direction.LEFT);
		isblocked = isblocked | leadsToTarget(x - 1, y);
		currentSearch.pop();

		// System.out.println(prefix + "testing right");
		currentSearch.push(Direction.RIGHT);
		isblocked = isblocked | leadsToTarget(x + 1, y);
		currentSearch.pop();

		// prefix = prefix.substring(0, prefix.length() - 1);
		return isblocked;
	}
}
