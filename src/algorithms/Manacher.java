package algorithms;

import java.util.Scanner;

public class Manacher {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String q=s.next();
		//add word bounds, will never go out
		q="$"+q;
		String str="";
		//padd string to handle even length palindromes
		for(int i=0;i<q.length();i++){
			str+=q.charAt(i)+"#";
		}
		str+="^";
		int n=str.length();
		int[] l=new int[n];
		int c=0;
		int r=0;
		for(int i=1;i<n-1;i++){
			//if current check is inside known bounds
			if(i<r)
				l[i]=Math.min(r-i, l[2*c-i]);//mirror other side, but limit to known palindrome size
			
			//check around already known palindrome
			while(str.charAt(i+l[i]+1)==str.charAt(i-(l[i]+1)))
					l[i]++;
			
			//if current palindrome extends past, then update
			if(i+l[i]>r){
				c=i;
				r=i+l[i];
			}
		}
		s.close();
		System.out.println(str.substring(c-(r-c), r).replace("#", ""));
	}

}
