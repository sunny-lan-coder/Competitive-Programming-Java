package spoj;

import java.util.Scanner;

public class PHONELST {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		outer: for (int testCase = 0; testCase < t; testCase++) {
			int n = s.nextInt();
			String[] phoneNums = new String[n];
			for (int phoneNumIdx = 0; phoneNumIdx < n; phoneNumIdx++) {
				String phoneNum = s.next();
				phoneNums[phoneNumIdx]=phoneNum;
				for (int i = 0; i < phoneNumIdx; i++) {
					if (phoneNum.length() > phoneNums[i].length()) {
						if (phoneNum.startsWith(phoneNums[i])) {
							System.out.println("NO");
							continue outer;
						}
					}
				}
			}
			System.out.println("YES");
		}
		s.close();
	}

}
