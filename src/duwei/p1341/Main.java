package duwei.p1341;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int target = s.nextInt();
		int[] originalNums = new int[n];
		ArrayList<Integer> nums = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			originalNums[i] = s.nextInt();
			nums.add(originalNums[i]);
		}
		s.close();

		Arrays.sort(originalNums);

		int closestVal=-1;
		int minDiff = Integer.MAX_VALUE;

		outer: for (int i = 0; i < n; i++) {
			int newTarget = target - originalNums[i];
//			System.out.println("current target: "+newTarget);
			nums.remove(i);
			Collections.sort(nums);
			
//			System.out.println(x);

			int lower = 0;
			int higher = nums.size()-1;
			Integer currSum=0;
			

			while (lower < higher) {
				currSum = nums.get(lower) + nums.get(higher);
				
				int totalSum = originalNums[i] + currSum;
				int diff = Math.abs(totalSum - target);

				if (diff < minDiff) {
					minDiff = diff;
					closestVal = totalSum;
				}
				if (minDiff == 0)
					break outer;
				
				if (currSum < newTarget) {
					lower++;
					continue;
				}
				if (currSum > newTarget) {
					higher--;
					continue;
				}
				if (currSum == newTarget) {
					break;
				}
			}

		

			nums.add(originalNums[i]);
			Collections.sort(nums);
		}

		System.out.println(closestVal);

	}

}
