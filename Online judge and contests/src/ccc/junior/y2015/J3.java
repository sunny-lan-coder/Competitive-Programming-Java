package ccc.junior.y2015;

import java.util.Arrays;
import java.util.Scanner;

public class J3 {

	static char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	static char[] vowels = "aeiou".toCharArray();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		char[] word = s.next().toCharArray();
		String result = "";
		for (char c : word) {
			result = result + c;
			if (isConst(c)) {
				int cIndex = Arrays.binarySearch(letters, c);
				for (int up = cIndex - 1, down = cIndex + 1;; up--, down++) {
					char upvowel = ' ';
					char downvowel = ' ';
					if (up >= 0) {
						if (isVowel(letters[up])) {
							upvowel = letters[up];
						}
					}
					if (down < letters.length) {
						if (isVowel(letters[down])) {
							downvowel = letters[down];
						}
					}
					if (upvowel != ' ' && downvowel != ' ') {
						result = result + upvowel;
						break;
					}
					if (upvowel != ' ') {
						result = result + upvowel;
						break;
					}
					if (downvowel != ' ') {
						result = result + downvowel;
						break;
					}
				}

				if (c == 'z') {
					result = result + c;
					continue;
				}
				for (int i = cIndex + 1; i < letters.length; i++) {
					if (isConst(letters[i])) {
						result = result + letters[i];
						break;
					}
				}
			}
		}
		System.out.println(result);
		s.close();
	}

	static boolean isVowel(char c) {
		for (char vowel : vowels) {
			if (c == vowel)
				return true;
		}
		return false;
	}

	static boolean isConst(char c) {
		for (char vowel : vowels) {
			if (c == vowel)
				return false;
		}
		return true;
	}

}
