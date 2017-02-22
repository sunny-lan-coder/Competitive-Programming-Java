package ccc.s2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc15s2 {

	static BufferedReader br;
	static String[] tmp;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int j=readInt();
		int a=readInt();
		int[] js=new int[j];
		for(int i=0;i<j;i++){
			String s=br.readLine();
			switch(s){
			case "M":
				js[i]=1;
				break;
			case "S":
				js[i]=0;
				break;
			case "L":
				js[i]=2;
				break;
			}
		}
		boolean[] visited=new boolean[j];
		int cnt=0;
		for(int i=0;i<a;i++){
			splitRead();
			int sz=-1;
			switch(tmp[0]){
			case "M":
				sz=1;
				break;
			case "S":
				sz=0;
				break;
			case "L":
				sz=2;
				break;
			}
			
			int jnum=Integer.parseInt(tmp[1])-1;
			
			if(!visited[jnum]){
				if(js[jnum]>=sz){
					visited[jnum]=true;
					cnt++;
				}
			}
		}
		br.close();
		System.out.println(cnt);
	}

	static int readInt() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static long readLong() throws IOException {
		return Long.parseLong(br.readLine());
	}

	static void splitRead() throws IOException {
		tmp = br.readLine().split(" ");
	}
}
