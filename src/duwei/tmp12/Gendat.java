package duwei.tmp12;

import java.util.Random;

public class Gendat {

	public static void main(String[] args) {
		System.out.println(9);
		Random rng=new Random();
		for(int i=0;i<20;i++){
			System.out.println(1000);
			
			for(int j=0;j<1000;j++){
				System.out.println(rng.nextInt(100)+" "+rng.nextInt(100));
			}
		}
	}

}
