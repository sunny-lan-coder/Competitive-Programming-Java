package ecoo;

import java.util.Scanner;

public class ecoo1p2 {

	static String scrambled;

	public static void main(String[] args) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		Scanner s = new Scanner(System.in);
		for (int t = 0; t < 5; t++) {
			String key = (s.nextLine() + alphabet).toUpperCase();
			String ciphertext = s.nextLine();

			scrambled = "";
			for (int i = 0; i < key.length(); i++) {
				char c = key.charAt(i);
				if (alphabet.contains("" + c) && !scrambled.contains("" + c)) {
					scrambled += c;
				}
			}
			System.out.println(scrambled);

			String plaintext = "";

			for (int i = 0; i < ciphertext.length(); i += 2) {
				char a = ciphertext.charAt(i);
				char b = ciphertext.charAt(i + 1);

				plaintext += getRight(b);

				plaintext += getLeft(a);
			}

			if (plaintext.length() % 2 == 0 && plaintext.charAt(plaintext.length() - 1) == 'X') {
				plaintext = plaintext.substring(0, plaintext.length() - 1);
			}

			plaintext = plaintext.replace('X', ' ');
			plaintext = plaintext.replace("KS", "X");
			System.out.println(plaintext);
		}
		s.close();
	}

	static char getLeft(char c) {
		int x = (scrambled.indexOf(c) + 25) % 26;
		return scrambled.charAt(x);
	}

	static char getRight(char c) {
		int x = (scrambled.indexOf(c) + 1) % 26;
		return scrambled.charAt(x);
	}

}
