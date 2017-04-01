package algorithms;

public class AVL {

	static class Node {
		Node left;
		Node right;
		int lheight;
		int rheight;
		int lsize;
		int rsize;
		final int val;

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
			return rsize + lsize+1;
		}

	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root = insert(root, new Node(5));
		root = insert(root, new Node(11));
		root = insert(root, new Node(4));
		root = insert(root, new Node(3));
		root=insert(root, new Node(2));
		root=insert(root, new Node(1));
		root=insert(root,new Node(0));
		System.out.println("Hello "+root.getSize());
	}

	static Node insert(Node currRoot, Node newNode) {
		Node newRoot = currRoot;
		if (newNode.val < currRoot.val) {
			if (currRoot.left == null) {
				currRoot.setLeft(newNode);
			} else
				currRoot.setLeft(insert(currRoot.left, newNode));

		} else {
			if (currRoot.right == null) {
				currRoot.setRight(newNode);
			} else
				currRoot.setRight(insert(currRoot.right, newNode));
		}

		if (currRoot.lheight > currRoot.rheight + 1) {
			if (currRoot.left.rheight > currRoot.left.lheight)
				currRoot.setLeft(leftRotate(currRoot.left));
			newRoot = rightRotate(currRoot);
		} else if (currRoot.rheight > newNode.lheight + 1) {
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

}
