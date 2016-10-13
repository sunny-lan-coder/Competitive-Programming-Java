package duwei.tmp18;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String nstr=s.next();
		int k=s.nextInt();
		s.close();
		int n=Integer.parseInt(nstr, k);
		System.out.println(n);
	}

}
