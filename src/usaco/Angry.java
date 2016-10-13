package usaco;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Angry
{
	public static void main(String[] args) throws FileNotFoundException
	{
		PrintWriter out=new PrintWriter(new FileOutputStream("angry.out"));
		Scanner s=new Scanner(new FileInputStream("angry.in"));
		int n=s.nextInt();	
		int[] bale=new int[n];
		for(int i=0;i<n;i++){
			bale[i]=s.nextInt();
		}
		s.close();
		Arrays.sort(bale);
		int[] dpleft=new int[n];
		dpleft[0]=0;
		for(int i=1;i<n;i++){
			dpleft[i]=Math.max(dpleft[i-1]+1,Math.abs(bale[i-1]-bale[i]));
		}
		reverse(bale);
		int[] dpright=new int[n];
		dpright[0]=0;
		for(int i=1;i<n;i++){
			dpright[i]=Math.max(dpright[i-1]+1,Math.abs(bale[i-1]-bale[i]));
		}
		reverse(dpright);
		int min=0;
		for(int i=0;i+1<n;i++){
			if(Math.max(dpleft[min],dpright[min+1])>Math.max(dpleft[i],dpright[i+1])){
				min=i;
			}
		}
		NumberFormat formatter=new DecimalFormat("#0.0");
		out.println(formatter.format(Math.max(dpleft[min],dpright[min+1])+1));
		out.close();
	}
	static void reverse(int[] arr){
		int n=arr.length;
		for(int i=0;n-i>i;i++){
			int tmp=arr[i];
			arr[i]=arr[n-i -1];
			arr[n-i-1]=tmp;
		}
	}
}