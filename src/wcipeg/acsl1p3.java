package wcipeg;

import java.math.BigInteger;

public class acsl1p3 {

	public static void main(String[] args) {
		BigInteger product=BigInteger.ONE;
		for (int n = 1; n <= 1001; n++) {
			product=product.multiply(BigInteger.valueOf(n));
			
		}
		String six=product.toString();
		System.out.println(six);
		
	}
}
