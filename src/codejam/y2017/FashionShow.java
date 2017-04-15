package codejam.y2017;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.File;
import java.util.Scanner;

public class FashionShow {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s;
//		s= new Scanner(new File("-small-attempt0.in"));
		s=new Scanner(System.in);
		PrintStream out;
//		out = new PrintStream("_small_output.txt");
		out=System.out;
		int t = s.nextInt();
		for (int test = 1; test <= t; test++) {
			
			out.println("Case #" + test + ": " );
		}
		s.close();
		out.close();
	}

}
