package ccc.j2012;

import java.util.Scanner;

public class J3 {

	public static void main(String[] args) {

		String[] lines = { "*x*", " xx", "* *" };

		char[][] icon = new char[3][3];

		for (int i = 0; i < 3; i++) {
			String line = lines[i];
			for (int j = 0; j < 3; j++) {
				icon[i][j] = line.charAt(j);
			}
		}

		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		s.close();

		for (int i = 0; i < 3; i++) {
			String line = "";
			for (int j = 0; j < 3; j++) {
				String tmp="";
				for(int x=0;x<k;x++){
					tmp=tmp+icon[i][j];
				}
				line=line+tmp;
			}
			for(int x=0;x<k;x++){
				System.out.println(line);
			}
		}
	}

}
