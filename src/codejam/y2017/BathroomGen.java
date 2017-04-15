package codejam.y2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class BathroomGen {

	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter out = new PrintWriter(new File("C_test.txt"));
		out.println("100");
		for (int i = 0; i < 100; i++)
			out.println("1000000 1000000");
		out.close();
	}

}
