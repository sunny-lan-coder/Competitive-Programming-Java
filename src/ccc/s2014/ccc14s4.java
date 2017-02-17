package ccc.s2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ccc14s4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long t = Long.parseLong(br.readLine());
		int xmidx = 0;
		int ymidx = 0;
		HashMap<Long, Integer> xmap = new HashMap<>();
		HashMap<Long, Integer> ymap = new HashMap<>();
		HashMap<Integer, Long> xmapback = new HashMap<>();
		HashMap<Integer, Long> ymapback = new HashMap<>();
		long[] tints = new long[n];
		long[] xstarts = new long[n];
		long[] ystarts = new long[n];
		long[] xends = new long[n];
		long[] yends = new long[n];
		String[] tmp;

		for (int i = 0; i < n; i++) {
			tmp = br.readLine().split(" ");
			long xl = Long.parseLong(tmp[0]);
			long xr = Long.parseLong(tmp[1]);
			long yt = Long.parseLong(tmp[2]);
			long yb = Long.parseLong(tmp[3]);
			long tc = Long.parseLong(tmp[4]);
			xstarts[i] = xl;
			xends[i] = xr;
			ystarts[i] = yt;
			yends[i] = yb;
			tints[i] = tc;
			if (!xmap.containsKey(xl)) {
				xmap.put(xl, xmidx);
				xmapback.put(xmidx, xl);
				xmidx++;
			}
			if (!xmap.containsKey(xr)) {
				xmap.put(xr, xmidx);
				xmapback.put(xmidx, xr);
				xmidx++;
			}
			if (!ymap.containsKey(yt)) {
				ymap.put(yt, ymidx);
				ymapback.put(ymidx, yt);
				ymidx++;
			}
			if (!ymap.containsKey(yb)) {
				ymap.put(yb, ymidx);
				ymapback.put(ymidx, yb);
				ymidx++;
			}
		}
		br.close();

		long[][] prefix = new long[xmidx + 1][ymidx + 1];

		for (int i = 0; i < n; i++) {
			prefix[xmap.get(xstarts[i])][ymap.get(ystarts[i])] += tints[i];
			prefix[xmap.get(xends[i])][ymap.get(ystarts[i])] -= tints[i];
			prefix[xmap.get(xstarts[i])][ymap.get(yends[i])] += tints[i];
			prefix[xmap.get(xends[i])][ymap.get(yends[i])] -= tints[i];
		}

		for (int y = 0; y <= ymidx; y++) {
			long currtint = 0;
			for (int x = 0; x <= xmidx; x++) {
				currtint += prefix[x][y];
				prefix[x][y] = currtint;
			}
		}

		for (int x = 0; x <= xmidx; x++) {
			long currtint = 0;
			for (int y = 0; y <= ymidx; y++) {
				currtint += prefix[x][y];
				prefix[x][y] = currtint;
			}
		}

		long sum = 0;
		for (int x = 0; x < xmidx; x++) {
			for (int y = 0; y < ymidx; y++) {
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
