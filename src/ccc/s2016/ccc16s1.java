package ccc.s2016;

import java.util.Scanner;

public class ccc16s1 {

	public static void main(String[] args) {
		String map="abcdefghijklmnopqrstuvwxyz";
		Scanner s = new Scanner(System.in);
		String a=s.nextLine();
		String b=s.nextLine();
		
		s.close();
		int n=a.length();
		int[] cnt=new int[26];
		int wild=0;
		for(int i=0;i<n;i++){
			cnt[map.indexOf(a.charAt(i)+"")]++;
			int idx=map.indexOf(b.charAt(i)+"");
			
			if(idx==-1)
				wild++;
			else
				cnt[idx]--;
		}
		
		int err=0;
		for(int i=0;i<26;i++){
			if(cnt[i]>0)
				err+=cnt[i];
			else if(cnt[i]<0)
			{
				System.out.println("N");
				return;
			}
		}
		
		if(err==wild)
			System.out.println("A");
		else
			System.out.println("N");
	}
}
