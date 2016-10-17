package duwei.tmp19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

	static class TrieNode {
		public HashMap<Character, TrieNode> children;
		public ArrayList<String> words;
		public boolean end = false;
		public String word;

		public TrieNode() {
			children = new HashMap<>();
		}

		public void add(String s) {
			this.word = s;
			if (s.length() == 0) {
				end = true;
				return;
			}
			TrieNode child;
			Character key = s.charAt(0);
			String sub = s.substring(1);
			if (children.containsKey(key)) {
				child = children.get(key);
			} else {
				child = new TrieNode();
				children.put(key, child);
			}
			child.add(sub);
		}

		public TrieNode prefixMatch(String val) {
			if (val.length() == 0)
				return this;
			Character key = val.charAt(0);
			if (children.containsKey(key)) {
				return children.get(key).prefixMatch(val.substring(1));
			} else {
				return null;
			}
		}

		public ArrayList<String> list() {
			ArrayList<String> result = new ArrayList<>();
			for (Character key : children.keySet()) {
				// if (key == '-') {
				// result.add("");
				// } else {
				// // System.out.println(key);
				// ArrayList<String> subresult = children.get(key).list();
				//
				// for (String s : subresult) {
				// result.add(key + s);
				// }
				// }
				
			
				result.add(children.get(key).word);
			}
			return result;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> strings = new HashSet<>();
		ArrayList<String> stringlist = new ArrayList<>();
		TrieNode root = new TrieNode();
		String str;
		while ((str = br.readLine()) != null && str.length() != 0) {
			strings.add(str);
			stringlist.add(str);
			root.add(str);
		}
		br.close();
		ArrayList<String> output = new ArrayList<>();
		HashSet<String> list=new HashSet<>();
		for (String s : stringlist) {
			// System.out.println("current: '"+s+"'");
			ArrayList<String> sub = root.prefixMatch(s).list();
			// System.out.println("sub:");
			for (String st : sub) {
				// System.out.println(" '"+st+"'");
				if (strings.contains(st) && s != st && (!(s + st).equals(""))) {
if(!list.contains(s+st)){
					list.add(s+st);
					output.add(s + st);
}
				}
			}
		}

		Collections.sort(output);
		for (String s : output) {
				System.out.println(s);
		}

	}

}
