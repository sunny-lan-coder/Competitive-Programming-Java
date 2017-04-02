package algorithms;

public class AVL {

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
				currRoot.setRight(rightRotate(currRoot));
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
			if (currRoot.left != null & currRoot.right != null) {
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
				currRoot.setRight(rightRotate(currRoot));
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

	public static void main(String[] args) {
		Node root = null;
		root = insert(root, new Node(5));
		root = insert(root, new Node(11));
		root = insert(root, new Node(4));
		root = insert(root, new Node(3));
		root = insert(root, new Node(2));
		root = insert(root, new Node(1));
		root = insert(root, new Node(0));
		root = delete(root, new Node(3));
		System.out.println("Hello " + root.getSize());
	}

}
