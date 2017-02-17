package ccc.s2014;

import java.util.ArrayList;
import java.util.Scanner;

public class ccc14s1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		ArrayList<Integer> friends = new ArrayList<>();

		for (int i = 1; i <= k; i++) {
			friends.add(i);
		}
		int m = s.nextInt();
		for (int i = 0; i < m; i++) {
			int r = s.nextInt();
			ArrayList<Integer> newlist = new ArrayList<>();
			for (int j = 1; j <= friends.size(); j++) {
				if (j % r != 0) {
					newlist.add(friends.get(j - 1));
				}
			}
			friends = newlist;
		}
		s.close();
		for (int i = 0; i < friends.size(); i++)
			System.out.println(friends.get(i));
	}
}
