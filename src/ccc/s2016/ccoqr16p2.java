package ccc.s2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccoqr16p2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");  
			int k = Integer.parseInt(line[0]);
			for (int j = 1; j <= k; j++) {
				int c = Integer.parseInt(line[j]);
			}
		}
		
		br.close();
	}

}
