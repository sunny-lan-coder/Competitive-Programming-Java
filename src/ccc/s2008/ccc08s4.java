package ccc.s2008;

import java.util.Scanner;

public class ccc08s4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			int c1 = s.nextInt();
			int c2 = s.nextInt();
			int c3 = s.nextInt();
			int c4 = s.nextInt();
			int sum1 = c1;
			int max = Integer.MIN_VALUE;
			for (int op1 = 0; op1 < 4; op1++) {
				int sum2 = sum1;
				switch (op1) {
				case 0:
					sum2 += c2;
					break;
				case 1:
					sum2 -= c2;
					break;
				case 2:
					sum2 *= c2;
					break;
				case 3:
					if (sum2 % c2 == 0)
						sum2 /= c2;
					else
						continue;
					break;
				}
				for (int op2 = 0; op2 < 4; op2++) {
					int sum3 = sum2;
					switch (op2) {
					case 0:
						sum3 += c3;
						break;
					case 1:
						sum3 -= c3;
						break;
					case 2:
						sum3 *= c3;
						break;
					case 3:
						if (sum3 % c3 == 0)
							sum3 /= c3;
						else
							continue;
						break;
					}
					for (int op3 = 0; op3 < 4; op3++) {
						int sum4 = sum3;
						switch (op3) {
						case 0:
							sum4 += c4;
							break;
						case 1:
							sum4 -= c4;
							break;
						case 2:
							sum4 *= c4;
							break;
							
						case 3:
							if (sum4 % c4 == 0)
								sum4 /= c4;
							else
								continue;
							break;
						}
						if (sum4 <= 24){
							System.out.println(""+c1+","+op1+" "+c2+","+op2+" "+c3+","+op3+" "+c4+"="+sum4);
							max = Math.max(max, sum4);
						}
					}
				}
			}
			System.out.println(max);
		}
		s.close();
	}

}
