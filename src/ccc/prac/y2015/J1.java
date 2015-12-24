package ccc.prac.y2015;

import java.util.Scanner;

public class J1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		int d=s.nextInt();
		if(m<2){
			System.out.println("Before");
		}
		if(m>2){
			System.out.println("After");
		}
		if(m==2){
			if(d<18){
				System.out.println("Before");
			}
			if(d>18){
				System.out.println("After");
			}
			if(d==18){
				System.out.println("Special");
			}
		}
		s.close();
	}

}
