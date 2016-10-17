package duwei.tmp20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		HashMap<String, LinkedList<String>> connections = new HashMap<String, LinkedList<String>>();
		Scanner s = new Scanner(System.in);
		String lastColor = null;
		while (s.hasNext()) {
			// control even/odd list
			String color1 = s.next();
			String color2 = s.next();

			if (set.contains(color1)) {
				set.remove(color1);
			} else {
				set.add(color1);
			}

			if (set.contains(color2)) {
				set.remove(color2);
			} else {
				set.add(color2);
			}

			// create adjacency list
			LinkedList<String> list1;
			LinkedList<String> list2;
			if (!connections.containsKey(color1))
				connections.put(color1, new LinkedList<String>());
			list1 = connections.get(color1);

			if (!connections.containsKey(color2))
				connections.put(color2, new LinkedList<String>());
			list2 = connections.get(color2);

			list1.add(color2);
			list2.add(color1);
			lastColor = color1;

		}
		s.close();
		// check graph connectivity

		LinkedList<String> current = new LinkedList<String>();
		current.add(lastColor);
		while (!current.isEmpty()) {
			LinkedList<String> newList = new LinkedList<String>();
			for (String toRemove : current) {
				if (connections.containsKey(toRemove)) {
					newList.addAll(connections.get(toRemove));

					connections.remove(toRemove);
				}

			}
			current = newList;
		}
		if (!connections.isEmpty()) {
			System.out.println("Impossible - broken graph");
			return;
		}

		if (set.size() == 2) {
			System.out.println("Possible");
			return;
		}

		if (set.size() == 0) {
			System.out.println("Possible");
			return;
		}

		System.out.println("Impossible");
	}

}