package dmoj.tle;

import java.util.Scanner;

public class tle16c8p2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++){
			int n=s.nextInt();
			String bs=Integer.toBinaryString(n);
			for(int j=bs.length()-1;j>=0;j--){
				if(bs.charAt(j)=='1')
					System.out.print("dank ");
				else
					System.out.print("meme ");
			}
			System.out.println();
		}
		s.close();
	}

}
