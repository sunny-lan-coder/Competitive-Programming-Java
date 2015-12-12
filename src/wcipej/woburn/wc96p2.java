package wcipej.woburn;

import java.util.Scanner;

public class wc96p2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String tmp="";
		for (int testcase = 0; testcase < 5; testcase++) {
			// System.out.println("top");
			int rows = s.nextInt();
			int cols = s.nextInt();

			String coldata = s.next();

			if (testcase == 0)
				tmp = rows + " " + cols + " " + coldata;

			if (testcase == 1) {
				System.out.println(rows + " " + cols + " " + coldata + "," + tmp);
			}

			char[][] decompressedTable = new char[rows][cols];

			// System.out.println("decompress");
			int tableidx = 0;
			for (int dataidx = 0; dataidx < coldata.length(); dataidx++) {
				int num;
				try {
					num = Integer.parseInt(Character.toString(coldata.charAt(dataidx)));
					dataidx++;
				} catch (NumberFormatException e) {
					num = 1;
				}
				char letter = coldata.charAt(dataidx);
				// System.out.println("parsed " + num + " x " + letter);
				for (int numidx = 0; numidx < num; numidx++) {
					decompressedTable[tableidx % rows][(int) Math.floor(tableidx / rows)] = letter;
					tableidx++;
				}
			}

			// for (char[] row : decompressedTable) {
			// for (char c : row) {
			// System.out.print(c + " ");
			// }
			// System.out.println();
			// }

			// System.out.println("compress");

			String compressed = "";
			for (int row = 0; row < rows; row++) {
				int currentCount = 0;
				char prevChar = ' ';
				for (int col = 0; col < cols; col++) {
					char currentChar = decompressedTable[row][col];
					if (currentChar == prevChar) {
						currentCount++;
					} else {
						if (prevChar != ' ') {
							if (currentCount != 1) {
								compressed = compressed + currentCount;
							}
							compressed = compressed + prevChar;
						}
						currentCount = 1;
						prevChar = currentChar;
					}
				}
				// if (prevChar != ' ') {
				if (currentCount != 1) {
					compressed = compressed + currentCount;
				}
				compressed = compressed + prevChar;
				// }
			}

			System.out.println(compressed);
		}
		s.close();
	}

}
