package duwei.p1341;

import java.util.Random;
import java.util.Scanner;

public class Gen {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=10000;
		int lim=1000000;
		Random rng=new Random();
		int target=rng.nextInt(lim*2)-lim;
		System.out.print(m+" "+target);
		System.out.println();
		for(int i=0;i<m;i++)
		System.out.print(rng.nextInt(lim*2)-lim+" ");
		System.out.println();
		s.close();
	}

}
