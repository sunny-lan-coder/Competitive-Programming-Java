package ecoo;

import java.util.Scanner;

public class ecoo16r3p1 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		for(int t=0;t<10;t++){
			int n=in.nextInt();
			int s=in.nextInt();
			
			int count=0;
			int a=1;
			int b=1;
			
			while(a!=n*b){
				a*=s;
				b*=s-1;
				count++;
			}
			count+=s;
			
			System.out.println(count);
		}
		in.close();
	}

}
