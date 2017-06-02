package bssjudge;

import java.util.Scanner;

public class bsspc17p1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String a=s.nextLine();
		String b=s.nextLine();
		s.close();
		if(a.length()>b.length())
			System.out.println(a);
		else
			System.out.println(b);
	}

}
