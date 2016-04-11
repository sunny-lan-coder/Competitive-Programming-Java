package hackerank;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] line = s.nextLine().split(" ");
		BigInteger a = new BigInteger(line[0]);
		BigInteger b = new BigInteger(line[1]);
		BigInteger n = new BigInteger(line[2]);
		s.close();
		BigInteger iterations = n.add(BigInteger.valueOf(-2));
		BigInteger c = null;
		for (BigInteger i = BigInteger.ZERO; i.compareTo(iterations) < 0; i.add(BigInteger.ONE)) {
			c = b.multiply(b).add(a);
			a = b;
			b = c;
		}
		System.out.println(c);
	}

}
