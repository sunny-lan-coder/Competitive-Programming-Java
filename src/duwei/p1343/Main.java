package duwei.p1343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static long fastPow(int p, int n){
		long res=1;
		long curr=n;
		while(p>0){
			if((p&1)==1){
				res*=curr;
			}
			curr*=curr;
			p=p>>1;
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int m=Integer.parseInt(br.readLine());
		String[] tmp;
		for(int i=0;i<m;i++){
			tmp=br.readLine().split(" ");
			int n=Integer.parseInt(tmp[0]);
			int p=Integer.parseInt(tmp[1]);
			System.out.println(fastPow(p, n));
		}
		br.close();
	}

}
