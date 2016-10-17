package duwei.tmp11;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[] v=new int[n];
		int sum=0;
		for(int i=0;i<n;i++){
			v[i]=s.nextInt();
			sum+=v[i];
		}
		int pile=sum/n;
		
		s.close();
	}

}
