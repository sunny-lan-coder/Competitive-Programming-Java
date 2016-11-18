package dmoj.tle;

import java.util.Random;
import java.util.Scanner;

public class tle16c3p4 {

	static int n;
	static int m;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		s.close();
		if(n*m%2==1){
			System.out.println("First");
		}else{
			System.out.println("Second");
		}
	}

	
}
