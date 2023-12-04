package Lab11_Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	// Add element e into BST
	public void add(E e) {
		if (root == null) {
			root = new BNode<>(e);
		} else {
			this.root = root.add(root, e);
		}
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	// compute the depth of a node in BST
	public int depth(E node) {
		if(root == null) {
			return -1;
		}else {
			return root.depth(node);
		}
	}

	// compute the height of BST
	public int height() {
		if (this.root == null)
			return -1;

		int leftDepth = root.nodeDepth(this.root.getLeft(), 1);
		int rightDepth = root.nodeDepth(this.root.getRight(), 1);

		int height = (leftDepth > rightDepth) ? leftDepth : rightDepth;

		return height;
	}

	// Compute total nodes in BST
	public int size() {
		return root.size(root);
	}

	// Check whether element e is in BST
	public boolean contains(E e) {
		if (root == null)
			return false;
		return root.contains(e);
	}

	// Find the minimum element in BST
	public E findMin() {
		return root.findMin(root);
	}

	// Find the maximum element in BST
	public E findMax() {
		return root.findMax(root);
	}

	// Remove element e from BST
	public boolean remove(E e) {
		if (root == null) {
			return false;
		} else {
			root.remove(root, e);
			return true;
		}
	}

	// get the descendants of a node
	public List<E> descendants(E data) {
		List<E> descendantsList = new ArrayList<>();
		BNode<E> node = findNode(root, data);

		if (node != null) {
			collectDescendants(node, descendantsList);
		}

		return descendantsList;
	}
	public BNode<E> findNode(BNode<E> node, E value) {
		if (node == null) {
			return null;
		}

		int compare = value.compareTo(node.getData());

		if (compare == 0) {
			return node;
		} else if (compare < 0) {
			return findNode(node.getLeft(), value);
		} else {
			return findNode(node.getRight(), value);
		}
	}
	public void collectDescendants(BNode<E> node, List<E> descendantsList) {
		if (node != null) {
			descendantsList.add(node.getData());
			collectDescendants(node.getLeft(), descendantsList);
			collectDescendants(node.getRight(), descendantsList);
		}
	}

	// get the ancestors of a node
	public List<E> ancestors(E e) {
		return root.ancestors(e);
	}

	// display BST using inorder approach
	public void inorder() {
		root.inorder(root);
		System.out.println();
	}

	// display BST using preorder approach
	public void preorder() {
		root.preorder(root);
		System.out.println();
	}

	// display BST using postorder approach
	public void postorder() {
		root.postorder(root);
		System.out.println();
	}
}
