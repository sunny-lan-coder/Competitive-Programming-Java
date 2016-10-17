package wcipeg.woburn;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class wc161s2 {

	static HashMap<Integer, HashMap<Integer, Integer>> adjlist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int k = Integer.parseInt(tmp[1]);
		int[] degrees = new int[n];
		adjlist = new HashMap<Integer, HashMap<Integer, Integer>>();
		for (int i = 0; i < n - 1; i++) {
			tmp = br.readLine().split(" ");
			int a = Integer.parseInt(tmp[0]) - 1;
			int b = Integer.parseInt(tmp[1]) - 1;
			int m = Integer.parseInt(tmp[2]);
			degrees[a]++;
			degrees[b]++;
			add(a, b, m);
		}
		boolean[] item = new boolean[n];
		for (int i = 0; i < k; i++) {
			int c = Integer.parseInt(br.readLine()) - 1;
			item[c] = true;
		}
		br.close();
		Queue<Integer> next = new LinkedList<>();
		for (int i = 0; i < n; i++) {
//			System.out.println(degrees[i]);
			
			if (degrees[i] == 1 && !item[i] && i!=0){
				next.add(i);
			}
		}
		while (!next.isEmpty()) {
			Integer i = next.remove();
			for (int j : adjlist.get(i).keySet()) {

					degrees[j]--;
					degrees[i]--;
					adjlist.get(j).remove(i);
					adjlist.get(i).remove(j);

					if (degrees[j] == 1 && !item[j] && j!=0) {
//					System.out.println(i + "x" + j);
					next.add(j);
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (adjlist.containsKey(i)) {
				for (int j : adjlist.get(i).keySet()) {
					sum += adjlist.get(i).get(j);
					adjlist.get(j).remove(i);
				}
			}
		}

		System.out.println(sum);

	}

	static void add(int a, int b, int m) {
		if (!adjlist.containsKey(a))
			adjlist.put(a, new HashMap<Integer, Integer>());
		if (!adjlist.containsKey(b))
			adjlist.put(b, new HashMap<Integer, Integer>());
		adjlist.get(a).put(b, m);
		adjlist.get(b).put(a, m);
	}

}
