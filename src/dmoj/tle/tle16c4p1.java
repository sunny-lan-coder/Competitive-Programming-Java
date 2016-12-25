package dmoj.tle;

import java.util.Arrays;
import java.util.Scanner;

public class tle16c4p1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] w = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = s.nextInt();
		}
		s.close();
		Arrays.sort(w);
		int sum=0;
		int count=0;
		for(int i=0;i<n;i++){
			if(w[i]>=sum){
				sum+=w[i];
				count++;
			}
		}
		System.out.println(count);
	}

}
