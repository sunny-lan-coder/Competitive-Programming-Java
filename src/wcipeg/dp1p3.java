package wcipeg;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class dp1p3 {
	static int N;
	static int[] V;
	static Map<Pair<Integer, Integer>, Integer> dp;
	
	static class Pair<L,R> {

		  private final L left;
		  private final R right;

		  public Pair(L left, R right) {
		    this.left = left;
		    this.right = right;
		  }

		  public L getLeft() { return left; }
		  public R getRight() { return right; }

		  @Override
		  public int hashCode() { return left.hashCode() ^ right.hashCode(); }

		  @Override
		  public boolean equals(Object o) {
		    if (!(o instanceof Pair)) return false;
		    Pair pairo = (Pair) o;
		    return this.left.equals(pairo.getLeft()) &&
		           this.right.equals(pairo.getRight());
		  }

		}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		V = new int[N];
		dp =new HashMap<>();
		for (int i = 0; i < N; i++) {
			V[i] = s.nextInt();
		}
		s.close();

		
		
		System.out.println(f(0,-1));
	}

	static int f(int i, int j){
		Pair<Integer, Integer> p=new Pair<>(i,j);
		if(i==N)
			return 0;
		if(!dp.containsKey(p)){
			int result=f(i+1,j);
			
			if(V[i]>j){
				result=Math.max(result, f(i+1,V[i])+1);
			}
			
			dp.put(p, result);
			return result;
		}
		return dp.get(p);
	}

}
