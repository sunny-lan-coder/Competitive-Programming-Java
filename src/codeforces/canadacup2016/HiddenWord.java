package codeforces.canadacup2016;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HiddenWord {

	public static void main(String[] args) {
		final String map = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Scanner s = new Scanner(System.in);
		String in = s.nextLine();
		s.close();
		int[] degrees = new int[26];
		HashMap<Integer, ArrayList<Character>> adj = new HashMap<>();
		for (int i = 0; i < 27; i++) {
			int idx = map.indexOf(in.charAt(i));
			if (!adj.containsKey(idx))
				adj.put(idx, new ArrayList<>());
			if (i < 26) {
				adj.get(idx).add(in.charAt(idx + 1));
				degrees[idx]++;
			}
			degrees[idx]++;
			if (i > 0) {
				adj.get(idx).add(in.charAt(idx - 1));
				degrees[idx]++;
			}
		}

		int loc1 = -1;
		int val = 0;
		for (int i = 0; i < 26; i++) {
			if (degrees[i] > val) {
				loc1 = i;
				val = degrees[i];
			}
		}
		char c = in.charAt(loc1);

		int loc2 = -1;
		for (int i = 0; i < 27; i++) {
			if (i != loc1 && in.charAt(i) == c) {
				loc2 = i;
				break;
			}
		}

		ArrayList<Character> adj1 = adj.get(loc1);
		ArrayList<Character> adj2 = adj.get(loc2);
		
		//adj1.remove(o);

	}

	static boolean test(String in, int loc, ArrayList<Character> adj) {
		for (int i = 0; i < 26; i++) {
			in = in.substring(1);
		}
		return false;
	}

}
