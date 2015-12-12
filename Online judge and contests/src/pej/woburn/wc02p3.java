package pej.woburn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class wc02p3 {

	static class IngreAmount {
		public String name;
		public double servings;

		public IngreAmount(String name, double servings) {
			this.name = name;
			this.servings = servings;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String lowercase = "qwertyuiopasdfghjklzxcvbnm";
		int T = s.nextInt();
		for (int testCase = 0; testCase < T; testCase++) {

			Map<String, List<IngreAmount>> compIngres = new HashMap<>();

			Map<String, Double> basicIngres = new HashMap<>();
			int N = s.nextInt();

			for (int listingNum = 0; listingNum < N; listingNum++) {
				String ingre = s.next();
				if (lowercase.contains(Character.toString(ingre.charAt(0)))) {
					basicIngres.put(ingre, 0d);
				} else {
					compIngres.put(ingre, new ArrayList<>());
				}
			}

			for (String compIngre : compIngres.keySet()) {
				int k = s.nextInt();
				List<IngreAmount> recipe = compIngres.get(compIngre);
				for (int ingreIdx = 0; ingreIdx < k; ingreIdx++) {
					double servings = s.nextDouble();
					String ingre = s.next();
					recipe.add(new IngreAmount(ingre, servings));
				}
			}

			Queue<IngreAmount> toExpand = new LinkedList<>();
			while (!toExpand.isEmpty()) {
				IngreAmount ingre = toExpand.remove();
				if (basicIngres.containsKey(ingre.name)) {
					basicIngres.put(ingre.name, basicIngres.get(ingre.name) + ingre.servings);
				} else {
					List<IngreAmount> recipe = compIngres.get(ingre.name);
					for (IngreAmount thing : recipe) {
						toExpand.add(thing);
					}
				}
			}

			for (String ingre : basicIngres.keySet()) {
				Double amount = basicIngres.get(ingre);
				System.out.println(amount + " " + ingre);
			}
		}
		s.close();
	}

}
