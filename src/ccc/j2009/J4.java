package ccc.j2009;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class J4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<String> words = new ArrayList<>(Arrays.asList("WELCOME TO CCC GOOD LUCK TODAY".split(" ")));
		System.out.println("Enter w: ");
		int w = s.nextInt();
		s.close();
		ArrayList<String> lines = new ArrayList<>();
		while (!words.isEmpty()) {
			int wordcount = 0;
			int wordchars = 0;
			ArrayList<String> currentlinewords = new ArrayList<>();
			while (!words.isEmpty()) {
				String wordConsidering = words.get(0);
				int newwordcount = wordcount + 1;
				int newwordchars = wordchars + wordConsidering.length();
				int minspace = newwordcount - 1;

				if (newwordchars + minspace > w) {
					break;
				}
				wordcount = newwordcount;
				wordchars = newwordchars;
				currentlinewords.add(wordConsidering);
				words.remove(0);
			}
			String currentLine = "";

			int spaceavail = w - wordchars;

//			System.out.println(spaceavail);

			int spacecount = wordcount - 1;

			int avgspacesize;
			int extra;

			if (spacecount == 0) {
				avgspacesize = 0;
				extra = 0;
			} else {
				avgspacesize = (int) Math.floor(spaceavail / spacecount);
				extra = spaceavail - (avgspacesize * spacecount);
			}

//			System.out.println(wordchars);
//			System.out.println(avgspacesize);
//			System.out.println(extra);

			currentLine += currentlinewords.get(0);
			currentlinewords.remove(0);

			for (int i = 0; i < extra; i++) {
				for (int j = 0; j < avgspacesize; j++) {

					currentLine += ".";
				}
				currentLine += ".";
				currentLine += currentlinewords.get(0);
				currentlinewords.remove(0);
			}

			for (int i = 0; i < spacecount - extra; i++) {
				for (int j = 0; j < avgspacesize; j++) {

					currentLine += ".";
				}
				currentLine += currentlinewords.get(0);
				currentlinewords.remove(0);
			}

			lines.add(currentLine);
		}
		for (String line : lines) {
			System.out.println(line);
		}
	}

}
