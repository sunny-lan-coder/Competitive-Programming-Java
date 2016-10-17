package duwei.tmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		String[] a = s.nextLine().split(",");
		s.close();
		int n = a.length;
		int lim = 1 << n;
		for (int c = 0; c < lim; c++) {
			int tmp = c;
			for (int j = 0; j < n; j++) {
				if ((tmp & 1) == 1) {
					
				} else {
					
				}
				tmp = tmp >> 1;
			}
		}
	}

}
