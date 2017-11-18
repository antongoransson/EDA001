package bst;

public class BinarySearchTree<E extends Comparable<? super E>> {
	BinaryNode<E> root;
	int size;

	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {

	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		BSTVisualizer w = new BSTVisualizer("Trä", 700, 700);
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		tree.add(5);
		tree.add(6);
		tree.add(7);
		tree.add(8);
		w.drawTree(tree);
		System.out.println("Höjden är " + tree.height());
		tree.printTree();
		System.out.println("");
		System.out.println("Trädets storlek är " + tree.size());
		Integer[] a = new Integer[tree.size()];
		tree.toArray(tree.root, a, 0);
		tree.rebuild();
		w.drawTree(tree);
		System.out.println("Höjden efter reBuild är " + tree.height());
		tree.printTree();
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * 
	 * @param x
	 *            element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		if (root == null) {
			root = new BinaryNode<E>(x);
			size++;
			return true;
		}
		return recAdd(x, root);
	}

	private boolean recAdd(E x, BinaryNode<E> n) {
		int temp = n.element.compareTo(x);
		if (temp < 0) {
			if (n.right == null) {
				n.right = new BinaryNode<E>(x);
				size++;
				return true;
			}
			return recAdd(x, n.right);
		} else if (temp > 0) {
			if (n.left == null) {
				n.left = new BinaryNode<E>(x);
				size++;
				return true;
			}
			return recAdd(x, n.left);
		}
		return false;
	}

	/**
	 * Computes the height of tree.
	 * 
	 * @return the height of the tree
	 */
	public int height() {
		return recHeight(root);
	}

	private int recHeight(BinaryNode<E> n) {
		if (n == null) {
			return 0;
		}
		int heightLeft = 1 + recHeight(n.left);
		int heightRight = 1 + recHeight(n.right);
		return Math.max(heightLeft, heightRight);
		// if (recHeight(n.left) < recHeight(n.right)) {
		// return 1 + recHeight(n.right);
		// }
		// return 1 + recHeight(n.left);
	}

	/**
	 * Returns the number of elements in this tree.
	 * 
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}

	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		recPrintTree(root);

	}

	private void recPrintTree(BinaryNode<E> n) {
		if (n != null) {
			recPrintTree(n.left);
			System.out.print(n.element + " ");
			recPrintTree(n.right);
		}
	}

	/**
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		E[] a = (E[]) new Comparable[size];
		toArray(root, a, 0);
		root = buildTree(a, 0, size - 1);
	}

	/*
	 * Adds all elements from the tree rooted at n in inorder to the array a
	 * starting at a[index]. Returns the index of the last inserted element + 1
	 * (the first empty position in a).
	 */
	private int toArray(BinaryNode<E> n, E[] a, int index) {
		if (n != null) {
			index = toArray(n.left, a, index);
			a[index] = n.element;
			index++;
			index = toArray(n.right, a, index);
		}
		return index ;
	}

	/*
	 * Builds a complete tree from the elements a[first]..a[last]. Elements in
	 * the array a are assumed to be in ascending order. Returns the root of
	 * tree.
	 */
	private BinaryNode<E> buildTree(E[] a, int first, int last) {
		int mid = (int) Math.round((first + last) / 2.0);
		if (first > last) {
			return null;
		} else {
			BinaryNode<E> n = new BinaryNode<E>(a[mid]);
			n.left = buildTree(a, first, mid - 1);
			n.right = buildTree(a, mid + 1, last);
			return n;
		}
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}
	}
}
