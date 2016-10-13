package duwei.tmp5;

public class Main {

	public static void main(String[] args) {
		boolean[] yellow=new boolean[101];
		for(int i=0;i<=100;i+=2){
			yellow[i]=!yellow[i];
		}
		for(int i=0;i<=100;i+=3){
			yellow[i]=!yellow[i];
		}
		int count=0;
		for(int i=1;i<=100;i++){
			if(!yellow[i])
				count++;
		}
		System.out.println(count);
	}

}
