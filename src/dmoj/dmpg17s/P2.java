package dmoj.dmpg17s;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class P2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> nums=new ArrayList<>();
		String[] tmp=br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			nums.add( Integer.parseInt(tmp[i]));
		}
		Collections.sort(nums);
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++) {
			min = Math.min(min, Math.abs(nums.get(i) - nums.get(i - 1)));
		}
		System.out.println(min);
	}

}
