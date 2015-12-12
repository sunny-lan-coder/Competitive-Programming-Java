package classq.bag;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import classq.bag.DPSolution.Item;

public class Main {

	public static void main(String[] args) {

		ArrayList<Item> items = new ArrayList<Item>();

		Scanner s = new Scanner(System.in);

		System.out.print("N:");
		int n = s.nextInt();
		System.out.print("W:");
		int W = s.nextInt();
		System.out.print("Randomize items (1/0)?");

		int selection = s.nextInt();

		if (selection == 1) {
			System.out.print("V[Wmax]:");
			int Wmax = s.nextInt();
			System.out.print("V[Wmin]:");
			int Wmin = s.nextInt();
			System.out.print("V[Vmax]:");
			int Vmax = s.nextInt();
			System.out.print("V[Vmin]:");
			int Vmin = s.nextInt();

			Random rng = new Random();

			for (int i = 0; i < n; i++) {
				Item tmp = new Item();
				tmp.V = rng.nextInt(Vmax - Vmin) + Vmin; // s.nextInt();
				tmp.W = rng.nextInt(Wmax - Wmin) + Wmin;// s.nextInt();

				System.out.print("W[" + i + "]:");
				System.out.print(tmp.W);

				System.out.print(", V[" + i + "]:");
				System.out.println(tmp.V);

				items.add(tmp);
			}
		} else if (selection == 0) {
			for (int i = 0; i < n; i++) {
				Item tmp = new Item();

				System.out.print("W[" + i + "]:");
				tmp.W = s.nextInt();

				System.out.print("V[" + i + "]:");
				tmp.V = s.nextInt();

				items.add(tmp);
			}
		} else {
			s.close();
			return;
		}

		s.close();
		System.out.println("dp:");
		DPSolution.solve(W, items);
	}
}
