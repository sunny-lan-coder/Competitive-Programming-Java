package wcipej.woburn;

import java.util.Scanner;

public class wc95p1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			String command = s.nextLine();
			String data = s.nextLine();//.replace(' ', '.');
			int datLen = data.length();
			int rows = (int) Math.ceil(datLen / 5d);
			if (command.equals("D")) {
				char[][] table = new char[5][rows];
				int currentChar = 0;
				for (int column = 0; column < 5; column++) {
					for (int row = 0; row < rows; row++) {
						try {
							table[column][row] = data.charAt(currentChar);
						} catch (IndexOutOfBoundsException e) {
							table[column][row] = ' ';
						}

						currentChar++;
					}
				}

				String result = "";
				for (int row = 0; row < rows; row++) {
					for (int column = 0; column < 5; column++) {
						result = result + table[column][row];
					}
				}
				System.out.println(result);
			}
			
			if (command.equals("E")) {
				char[][] table = new char[5][rows];
				int currentChar = 0;
				for (int row = 0; row < rows; row++) {
					for (int column = 0; column < 5; column++) {
						try {
							table[column][row] = data.charAt(currentChar);
						} catch (IndexOutOfBoundsException e) {
							table[column][row] = ' ';
						}

						currentChar++;
					}
				}

				String result = "";
				for (int column = 0; column < 5; column++) {
					for (int row = 0; row < rows; row++) {
						result = result + table[column][row];
					}
				}
				System.out.println(result);
			}
		}
		s.close();
	}

}
