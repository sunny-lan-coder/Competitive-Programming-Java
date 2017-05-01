package dmoj.dmopc;

import java.util.Scanner;

public class dmopc16c1p0 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int W=s.nextInt();
		int C=s.nextInt();
		s.close();
		if(W==3 && C>=95)
		{
			System.out.println("C.C. is absolutely satisfied with her pizza.");
			return;
		}
		if(W==1 && C<=50){
			System.out.println("C.C. is fairly satisfied with her pizza.");
			return;
		}
		System.out.println("C.C. is very satisfied with her pizza.");
	}

}
