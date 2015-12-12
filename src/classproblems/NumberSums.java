package classproblems;

public class NumberSums {

	public static void main(String[] args) {
		int[] set = new int[100];
		for (int i = 0; i < 100; i++) {
			set[i] = i;
		}
		System.out.println(countSums(set));
	}

	public static int countSums(int[] set) {
		int n = set.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (j != i) {
					for (int k = 0; k < n; k++) {
						if (k != j && k != i && k == j + i) {
							System.out.println(j + "+" + i + "=" + k);
							count++;
						}
					}
				}
			}
		}
		return count;
	}
}
