package ccc.junior.y2015;

import java.util.Scanner;

public class J1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int month=s.nextInt();
		int day=s.nextInt();
		if(month<2){
			System.out.println("Before");
		}else if(month==2){
			if(day<18){
				System.out.println("Before");
			}else if(day>18){
				System.out.println("After");
			}else{
				System.out.println("Special");
			}
		}else{
			System.out.println("After");
		}
		s.close();
	}

}
