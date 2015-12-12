package wcipej.woburn;

import java.util.Scanner;

public class wc152j1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N=s.nextInt();
		String derp="A long time ago in a galaxy ";
		for(int i=1;i<N;i++){
			derp=derp+"far, ";
		}
		derp=derp+"far away...";
		System.out.println(derp);
		s.close();
	}

}
