package wcipeg;

import java.util.Scanner;

public class dmopc16c1p1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int count=0;
		for(int i=0;i<n;i++){
			int val=s.nextInt();
			if(val%2==i%2)
				count++;
		}
		s.close();
		
		System.out.println(count);
	}

}
