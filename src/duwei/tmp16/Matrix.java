package duwei.tmp16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Matrix {

	static class HBit{
		long p1;
		long p2;
		
		public HBit(){}
		
		public void bitIn(int val){
			p2=p2<<1;
			p2|=(p1>>63);
			p1=p1<<1;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		int[][] arr1 = new int[n][m];
		long[][] encoded = new long[n][m];
		for (int i = 0; i < n; i++) {
			long buffer = 0;
			tmp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				if (tmp[j].equals("1")) {
					arr1[i][j] = 1;
				} else {
					arr1[i][j] = 0;
				}
			}
		}
		
		tmp = br.readLine().split(" ");
		int n1 = Integer.parseInt(tmp[0]);
		int m1 = Integer.parseInt(tmp[1]);
		int[][] arr2 = new int[n][m];
		long hash;
		for (int i = 0; i < n1; i++) {
			long buffer = 0;
			tmp = br.readLine().split(" ");
			for (int j = 0; j < m1; j++) {
				if (tmp[j].equals("1")) {
					arr2[i][j] = 1;
				} else {
					arr2[i][j] = 0;
				}
			}
		}
		
		

		br.close();

	}

}
