package ccc.junior.y2014;

import java.util.Scanner;

public class J2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int a = 0;
		int b = 0;
		String seq = s.next();
		for (int votenum = 0; votenum < V; votenum++) {
			switch (seq.charAt(votenum)) {
			case 'A':
				a++;
				break;
			case 'B':
				b++;
				break;
			}
		}
		if (a > b)
			System.out.println("A");
		else if (b > a)
			System.out.println("B");
		else
			System.out.println("Tie");
		s.close();
	}

}
