package ccc.s2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int t=0;
		int s=0;
		for(int i=0;i<n;i++){
			String l=br.readLine();
			for(int j=0;j<l.length();j++){
				switch(l.charAt(j)){
				case 't':
				case 'T':
					t++;
					break;
				case 's':
				case 'S':
					s++;
					break;
				}
			}
		}
		br.close();
		if(t>s){
			System.out.println("English");
		}else{
			System.out.println("French");
		}
		
	}

}
