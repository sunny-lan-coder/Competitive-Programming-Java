package dmoj.tle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class tle16c3p3 {

	static class Cls {
		public final int period;
		public final ArrayList<Integer> students;
		public final int id;

		public Cls(int pi, int id) {
			period = pi;
			students = new ArrayList<>();
			this.id = id;
		}
	}

	public static void main(String[] args) throws IOException {
		String[] tmp;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		tmp = br.readLine().split(" ");
		int srcT = Integer.parseInt(tmp[0]);
		int dstT = Integer.parseInt(tmp[1]);
		HashMap<Integer, Integer> idMappings = new HashMap<>();
		HashMap<Integer, Integer> idMappingsR = new HashMap<>();
		int studentCount = 0;
		Cls[] classes = new Cls[n];
		for (int i = 0; i < n; i++) {
			tmp = br.readLine().split(" ");
			int pi = Integer.parseInt(tmp[0]);
			int si = Integer.parseInt(tmp[1]);
			tmp = br.readLine().split(" ");
			Cls cclass = new Cls(pi, i + 1);
			for (int j = 0; j < si; j++) {
				int id = Integer.parseInt(tmp[j]);
				if (!idMappings.containsKey(id)) {
					idMappings.put(id, studentCount);
					idMappingsR.put(studentCount, id);
					studentCount++;
				}
				cclass.students.add(idMappings.get(id));
			}
			classes[i] = cclass;
		}
		br.close();
		int src = idMappings.get(srcT);
		int dst = idMappings.get(dstT);

		int[] dp1 = new int[studentCount];
		int[] dp2 = new int[studentCount];

		for (int i = 0; i < studentCount; i++) {
			dp1[i] = -1;
			dp2[i] = -1;
		}

		dp1[src] = 0;

		Arrays.sort(classes, new Comparator<Cls>() {
			@Override
			public int compare(Cls o1, Cls o2) {
				return Integer.compare(o1.period, o2.period);
			}
		});

		for (int i = 0; i < n; i++) {
			Cls currClass = classes[i];
			// System.out.println("class " + currClass.id + ", period " +
			// currClass.period);
			int min = -1;
			int minid = -1;
			for (int student : currClass.students) {
				if (smaller(dp1[student], min)) {
					min = dp1[student];
					minid = student;
				}
			}
			// System.out.println(" min student " + idMappingsR.get(min) + "
			// passes " + min);

			for (int student : currClass.students) {
				if (dp1[student] != min) {
					// System.out.println(" pass to student " +
					// idMappingsR.get(student) + " minper" + dp2[student]);
					if (smaller(min + 1, dp1[student])) {
						dp1[student] = min + 1;
						// if (smaller(currClass.period, dp2[student]))
						dp2[student] = currClass.period;
					}
					if (min + 1 == dp1[student])
						if (smaller(currClass.period, dp2[student]))
							dp2[student] = currClass.period;
				}
			}
		}

		if (dp1[dst] == -1)
			System.out.println("delivery failure");
		else {
			System.out.println(dp1[dst]);
			System.out.println(dp2[dst]);
		}

	}

	static boolean smaller(int a, int b) {
		if (a == -1)
			return false;
		if (b == -1)
			return true;
		return b > a;
	}
}
