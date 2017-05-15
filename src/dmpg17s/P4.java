package dmpg17s;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P4 {

	static boolean check(int e, int en) {
		return ((e >> en) & 1) == 1;
	}

	static int kill(int e, int en) {
		return en & ~(1 << en);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int e = 0;
		int sr = -1, sc = -1;
		int[][] board = new int[10][9];
		for (int i = 0; i < 10; i++) {
			String tmp = s.next();
			for (int j = 0; j < 9; j++) {
				char c = tmp.charAt(j);
				board[i][j] = -1;
				if (c == 'E') {
					board[i][j] = e;
					e++;
				}
				if (c == 'C') {
					sr = i;
					sc = j;
				}
			}
		}
		s.close();
		if (e == 0) {
			System.out.println("0 0");
			return;
		}

		int se = (1 << e);

		Queue<Integer> qr = new LinkedList<>();
		Queue<Integer> qc = new LinkedList<>();
		Queue<Integer> qe = new LinkedList<>();
		Queue<Long> l = new LinkedList<>();
		Queue<Integer> qcap = new LinkedList<>();

		boolean[][][] visited = new boolean[10][9][se];
		

		qr.add(sr);
		qc.add(sc);
		qe.add(se-1);
		l.add(0l);
		qcap.add(0);
		int maxc = 0;
		long minm = Long.MAX_VALUE;
		while (!l.isEmpty()) {
			int cr = qr.remove();
			int cc = qc.remove();
			int ce = qe.remove();
			long cl = l.remove();
			int cap = qcap.remove();
			if (visited[cr][cc][ce]) {
				continue;
			}
			// System.out.println("r=" + cr + " c=" + cc + " e=" +
			// Integer.toBinaryString(ce) + " l=" + cl);

			if (cap == maxc) {
				minm = Math.min(minm, cl);
			} else if (cap > maxc) {
				maxc = cap;
				minm = cl;
			}

			boolean screenMode;
			screenMode = false;
			for (int i = cr + 1; i < 10; i++) {
				if (screenMode) {
					if (board[i][cc] != -1 && check(ce, board[i][cc])) {
						qr.add(i);
						qc.add(cc);
						qe.add(kill(ce, board[i][cc]));
						qcap.add(cap + 1);
						l.add(cl + 1);
						break;
					}
				} else {
					if (board[i][cc] != -1 && check(ce, board[i][cc])) {
						screenMode = true;
					} else {
						qr.add(i);
						qc.add(cc);
						qe.add(ce);
						qcap.add(cap);
						l.add(cl + 1);
					}
				}
			}

			screenMode = false;
			for (int i = cr - 1; i >= 0; i--) {
				if (screenMode) {
					if (board[i][cc] != -1 && check(ce, board[i][cc])) {
						qr.add(i);
						qc.add(cc);
						qe.add(kill(ce, board[i][cc]));
						qcap.add(cap + 1);
						l.add(cl + 1);
						break;
					}
				} else {
					if (board[i][cc] != -1 && check(ce, board[i][cc])) {
						screenMode = true;
					} else {
						qr.add(i);
						qc.add(cc);
						qe.add(ce);
						qcap.add(cap);
						l.add(cl + 1);
					}
				}
			}

			screenMode = false;
			for (int i = cc + 1; i < 9; i++) {
				if (screenMode) {
					if (board[cr][i] != -1 && check(ce, board[cr][i])) {
						qr.add(cr);
						qc.add(i);
						qe.add(kill(ce, board[cr][i]));
						qcap.add(cap + 1);
						l.add(cl + 1);
						break;
					}
				} else {
					if (board[cr][i] != -1 && check(ce, board[cr][i])) {
						screenMode = true;
					} else {
						qr.add(cr);
						qc.add(i);
						qe.add(ce);
						qcap.add(cap);
						l.add(cl + 1);
					}
				}
			}

			screenMode = false;
			for (int i = cc - 1; i >= 0; i--) {
				if (screenMode) {
					if (board[cr][i] != -1 && check(ce, board[cr][i])) {
						qr.add(cr);
						qc.add(i);
						qe.add(kill(ce, board[cr][i]));
						qcap.add(cap + 1);
						l.add(cl + 1);
						break;
					}
				} else {
					if (board[cr][i] != -1 && check(ce, board[cr][i])) {
						screenMode = true;
					} else {
						qr.add(cr);
						qc.add(i);
						qe.add(ce);
						qcap.add(cap);
						l.add(cl + 1);
					}
				}
			}

			visited[cr][cc][ce] = true;
		}
		System.out.println(maxc + " " + minm);
	}

}
