package classq;

public class ContestSim {

	static char[] s = { 'A', 'B', 'C', 'D', 'E', 'F' };
	static boolean[] visited;

	public static void main(String[] args) {
		visited = new boolean[6];
		r = new char[6];
		for(char f:s){
			boolean a = f == 'A' || f == 'B';
			boolean b = f != 'C';
			boolean c = f != 'D' && f != 'E' && f != 'F';
			boolean d = f == 'D' || f == 'E' || f == 'F';
			boolean [] derp={a,b,c,d};
			
			int tc=0;
			for(int i=0;i<4;i++){
				if(derp[i])tc++;
			}
			if(tc==1)
				System.out.println(tc);
		}
//		permutation();
	}

	static int rip = 0;
	static char[] r;

	static void permutation() {
		if (rip >= 5) {
//			char f = r[0];
//			boolean a = f == 'A' || f == 'B';
//			boolean b = f != 'C';
//			boolean c = f != 'D' && f != 'E' && f != 'F';
//			boolean d = f == 'D' || f == 'E' || f == 'F';
//			boolean [] derp={a,b,c,d};
//			
//			int tc=0;
//			for(int i=0;i<4;i++){
//				if(derp[i])tc++;
//			}
//			if(tc==1)
//				System.out.println(tc);
		}
		for (int i = 0; i < 6; i++) {
			if (!visited[i]) {
				r[rip] = s[i];
				rip++;
				permutation();
				rip--;
			}
		}
	}

}
