package cco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class cco10p3 {
	static class Node {
		Node left;
		Node right;
		int lheight;
		int rheight;
		int lsize;
		int rsize;
		int val;

		public Node(int val) {
			this.val = val;
		}

		public void setLeft(Node l) {
			left = l;
			if (l == null) {
				lsize = 0;
				lheight = 0;
			} else {
				lheight = l.getHeight() + 1;
				lsize = l.getSize();
			}

		}

		public void setRight(Node r) {
			right = r;
			if (r == null) {
				rsize = 0;
				rheight = 0;
			} else {
				rsize = r.getSize();
				rheight = r.getHeight() + 1;
			}
		}

		public int getHeight() {
			return Math.max(lheight, rheight);
		}

		public int getSize() {
			return rsize + lsize + 1;
		}

	}

	static Node insert(Node currRoot, Node newNode) {
		if (currRoot == null)
			return newNode;
		if (newNode.val < currRoot.val) {
			currRoot.setLeft(insert(currRoot.left, newNode));
		} else {
			currRoot.setRight(insert(currRoot.right, newNode));
		}

		Node newRoot = currRoot;

		if (currRoot.lheight > currRoot.rheight + 1) {
			if (currRoot.left.rheight > currRoot.left.lheight)
				currRoot.setLeft(leftRotate(currRoot.left));
			newRoot = rightRotate(currRoot);
		} else if (currRoot.rheight > currRoot.lheight + 1) {
			if (currRoot.right.lheight > currRoot.right.rheight)
				currRoot.setRight(rightRotate(currRoot.right));
			newRoot = leftRotate(currRoot);
		}

		return newRoot;
	}

	static Node getLargest(Node currRoot) {
		if (currRoot.right == null)
			return currRoot;
		return getLargest(currRoot.right);
	}

	static Node delete(Node currRoot, Node delNode) {
		Node newRoot = currRoot;

		if (delNode.val < currRoot.val) {
			currRoot.setLeft(delete(currRoot.left, delNode));
		} else if (delNode.val > currRoot.val) {
			currRoot.setRight(delete(currRoot.right, delNode));
		} else {
			if (currRoot.left != null && currRoot.right != null) {
				Node largest = getLargest(currRoot.left);
				currRoot.val = largest.val;
				currRoot.setLeft(delete(currRoot.left, largest));
				return currRoot;
			}
			if (currRoot.left != null && currRoot.right == null)
				return currRoot.left;
			if (currRoot.left == null && currRoot.right != null)
				return currRoot.right;
			return null;
		}

		if (currRoot.lheight > currRoot.rheight + 1) {
			if (currRoot.left.rheight > currRoot.left.lheight)
				currRoot.setLeft(leftRotate(currRoot.left));
			newRoot = rightRotate(currRoot);
		} else if (currRoot.rheight > currRoot.lheight + 1) {
			if (currRoot.right.lheight > currRoot.right.rheight)
				currRoot.setRight(rightRotate(currRoot.right));
			newRoot = leftRotate(currRoot);
		}

		return newRoot;
	}

	static Node leftRotate(Node currRoot) {
		Node newRoot = currRoot.right;
		currRoot.setRight(newRoot.left);
		newRoot.setLeft(currRoot);
		return newRoot;
	}

	static Node rightRotate(Node currRoot) {
		Node newRoot = currRoot.left;
		currRoot.setLeft(newRoot.right);
		newRoot.setRight(currRoot);
		return newRoot;
	}

	static Node get(Node root, int val) {
		if (val < root.rsize) {
			return get(root.right, val);
		} else if (val > root.rsize) {
			return get(root.left, val - root.rsize-1);
		} else {
			return root;
		}
	}

	static Node avl;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> idToRating = new HashMap<>();
		HashMap<Integer, Integer> ratingToId = new HashMap<>();
		avl = null;
		String[] tmp;
		for (int i = 0; i < n; i++) {
			tmp = br.readLine().split(" ");
			if (tmp[0].equals("N")) {
				int x = Integer.parseInt(tmp[1]);
				int r = Integer.parseInt(tmp[2]);
				idToRating.put(x, r);
				ratingToId.put(r, x);
				avl = insert(avl, new Node(r));
			} else if (tmp[0].equals("M")) {
				int x = Integer.parseInt(tmp[1]);
				int r = Integer.parseInt(tmp[2]);
				int oldR = idToRating.get(x);
				idToRating.remove(x);
				ratingToId.remove(oldR);
				idToRating.put(x, r);
				ratingToId.put(r, x);
				avl = delete(avl, new Node(oldR));
				avl = insert(avl, new Node(r));
			} else if (tmp[0].equals("Q")) {
				int k = Integer.parseInt(tmp[1]);
				System.out.println(ratingToId.get(get(avl, k-1).val));
			}
		}
		br.close();
	}

}
