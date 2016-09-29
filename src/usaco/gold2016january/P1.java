package usaco.gold2016january;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class P1 {

	public static void main(String[] args) throws IOException {
		PrintStream out = System.out;// new PrintStream(new
										// FileOutputStream(".out"));
		InputStream in = System.in;// new FileInputStream(".in");
		Scanner s = new Scanner(in);
		//BufferedReader br=new BufferedReader(new InputStreamReader(in));
		//read input
		int n=s.nextInt();
		int[] bales=new int[n];
		for(int i=0;i<n;i++){
			bales[i]=s.nextInt();
		}
		s.close();
		//br.close();
		Arrays.sort(bales);
		int[] leftmin=new int[n];
		leftmin[0]=0;
		for(int i=1;i<n;i++){
			
		}
		//process
		out.close();
	}

}
