package wcipeg;

import java.util.Scanner;

public class dp1p3two {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] V = new int[N];
		int[] dp =new int[N+1];
		for (int i = 0; i < N; i++) {
			V[i] = s.nextInt();
		}
		s.close();

		dp[0]=1;
		
		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++){
				if(V[j]>V[N]){
					dp[j]=Math.max(dp[j],dp[i]+1);
				}else{
					dp[j]=dp[i];
				}
			}
		}
		
		System.out.println(dp[N]);
	}

}
