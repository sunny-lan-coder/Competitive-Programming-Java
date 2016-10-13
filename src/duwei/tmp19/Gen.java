package duwei.tmp19;

import java.util.Random;

public class Gen {
	public static void main(String[] args) {
		Random rng = new Random();
		String map = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < 50000; i++) {
			int len = rng.nextInt(20) + 1;
			String str="";
			for (int j = 0; j < len; j++) {
				str+=map.charAt(rng.nextInt(26));
			}
			System.out.println(str);
		}
	}
}
