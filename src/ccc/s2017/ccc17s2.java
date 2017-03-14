package ccc.s2017;
import java.util.Arrays;
import java.util.Scanner;

public class ccc17s2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		s.close();
		Arrays.sort(arr);
		int a,b;
		if(n%2==0){
			a=n/2-1;
			b=n/2;
			while(a>=0){
				System.out.print(arr[a]+" ");
				a--;
				System.out.print(arr[b]+" ");
				b++;
			}
			System.out.println();
		}else{
			a=n/2;
			b=n/2+1;
			while(a>0){
				System.out.print(arr[a]+" ");
				a--;
				System.out.print(arr[b]+" ");
				b++;
			}
			System.out.println(arr[0]);
			
		}
		
		
		
	}

}
