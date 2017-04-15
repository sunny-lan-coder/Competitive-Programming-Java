package cco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class cco10p3_2 {
	static int[] init(int size) {
		return new int[4 * size];
	}

	static int update(int[] arr, int idx, int startIdx, int endIdx, int val, int currNode) {
		if (startIdx == endIdx) {
			arr[currNode] = val;
			return val;
		}

		int mid = middle(startIdx, endIdx);

		int sum;

		if (idx <= mid) {
			sum = update(arr, idx, startIdx, mid, val, currNode * 2 + 1) + arr[currNode * 2 + 2];
		} else {
			sum = update(arr, idx, mid + 1, endIdx, val, currNode * 2 + 2) + arr[currNode * 2 + 1];
		}

		arr[currNode] = sum;
		return sum;
	}

	static int middle(int startIdx, int endIdx) {
		return (startIdx + endIdx) >> 1;
	}

	static int findRight(int[] arr, int startIdx, int endIdx, int currNode, int val) {
		if (startIdx == endIdx) {
			return startIdx;
		}

		int mid = middle(startIdx, endIdx);
		int rightIdx = currNode * 2 + 2;
		
		if (arr[rightIdx] >= val) {
			return findRight(arr, mid + 1, endIdx, rightIdx, val);
		}

		val -= arr[rightIdx];
		return findRight(arr, startIdx, mid, currNode * 2 + 1, val);
	}

	public static void main(String[] args) throws IOException {
		long start=System.nanoTime();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> ratings = new ArrayList<>(n);
		char[] operations = new char[n];
		int[] info1 = new int[n];
		int[] info2 = new int[n];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {

			st = new StringTokenizer(br.readLine());
			char code = st.nextToken().charAt(0);
			operations[i] = code;
			if (code == 'N') {
				int x = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				ratings.add(r);
				info1[i] = x;
				info2[i] = r;

			} else if (code == 'M') {
				int x = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				ratings.add(r);
				info1[i]=x;
				info2[i]=r;

			} else if (code == 'Q') {
				int k = Integer.parseInt(st.nextToken());
				info1[i]=k;
			}
		}
		br.close();
		long midtime=System.nanoTime();
		Collections.sort(ratings);
		int numRatings = ratings.size();
		HashMap<Integer, Integer> ratingsCompressed = new HashMap<>();
		for (int i = 0; i < numRatings; i++) {
			ratingsCompressed.put(ratings.get(i), i);
		}

		int[] lst = init(numRatings);

		int[] idToRating = new int[1000001];
		int[] ratingToId=new int[numRatings];

		int x,r,k,oldR;
		char code;
		for (int i = 0; i < n; i++) {
			 code = operations[i];
			if (code == 'N') {
				 x = info1[i];
				 r = ratingsCompressed.get(info2[i]);
				idToRating[x]= r;
				ratingToId[r]= x;
				update(lst, r, 0, numRatings, 1, 0);
			} else if (code == 'M') {
				 x = info1[i];
				 r = ratingsCompressed.get(info2[i]);
				oldR = idToRating[x];
				idToRating[x]=-1;
				ratingToId[oldR]=-1;
				idToRating[x]= r;
				ratingToId[r]= x;
				update(lst, oldR, 0, numRatings, 0, 0);
				update(lst, r, 0, numRatings, 1, 0);

			} else if (code == 'Q') {
				 k = info1[i];
				 r = findRight(lst, 0, numRatings, 0, k);
				 x = ratingToId[r];
				System.out.println(x);
			}
		}
		long end=System.nanoTime();
		long run=end-start;
		run/=1000000;
		System.out.println("Run time: "+run);
		run=end-midtime;
		run/=1000000;
		System.out.println("Calc time: "+run);
	}

}
