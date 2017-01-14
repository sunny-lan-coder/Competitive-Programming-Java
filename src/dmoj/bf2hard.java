package dmoj;

import java.util.Scanner;

public class bf2hard {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		int k = s.nextInt();
		s.close();
		String min = "";
		for (int i = 0; i < k; i++) {
			min += 'z';
		}
		
		for (int i = 0; i < input.length(); i++) {
			String curr = input.substring(i, i + k);
//			System.out.println(curr);
			if (min.compareTo(curr) >0){

				min = curr;
			}
		}
		System.out.println(min);
	}

}
