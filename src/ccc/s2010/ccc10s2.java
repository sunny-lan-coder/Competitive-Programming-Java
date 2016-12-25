package ccc.s2010;

import java.util.HashMap;
import java.util.Scanner;

public class ccc10s2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int k=s.nextInt();
		HashMap<String, String> mapping=new HashMap<>();
		for(int i=0;i<k;i++){
			String ch=s.next();
			String res=s.next();
			mapping.put(res, ch);
		}
		String d=s.next();
		int n=d.length();
		s.close();
		String curr="";
		for(int i=0;i<n;i++){
			curr+=d.charAt(i);
			if(mapping.containsKey(curr)){
				System.out.print(mapping.get(curr));
				curr="";
			}
		}
		System.out.println();
	}

}
