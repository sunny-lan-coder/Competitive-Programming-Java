package duwei.tmp8;

import java.util.Random;

public class Gendat {

	public static void main(String[] args) {
		Random rng=new Random();
		System.out.println(10000);
		for(int i=0;i<=10000;i++){
			int n=rng.nextInt(10)+10;
			String s="";
			for(int k=0;k<n;k++){
				s+=rng.nextInt(10);
			}
			System.out.print(s+" ");
			System.out.println(rng.nextInt(n));
		}
	}

}
