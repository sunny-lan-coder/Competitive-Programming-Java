package ccc.j2014;

import java.util.Scanner;

public class P2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int a = 0;
		int b = 0;
		String l = s.next();
		for (int i = 0; i < V; i++) {
			if (l.charAt(i) == 'A')
				a++;
			else
				b++;
		}
		if (a > b)
			System.out.println("A");
		else if (a < b)
			System.out.println("B");
		else
			System.out.println("Tie");
		s.close();
	}

}
