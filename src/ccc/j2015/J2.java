package ccc.j2015;

import java.util.Scanner;

public class J2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		int happy=count(str,":-)");
		int sad=count(str,":-(");
		if(happy==0&&sad==0){
			System.out.println("none");
		}
		else if(happy==sad){
			System.out.println("unsure");
		}else if(happy>sad){
			System.out.println("happy");
		}else if(sad>happy){
			System.out.println("sad");
		}
		s.close();
	}
	
	  private static int count(final String string, final String substring)
	  {
	     int count = 0;
	     int idx = 0;

	     while ((idx = string.indexOf(substring, idx)) != -1)
	     {
	        idx++;
	        count++;
	     }

	     return count;
	  }

}
