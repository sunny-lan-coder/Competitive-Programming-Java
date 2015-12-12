package ccc.junior.y2015;

import java.util.Scanner;

public class J2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		int happy = 0;
		int sad = 0;
		for (int i = 0, j = i + 3; j <= input.length(); i++, j++) {
			String sub = input.substring(i, j);
			switch (sub) {
			case ":-)":
				happy++;
				break;
			case ":-(":
				sad++;
				break;
			}
		}
		if(happy==0&&sad==0){
			System.out.println("none");
		}else if(happy==sad){
			System.out.println("unsure");
		}else if(happy>sad){
			System.out.println("happy");
		}else{
			System.out.println("sad");
		}
		s.close();
	}

}
