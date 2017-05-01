package dmoj.tle;

import java.util.Scanner;

public class tle16c8p1 {

	public static void main(String[] args) {
//		String map="ABCDEF";
		Scanner s=new Scanner(System.in);
		String t=s.next();
//		boolean[] has=new boolean[6];
//		for(int i=0;i<t.length();i++)
//			has[map.indexOf(t.charAt(i))]=true;
		int n=s.nextInt();
		outer: for(int i=0;i<n;i++){
			String p=s.next();
			for(int j=1;j<t.length();j++)
				if(!p.contains(t.charAt(j)+""))
				{
					System.out.println("no");
					continue outer;
				}
			System.out.println("yes");
		}
		s.close();
	}

}
