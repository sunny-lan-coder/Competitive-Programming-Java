package uva;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P109 {

	static class Point {
		public final int x;
		public final int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int orientation(int x1, int y1, int x2, int y2, int x3, int y3)
	{
		 // See 10th slides from following link for derivation
	    // of the formula
	    int val = (y2 - y1) * (x3 - x2) -
	              (x2 - x1) * (y3 - y2);
	 
	    if (val == 0) return 0;  // colinear
	 
	    return (val > 0)? -1: 1; // clock or counterclock wise
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n;

		while ((n = s.nextInt()) != -1) {
			Integer[] idxs=new Integer[n];
			int[] x=new int[n];
			int[] y=new int[n];
			int min=0;
			for(int i=0;i<n;i++){
				x[i]=s.nextInt();
				y[i]=s.nextInt();
				idxs[i]=i;
				if(y[i]<y[min] || (y[i]==y[min]&& x[i]<x[min])){
					min=i;
				}
			}
			idxs[0]=min;
			idxs[min]=0;
			final int tmp=min;
			Arrays.sort(idxs,1,n, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return orientation(x[o1],y[o1],x[tmp],y[tmp],x[o2],y[o2]);
				}
			});
			
			int ptr=1;
			for(int i=1;i<n;i++){
				
			}
			
			
		}
		
		

		while (s.hasNext()) {
			int x = s.nextInt();
			int y = s.nextInt();
		}

		s.close();
	}

}
