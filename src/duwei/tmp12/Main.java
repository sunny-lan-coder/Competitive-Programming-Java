package duwei.tmp12;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		for (int t = 0; t < N; t++) {
			int n = s.nextInt();
			boolean[][] adjmat = new boolean[n][n];// [bigger][smaller]
			int[] degrees = new int[n];
			int[] aA = new int[n];
			int[] bA = new int[n];
			for (int i = 0; i < n; i++) {
				int a = s.nextInt();
				int b = s.nextInt();
				aA[i] = a;
				bA[i] = b;
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (smaller(aA[i], bA[i], aA[j], bA[j])) {
						adjmat[j][i] = true;
						degrees[j]++;
					}
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < i; j++) {
					if(adjmat[j][i]){
//						System.out.println("X("+aA[i]+","+bA[i]+") < "+"X("+aA[j]+","+bA[j]+")");
					}
				}
			}
			
			for(int i=0;i<n;i++){
//				System.out.println("degrees "+"X("+aA[i]+","+bA[i]+") = "+degrees[i]);
			}

			boolean[] visited = new boolean[n];
			int[] max = new int[n];
			
			int maxval=0;

			while (true) {
				int i = -1;
				for (int x = 0; x < n; x++) {
					if ((!visited[x]) && degrees[x] == 0) {
						i = x;
						break;
					}
				}

				if (i == -1) {
					break;
				}

				visited[i] = true;

				for (int j = 0; j < n; j++) {
					if (adjmat[j][i]) {
						adjmat[j][i] = false;
						degrees[j]--;
						max[j] = Math.max(max[j], max[i] + 1);
						maxval=Math.max(max[j], maxval);
					}
				}

			}
			
			System.out.println(maxval+1);
		}
		s.close();
	}

	static boolean smaller(int a, int b, int c, int d) {
		return (a < c && b < d) || (b < c && a < d);
	}

}
