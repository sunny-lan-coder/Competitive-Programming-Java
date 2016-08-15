package dmoj;

import java.util.Scanner;

public class anoisyclass {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		boolean[][] adj = new boolean[n][n];// [from][to]
		int[] degrees = new int[n];
		for (int i = 0; i < m; i++) {
			int noise = s.nextInt() - 1;
			int dist = s.nextInt() - 1;
			if(noise==dist)
				continue;
			if(adj[noise][dist])
				continue;
			adj[noise][dist] = true;
			degrees[dist]++;
		}
		s.close();

		boolean[] visited = new boolean[n];
		while (true) {
			// find degree 0
			int i = -1;
			for (int x = 0; x < n; x++) {
				if (degrees[x] != 0 || visited[x]) {
					if (!visited[x])
						i = -2;
				} else {
					i = x;
					break;
				}
			}
//			System.out.println(i);

			if (i == -1) {
				System.out.println("Y");
				break;
			} else if (i == -2) {
				System.out.println("N");
				break;
			}
			
			for(int j=0;j<n;j++){
				if(adj[i][j]){
					adj[i][j]=false;
					degrees[j]--;
				}
			}
			
			visited[i]=true;
		}
	}

}
