package ccc.j2012;

import java.util.Scanner;

public class J2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		int b=s.nextInt();
		int c=s.nextInt();
		int d=s.nextInt();
		s.close();
		if(d>c && c>b && b>a)
			System.out.println("Fish Rising");
		else if(a>b && b>c && c>d)
			System.out.println("Fish Diving");
		else if(a==b && b==c && c==d)
			System.out.println("Constant Depth");
		else
			System.out.println("No Fish");
	}

}
