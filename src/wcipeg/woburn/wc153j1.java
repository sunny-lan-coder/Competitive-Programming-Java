package wcipeg.woburn;

import java.util.Scanner;

public class wc153j1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int AB=s.nextInt();
		int DB=s.nextInt();
		int AS=s.nextInt();
		int DS=s.nextInt();
		s.close();
		if(AB>DS && DB>AS){
			System.out.println("Batman");
		return;}
		if(DS>AB && AS>DB){
			System.out.println("Superman");
			return;
		}
		System.out.println("Inconclusive");
	}

}
