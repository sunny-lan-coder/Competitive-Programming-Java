package wcipeg.woburn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class wc154s1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		int[] H = new int[N];
		for (int i = 0; i < N; i++) {
			H[i] = Integer.parseInt(br.readLine());
		}
		int[] D = new int[M];
		for (int i = 0; i < M; i++) {
			D[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(H);
		Arrays.sort(D);

		int man = 0;
		int door = 0;
		int count = 0;
		while (man < N && door < M) {
			System.out.print("door "+door+" at "+D[door]+", man "+man+" at"+H[man]);
			if (H[man] < D[door]) {
				count++;
				man++;
				System.out.println(" still, man "+man+" killed "+count);
			} else {
				door++;
				System.out.println(" none, door "+man+" killed "+count);
				System.out.println(count);
			}
		}
	}

}
