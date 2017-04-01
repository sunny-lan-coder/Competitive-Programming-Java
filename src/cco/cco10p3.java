package cco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class cco10p3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> idToRating = new HashMap<>();
		HashMap<Integer, Integer> ratingToId = new HashMap<>();
		String[] tmp;
		for (int i = 0; i < n; i++) {
			tmp = br.readLine().split(" ");
			if (tmp[0].equals("N")) {
				int x = Integer.parseInt(tmp[1]);
				int r = Integer.parseInt(tmp[2]);
			} else if (tmp[0].equals("M")) {
				int x = Integer.parseInt(tmp[1]);
				int r = Integer.parseInt(tmp[2]);
			} else if (tmp[0].equals("Q")) {
				int k = Integer.parseInt(tmp[1]);
			}
		}
		br.close();
	}
}
