package duwei.tmp17;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		long n=s.nextLong();
		int m=s.nextInt();
		s.close();
		
		long bit4=0;
		long bit1=0;
		long bit2=0;
		long bit3=0;
		int count=0;
		for(int i=0;i<m;i++){
			bit4=bit3;
			bit3=bit2;
			bit2=bit1;
			bit1=n&1;
			if(bit1==0 && bit2==1 && bit3==1 && bit4==0){
				count++;
			}
			n=n>>1;
		}
		
		bit4=bit3;
		bit3=bit2;
		bit2=bit1;
		if(bit1==0 && bit2==1 && bit3==1 && bit4==0){
			count++;
		}
		
		System.out.println(count);
	}

}
