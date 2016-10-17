package duwei.tmp2;

import java.util.Random;

public class Gendat {

	public static void main(String[] args) {
		Random rng=new Random();
		for(int t=1;t<=100;t++){
			System.out.println("100 100");
			for(int i=0;i<100;i++){
				for(int j=0;j<100;j++){
					if(rng.nextInt((t%4)+2)==0)
					{
						System.out.print('*');
					}else{
						System.out.print('@');
					}
					
				}
				System.out.println();
			}
		}
		System.out.println("0 0");
	}

}
