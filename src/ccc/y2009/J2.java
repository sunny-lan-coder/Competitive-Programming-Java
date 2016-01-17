package ccc.y2009;

import java.util.Scanner;

public class J2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int bt = s.nextInt();
		int np = s.nextInt();
		int yp = s.nextInt();
		int tp = s.nextInt();
		s.close();
		
		int count=0;
		
		for (int brown = 0; brown < 10000; brown++) {
			if (brown * bt > tp)
				break;
			for (int north = 0; north < 10000; north++) {
				if (north * np > tp)
					break;
				for (int yellow = 0; yellow < 10000; yellow++) {
					if (yellow * yp > tp)
						break;
					
					if(brown+north+yellow==0)
						continue;
					
					if(brown*bt+north*np+yellow*yp <=tp){
						System.out.println(brown+" Brown Trout, "+north+" Northern Pike, "+yellow+" Yellow Pickerel");
						count++;
					}
					
				}
			}
		}
		
		System.out.println("Number of ways to catch fish: "+count);
	}

}
