package duwei;

import java.util.Scanner;

public class P1247 {

	public static void main(String[] args) {
		final String map="abcdefghijklmnopqrstuvwxyz";
		Scanner s = new Scanner(System.in);
		int n1 = s.nextInt();
		int[] a = new int[n1];
		for (int i = 0; i < n1; i++) {
			String tmp = s.next().toLowerCase();
			for(int j=0;j<tmp.length();j++){
				a[i]|=1<<map.indexOf(tmp.charAt(j));
			}
		}
		int n2 = s.nextInt();
		int[] b = new int[n2];
		for (int i = 0; i < n2; i++) {
			String tmp = s.next().toLowerCase();
			for(int j=0;j<tmp.length();j++){
				b[i]|=1<<map.indexOf(tmp.charAt(j));
			}
		}
		s.close();
//		System.out.println(Integer.toBinaryString(((1<<26)-1)));
		int cnt=0;
		for(int i=0;i<n1;i++){
			for(int j=0;j<n2;j++){
//				System.out.println(Integer.toBinaryString(a[i])+"|"+Integer.toBinaryString(b[j])+"="+Integer.toBinaryString(a[i]|b[j]));
				if((a[i]|b[j])==((1<<26)-1)){
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
