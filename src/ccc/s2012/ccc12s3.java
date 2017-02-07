package ccc.s2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class ccc12s3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] freq = new int[1000];
		for (int i = 0; i < n; i++) {
			freq[Integer.parseInt(br.readLine()) - 1]++;
		}
		br.close();
		ArrayList<Integer> bestR = new ArrayList<>();
		int max = 0;
		for (int i = 0; i < 1000; i++) {
			if (freq[i] == max)
				bestR.add(i + 1);
			if (freq[i] > max) {
				max = freq[i];
				bestR = new ArrayList<>();
				bestR.add(i + 1);
			}
		}

		ArrayList<Integer> prevBestR = new ArrayList<>();
		int max2 = 0;
		for (int i = 0; i < 1000; i++) {
			if (freq[i] >= max)
				continue;
			if (freq[i] == max2)
				prevBestR.add(i + 1);
			if (freq[i] > max2) {
				max2 = freq[i];
				prevBestR = new ArrayList<>();
				prevBestR.add(i + 1);
			}
		}
		if (bestR.size() == 2) {
			System.out.println(Math.abs(bestR.get(0) - bestR.get(bestR.size() - 1)));
			return;
		}

		if (prevBestR.isEmpty()) {
			System.out.println(Math.abs(bestR.get(0) - bestR.get(bestR.size() - 1)));
			return;
		}

		prevBestR.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1, o2);
			}
		});
		bestR.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1, o2);
			}
		});

		System.out.println(Math.max(Math.abs(bestR.get(bestR.size() - 1) - prevBestR.get(0)),
				Math.abs(prevBestR.get(prevBestR.size() - 1) - bestR.get(0))));

	}

}
