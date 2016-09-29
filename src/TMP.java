import java.util.ArrayList;

public class TMP {

	public static void main(String[] args) {
		int[] two = new int[100];
		int[] three = new int[100];
		int[] five = new int[100];
		ArrayList<ArrayList<String>> fi = new ArrayList<>(100);

		ArrayList<ArrayList<String>> th = new ArrayList<>(100);

		ArrayList<ArrayList<String>> tw = new ArrayList<>(100);

		two[0] = 1;
		three[0] = 1;
		five[0] = 1;

		for (int i = 0; i < 100; i++) {
			fi.add(new ArrayList<>());
			th.add(new ArrayList<>());
			tw.add(new ArrayList<>());
		}

		tw.get(0).add("");
		th.get(0).add("");
		fi.get(0).add("");

		for (int i = 0; i < 20; i++) {
			two[i + 2] += two[i];
			three[i + 3] += two[i];
			five[i + 5] += two[i];
			for (String s : tw.get(i)) {
				tw.get(i + 2).add(s + "A");
				th.get(i + 2).add(s + "A");
				fi.get(i + 2).add(s + "A");
			}
			three[i + 3] += three[i];
			five[i + 5] += three[i];
			for (String s : th.get(i)) {

				th.get(i + 3).add(s + "B");
				fi.get(i + 3).add(s + "B");
			}
			five[i + 5] += five[i];
			for (String s : fi.get(i)) {

				fi.get(i + 5).add(s + "W");
			}
		}
		System.out.println(two[20] + three[20] + five[20]);
		for (String s : tw.get(20)) {
			System.out.print(s + ", ");
		}
		for (String s : th.get(20)) {
			System.out.print(s + ", ");
		}
		for (String s : fi.get(20)) {
			System.out.print(s + ", ");
		}
	}

}
