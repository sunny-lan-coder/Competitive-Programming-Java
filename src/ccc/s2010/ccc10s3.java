package ccc.s2010;

import java.util.Arrays;
import java.util.Scanner;

public class ccc10s3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] h = new int[n];
		for (int i = 0; i < n; i++) {
			h[i] = s.nextInt();
		}
		int k=s.nextInt();
		s.close();
		Arrays.sort(h);
		int low=0;
		int high=1000000;
		int res=1000000;
		while(low<=high){
			int guess=(low+high)/2;
			
			int guessneeded=1;
			int hydrant=h[0]+guess;
			int hydrant1=hydrant;
			for(int i=1;i<n;i++){
				if(Math.abs(h[i]-hydrant)>guess && Math.abs(h[i]-hydrant1)>guess){
					guessneeded++;
					hydrant=h[i]+guess;
				}
			}
			
			if(guessneeded>k){
				low=guess+1;
			}else{
				high=guess-1;
				res=Math.min(guess, res);
			}
			
		}
		
		System.out.println(res);
	}

}
