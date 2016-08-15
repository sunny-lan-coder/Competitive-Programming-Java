package usaco.silver2015december;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class P1 {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream out = new PrintStream(new FileOutputStream("bcount.out"));
		InputStream in=new FileInputStream("bcount.in");
		Scanner s = new Scanner(in);
		int n = s.nextInt();
		int q = s.nextInt();
		int[] sum1 = new int[n + 1];
		int[] sum2 = new int[n + 1];
		int[] sum3 = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			sum1[i] = sum1[i - 1];
			sum2[i] = sum2[i - 1];
			sum3[i] = sum3[i - 1];
			switch (s.nextInt()) {
			case 1:
				sum1[i]++;
				break;
			case 2:
				sum2[i]++;
				break;
			case 3:
				sum3[i]++;
				break;
			}
		}
		
//		for(int i=1;i<=n;i++){
//			System.out.println("idx="+1+", s1="+sum1[i]+", s2="+sum2[i]+", s3="+sum3[i]);
//		}
		
		for (int i = 0; i < q; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			out.print(sum1[b]-sum1[a-1]);
			out.print(" ");
			out.print(sum2[b]-sum2[a-1]);
			out.print(" ");
			out.println(sum3[b]-sum3[a-1]);
		}
		s.close();
		out.close();
	}

}
