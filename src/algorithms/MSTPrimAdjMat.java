package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class MSTPrimAdjMat {

	static int[] mst(int n, int[][] adj) {
		boolean[] visited = new boolean[n];
		int[] du = new int[n];
		int[] src = new int[n];
		for (int i = 0; i < n; i++) {
			du[i] = Integer.MAX_VALUE;
		}
		du[0]=0;
		while (true) {
			int minnode = -1;
			int minval = -1;
			for (int i = 0; i < n; i++) {
				if (!visited[i] && (du[i] < minval || minval == -1)) {
					minval = du[i];
					minnode = i;
				}
			}

			if (minnode == -1)
				return src;

			visited[minnode] = true;

			for (int i = 0; i < n; i++) {
				if ( adj[minnode][i] != -1) {
					if (adj[minnode][i] < du[i]) {
						du[i] =  adj[minnode][i];
						src[i] = minnode;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[][] adj=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				adj[i][j]=-1;
			}
		}
		while(s.hasNext()){
			int i=s.nextInt();
			int j=s.nextInt();
			int k=s.nextInt();
				adj[i][j]=k;
				adj[j][i]=k;
			
		}
		s.close();
		System.out.println(Arrays.toString(mst(n,adj)));
	}

}
