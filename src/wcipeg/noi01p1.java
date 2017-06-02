package wcipeg;

public class noi01p1 {
	
	static int[] cities;
	
	static int find(int city){
		if(cities[city]==city)
			return city;
		cities[city]=find(cities[city]);
		return cities[city];
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
