package ccc.y2012;

import java.util.Scanner;

public class J4 {

	public static void main(String[] args) {
		String map = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Scanner in = new Scanner(System.in);
		int K = in.nextInt();
		String msg = in.next();
		in.close();
		String newmsg = "";
		for (int P = 1; P <= msg.length(); P++) {
			int idx = P - 1;
			char letter = msg.charAt(idx);
			int S = 3 * P + K;
			int letteridx = map.indexOf(letter);
			int newletteridx = (letteridx - S) % 26;
			if (newletteridx < 0)
				newletteridx += 26;
			char newletter = map.charAt(newletteridx);
			newmsg = newmsg + newletter;
		}
		System.out.println(newmsg);
	}

}
