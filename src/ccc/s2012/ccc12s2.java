package ccc.s2012;

import java.util.Scanner;

public class ccc12s2 {

	public static void main(String[] args) {
		int[] roman={1,5,10,50,100,500,1000};
		String map="IVXLCDM";
		Scanner s=new Scanner(System.in);
		String num=s.nextLine();
		s.close();
		int len=num.length();
		int n=len/2;
		int[] a=new int[n];
		int[] r=new int[n];
		for(int i=0;i<n;i++){
		
				a[i]=Integer.parseInt(num.charAt(i*2)+"");
			
				r[i]=roman[map.indexOf(num.charAt(i*2+1))];
		}
		
		int res=0;
		for(int i=0;i<n-1;i++){
			if(r[i]<r[i+1])
				res-=a[i]*r[i];
			else
				res+=a[i]*r[i];
		}
		res+=a[n-1]*r[n-1];
		
		System.out.println(res);
	}

}
