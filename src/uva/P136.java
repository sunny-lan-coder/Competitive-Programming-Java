package uva;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P136 {

	public static void main(String[] args) {
		String letterMap = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		boolean flag = false;
		
		Scanner s = new Scanner(System.in);
		while (s.hasNextLine()) {
			if (flag) System.out.println();
			flag = true;
			
			ArrayList<String> lines = new ArrayList<>();
			while (true) {
				String line = s.nextLine();
				if (line.equals("#"))
					break;
				lines.add(line);
			}
			// gen graph:
			int[][] matrix = new int[26][26];
			Queue<ArrayList<String>> toAdd = new LinkedList<>();
			toAdd.add(lines);
			int[] degrees = new int[26];
			for (int i = 0; i < 26; i++) {
				degrees[i] = -1;
			}
			ArrayList<String> tmp = new ArrayList<>();
			while (!toAdd.isEmpty()) {
				ArrayList<String> currentWorking = toAdd.remove();

				char prev = ' ';

				for (String entry : currentWorking) {
					char current = entry.charAt(0);

					int from = letterMap.indexOf(current);
					int to = letterMap.indexOf(prev);

					// init vals
					if (prev != ' ') {
						if (degrees[to] == -1) {
							degrees[to] = 0;
						}
					}

					if (degrees[from] == -1) {
						degrees[from] = 0;
					}

					if (prev != ' ') {
						if (prev != current) {
							//System.out.println(prev + "<" + current);
							toAdd.add(tmp);
							tmp = new ArrayList<>();

							matrix[to][from] = 1;

							degrees[to]++;
						}
					}

					if (entry.length() > 1)
						tmp.add(entry.substring(1));

					prev = current;
				}

				if (tmp.isEmpty())
					continue;

				toAdd.add(tmp);
				tmp = new ArrayList<>();
			}

			String result = "";
			for (int i = 0; i < 26; i++) {
				if (degrees[i] == 0) {
					result = letterMap.charAt(i) + result;
					degrees[i] = -1;
					for (int j = 0; j < 26; j++) {
						if (degrees[j] != -1 && matrix[j][i] == 1) {
							matrix[j][i] = 0;
							degrees[j]--;
						}
					}
					i = -1;
				}
			}
			System.out.print(result);
		}
		s.close();
	}

}
