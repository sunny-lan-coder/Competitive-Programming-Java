package usaco.gold2015december;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class P1 {
	public static void main(String[] args) throws IOException {
		InputStream in = new FileInputStream("cardgame.in");
		PrintStream out = new PrintStream(new FileOutputStream("cardgame.out"));
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> elsieh1 = new ArrayList<>(n / 2);
		ArrayList<Integer> elsieh2 = new ArrayList<>(n / 2);
		ArrayList<Integer> bessie;
		{
			HashSet<Integer> bessie2 = new HashSet<Integer>(n * 2);
			for (int i = 1; i <= 2 * n; i++) {
				bessie2.add(i);
			}

			for (int i = 0; i < n / 2; i++) {
				int card = Integer.parseInt(br.readLine());
				elsieh1.add(card);
			}
			bessie2.removeAll(elsieh1);
			for (int i = 0; i < n / 2; i++) {
				int card = Integer.parseInt(br.readLine());
				elsieh2.add(card);
			}
			bessie2.removeAll(elsieh2);
			br.close();
			bessie = new ArrayList<>(bessie2);
		}

		Collections.sort(bessie);
		Collections.sort(elsieh1);
		Collections.sort(elsieh2);
		int points = 0;
		for (int i = elsieh1.size() - 1; i >= 0; i--) {
			if (bessie.get(bessie.size() - 1) > elsieh1.get(i)) {
				points++;
				bessie.remove(bessie.size() - 1);
			}
		}
		Collections.reverse(bessie);
		for (int i = 0; i < elsieh2.size(); i++) {
			if (bessie.get(bessie.size() - 1) < elsieh2.get(i)) {
				points++;
				bessie.remove(bessie.size() - 1);
			}
		}
		out.println(points);
		out.close();
	}
}
