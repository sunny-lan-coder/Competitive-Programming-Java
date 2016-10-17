package duwei.tmp;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Gendat {

	public static void main(String[] args) throws IOException {
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File("test1.in")));
		out.write((""+100000 + " ").getBytes());
		out.write((""+1000+"\r\n").getBytes());
		Random rng = new Random();
		out.write((""+6+"").getBytes());
		for (int i = 0; i < 99999; i++) {
			out.write((" 666").getBytes());
			if (i % 10 == 0)
				out.flush();
		}
		out.write("\r\n".getBytes());
		for (int i = 0; i < 1000; i++) {
			int val = 6;
			System.out.println(i + ":" + val);
			out.write((""+val+"\r\n").getBytes());
			out.flush();

		}
		out.write("\r\n".getBytes());
	}

}
