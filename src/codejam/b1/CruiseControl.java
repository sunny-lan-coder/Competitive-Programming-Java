package codejam.b1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class CruiseControl {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s;
		s= new Scanner(new File("A-large.in"));
//		s=new Scanner(System.in);
		PrintStream out;
		out = new PrintStream("A_large_output.txt");
//		out=System.out;
		int t = s.nextInt();
		for (int test = 1; test <= t; test++) {
			int d=s.nextInt();
			int n=s.nextInt();
			double latest=-1;
			for(int i=0;i<n;i++){
				double k=s.nextInt();
				double m=s.nextInt();
				
				double timeArr=(d-k)/m;
//				System.out.println("horse "+i+" will arrive at "+timeArr);
				latest=Math.max(latest, timeArr);
			}
			out.println("Case #" + test + ": " +d/latest);
		}
		s.close();
		out.close();
	}

}
