package duwei.p1251;

import java.util.ArrayList;
import java.util.Random;

public class Gen {

	public static void main(String[] args) {
		ArrayList<Integer> full = new ArrayList<>();
	
		for (int i = 1; i <= 10; i++) {
			full.add(i);
		}
		Random rng = new Random();
		for (int i = 0; i < 6; i++) {
			System.out.println(10);
			
			for (int j = 0; j < 6; j++) {
				ArrayList<Integer> current = new ArrayList<>(full);
				while(!current.isEmpty()) {
					int idx = rng.nextInt(current.size());
					System.out.print(current.get(idx) + " ");
					current.remove(idx);
				}
				System.out.println();
			}
			System.out.println("0");
		}
		System.out.println("0");
	}

}
