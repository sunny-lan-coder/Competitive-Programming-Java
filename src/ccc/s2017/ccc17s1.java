package ccc.s2017;
import java.util.Scanner;

public class ccc17s1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		int[] swift=new int[n];
		int[] sema=new int[n];
		for(int i=0;i<n;i++){
			swift[i]=s.nextInt();
		}
		for(int i=0;i<n;i++){
			sema[i]=s.nextInt();
		}
		s.close();
		int sum1=0;
		int sum2=0;
		int maxk=0;
		for(int k=0;k<n;k++){
			sum1+=swift[k];
			sum2+=sema[k];
//			System.out.println("sum1="+sum1);
//			System.out.println("sum2="+sum2);
			if(sum1==sum2)
				maxk=k+1;
		}
		System.out.println(maxk);
	}
}
