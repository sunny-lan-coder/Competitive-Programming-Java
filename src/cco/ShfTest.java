package cco;

import java.util.Scanner;

public class ShfTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int rs = s.nextInt();
		int cs = s.nextInt();
		int[][] map = new int[rs][cs];
		for (int i = 0; i < rs; i++) {
			for (int j = 0; j < cs; j++) {
				map[i][j] = s.nextInt();
			}
		}
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			int op = s.nextInt();
			int j = s.nextInt()-1;
			int k = s.nextInt();
			String t="";
			if (op == 1) {
				t="right";
				int[] nrray = new int[cs];
				for (int a = 0; a < cs; a++) {
					nrray[(a + k) % cs] = map[j][a];
				}
				map[j] = nrray;
			} else {
				t="down";
				int[] nrray = new int[rs];
				for (int a = 0; a < rs; a++) {
					nrray[(a + k) % rs] = map[a][j];
				}
				for (int a = 0; a < rs; a++)
					map[a][j] = nrray[a];
			}
			System.out.println("shift "+j+" "+t+" by "+k);
//			for(int x=0;x<rs;x++){
				for(int y=0;y<cs;y++){
//					if(map[x][y]!=x*rs+y)
//						System.out.println("err at "+(x*cs+y));
					System.out.print(map[rs-1][y]+" ");
				}
				System.out.println();
//			}
		}
		s.close();
		for(int i=0;i<rs;i++){
			for(int j=0;j<cs;j++){
				if(map[i][j]!=i*cs+j)
					System.out.println("err at "+(i*cs+j));
//				System.out.print(map[i][j]+" ");
			}
		}
	}

}
