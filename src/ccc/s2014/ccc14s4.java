package ccc.s2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class ccc14s4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		long t = Long.parseLong(br.readLine());

		long[] tints = new long[n];
		long[] xstarts = new long[n];
		long[] ystarts = new long[n];
		long[] xends = new long[n];
		long[] yends = new long[n];

		long[] xvals = new long[n * 2];
		long[] yvals = new long[n * 2];
		Integer[] xidx = new Integer[n * 2];
		Integer[] yidx = new Integer[n * 2];

		String[] tmp;
		for (int i = 0; i < n; i++) {
			tmp = br.readLine().split(" ");

			long xl = Long.parseLong(tmp[0]);
			long yt = Long.parseLong(tmp[1]);
			long xr = Long.parseLong(tmp[2]);
			long yb = Long.parseLong(tmp[3]);
			long tc = Long.parseLong(tmp[4]);
			xstarts[i] = xl;
			xends[i] = xr;
			ystarts[i] = yt;
			yends[i] = yb;
			tints[i] = tc;

			xvals[i * 2] = xl;
			xvals[i * 2 + 1] = xr;
			xidx[i * 2] = i * 2;
			xidx[i * 2 + 1] = i * 2 + 1;

			yvals[i * 2] = yt;
			yvals[i * 2 + 1] = yb;
			yidx[i * 2] = i * 2;
			yidx[i * 2 + 1] = i * 2 + 1;
		}
		br.close();

		Arrays.sort(xidx, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Long.compare(xvals[o1], xvals[o2]);
			}

		});

		Arrays.sort(yidx, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Long.compare(yvals[o1], yvals[o2]);
			}

		});

		int xmidx = 0;
		int ymidx = 0;
		HashMap<Long, Integer> xmap = new HashMap<>();
		HashMap<Long, Integer> ymap = new HashMap<>();
		HashMap<Integer, Long> xmapback = new HashMap<>();
		HashMap<Integer, Long> ymapback = new HashMap<>();
		for (int i = 0; i < n * 2; i++) {
			long xl = xvals[xidx[i]];
			long yt = yvals[yidx[i]];
			if (!xmap.containsKey(xl)) {
				xmap.put(xl, xmidx);
				xmapback.put(xmidx, xl);
				xmidx++;
			}
			if (!ymap.containsKey(yt)) {
				ymap.put(yt, ymidx);
				ymapback.put(ymidx, yt);
				ymidx++;
			}
		}

//		System.out.println("x cordinates");
//		for (int i = 0; i < xmidx; i++) {
//			System.out.println(xmapback.get(i) + " to " + xmap.get(xmapback.get(i)));
//		}
//
//		System.out.println("y cordinates");
//		for (int i = 0; i < ymidx; i++) {
//
//			System.out.println(ymapback.get(i) + " to " + ymap.get(ymapback.get(i)));
//		}

		long[][] prefix = new long[xmidx][ymidx];

		for (int i = 0; i < n; i++) {
			prefix[xmap.get(xstarts[i])][ymap.get(ystarts[i])] += tints[i];
			prefix[xmap.get(xends[i])][ymap.get(ystarts[i])] -= tints[i];
			prefix[xmap.get(xstarts[i])][ymap.get(yends[i])] -= tints[i];
			prefix[xmap.get(xends[i])][ymap.get(yends[i])] += tints[i];
		}
//		
//		for (int x = 0; x < xmidx; x++) {
//
//			for (int y = 0; y < ymidx; y++) {
//				System.out.print(prefix[x][y] + " ");
//
//			}
//			System.out.println();
//		}
//		System.out.println();

		
		for (int y = 0; y < ymidx; y++) {
			long currtint = 0;
			for (int x = 0; x < xmidx; x++) {
				currtint += prefix[x][y];
				prefix[x][y] = currtint;
			}
		}

		for (int x = 0; x < xmidx; x++) {
			long currtint = 0;
			for (int y = 0; y < ymidx; y++) {
				currtint += prefix[x][y];
				prefix[x][y] = currtint;
			}
		}

//		for (int x = 0; x < xmidx; x++) {
//			for (int y = 0; y < ymidx; y++) {
//				System.out.print(prefix[x][y] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
		long sum = 0;
		for (int x = 0; x < xmidx - 1; x++) {
			for (int y = 0; y < ymidx - 1; y++) {
				if (prefix[x][y] >= t) {
					long xl = xmapback.get(x);
					long xr = xmapback.get(x + 1);
					long yt = ymapback.get(y);
					long yb = ymapback.get(y + 1);
					long area = (xr - xl) * (yb - yt);
					sum += area;
				}
			}
		}

		System.out.println(sum);

	}
}
