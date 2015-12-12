package classq.minsubarray;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MinimumSubArray {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int mR = s.nextInt();
		int mC = s.nextInt();
		int sR = s.nextInt();
		int sC = s.nextInt();
		int[][] matrix = new int[mR][mC];
		for (int i = 0; i < mR; i++) {
			for (int j = 0; j < mC; j++) {
				matrix[i][j] = s.nextInt();
			}
		}
		s.close();
		matrix = minSubarray(matrix, sR, sC);
		for (int[] row : matrix) {
			for (int num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	static int[][] minSubarray(int[][] array, int sR, int sC) {
		int lowestGrade = Integer.MAX_VALUE;
		int mR = array.length;
		int mC = array[0].length;
		int rL = 1 << mR;
		int cL = 1 << mC;
		int[][] lowestMatrix = null;
		for (int rS = 0; rS < rL; rS++) {
			for (int cS = 0; cS < cL; cS++) {
				System.out.println("rS=" + Integer.toBinaryString(rS));
				System.out.println("cS=" + Integer.toBinaryString(cS));
				if (Integer.bitCount(rS) == sR && Integer.bitCount(cS) == sC) {
					int nR = 0;
					int nC = 0;
					int[][] subArray = new int[sR][sC];
					int tmpR = rS;
					for (int r = 0; r < mR; r++) {
						if ((tmpR & 1) == 1) {
							int tmpC = cS;
							for (int c = 0; c < mC; c++) {
								if ((tmpC & 1) == 1) {
									int t = array[r][c];
									subArray[nR][nC] = t;
									nC++;
								}
								tmpC = tmpC >> 1;
							}
							nR++;
						}
						tmpR = tmpR >> 1;
					}
					System.out.println("subarray size" + nR + "," + nC);
					System.out.println("selected:");
					for (int[] row : subArray) {
						for (int num : row) {
							System.out.print(num + " ");
						}
						System.out.println();
					}
					int grade = grade(subArray);
					System.out.println("grade:" + grade);
					if (grade < lowestGrade) {
						lowestGrade = grade;
						lowestMatrix = subArray;
					}
				}
			}
		}
		return lowestMatrix;
	}

	static int grade(int[][] array) {
		int mR = array.length;
		int mC = array[0].length;
		int grade = 0;
		Queue<Integer> totestI = new LinkedList<Integer>();
		Queue<Integer> totestJ = new LinkedList<Integer>();
		totestI.add(0);
		totestJ.add(0);
		while (!totestI.isEmpty()) {
			int i = totestI.remove();
			int j = totestJ.remove();
			int cV = array[i][j];
			if (i + 1 < mR) {
				grade += Math.abs(cV - array[i + 1][j]);
				totestI.add(i + 1);
				totestJ.add(j);
			}
			if (j + 1 < mC) {
				grade += Math.abs(cV - array[i][j + 1]);
				totestI.add(i);
				totestJ.add(j + 1);
			}
		}
		return grade;
	}
}
