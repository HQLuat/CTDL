package Lab11_Tree;

import java.util.ArrayList;
import java.util.List;

public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E> left, right;

	public BNode(E data) {
		this.data = data;
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public BNode<E> add(BNode<E> aNode, E e) {
		if (aNode == null) {
			aNode = new BNode<>(e);
			return aNode;
		} else if (aNode.data.compareTo(e) >= 0) {
			aNode.setLeft(add(aNode.left, e));
		} else {
			aNode.setRight(add(aNode.right, e));
		}
		return aNode;
	}
	
	public int depth(E node) {
		int comp = node.compareTo(data);
		if (comp > 0 && this.right != null) {
			int rightDepth = this.right.depth(node);
			return rightDepth + 1;
		} else if (comp < 0 && this.left != null) {
			int leftDepth = this.left.depth(node);
			return leftDepth + 1;
		} else if (comp == 0) {
			return 0;
		}
		return -1;
	}

	public int nodeDepth(BNode<E> node, int startValue) {

		int nodeDepth = 0;

		if (node.left == null && node.right == null)
			return startValue;
		else {
			startValue++;
			if (node.left != null) {
				nodeDepth = nodeDepth(node.left, startValue);
			}

			if (node.right != null) {
				nodeDepth = nodeDepth(node.right, startValue);
			}
		}

		return nodeDepth;
	}

	public int size(BNode<E> anode) {
		if (anode == null)
			return 0;
		else {
			return size(anode.left) + 1 + size(anode.right);
		}
	}

	public boolean contains(E e) {
		int comp = e.compareTo(data);
		if (comp == 0)
			return true;
		else if (comp < 0)
			return ((left == null) ? false : left.contains(e));
		else
			return ((right == null) ? false : right.contains(e));
	}

	public E findMin(BNode<E> anode) {
		if (anode == null) {
			return null;
		}

		BNode<E> tmp = anode;
		while (tmp.getLeft() != null) {
			tmp = tmp.getLeft();
		}
		return tmp.getData();
	}

	public E findMax(BNode<E> anode) {
		if (anode == null) {
			return null;
		}

		BNode<E> tmp = anode;
		while (tmp.getRight() != null) {
			tmp = tmp.getRight();
		}
		return tmp.getData();
	}

	public BNode<E> remove(BNode<E> aNode, E e) {
		if (aNode == null) {
			return null;
		} else if (e.compareTo(aNode.data) < 0) {
			remove(aNode.left, e);
		} else if (e.compareTo(aNode.data) > 0) {
			remove(aNode.right, e);
		} else if (e.compareTo(aNode.data) == 0) {
			if (aNode.left != null && aNode.right != null) {
				E lmax = findMax(aNode.left);
				aNode.setData(lmax);
				aNode.setLeft(remove(aNode.left, lmax));
				return aNode;
			} else if (aNode.left != null) {
				return aNode.left;
			} else if (aNode.right != null) {
				return aNode.right;
			} else {
				return null;
			}
		}
		return aNode;
	}

	public List<E> descendants(E data, BNode<E> anode) {
		List<E> l = new ArrayList<>();
		int comp = data.compareTo(anode.data);

		if (comp == 0) {

		} else {
			if (comp < 0) {
				return descendants(data, anode.left);
			} else {
				return descendants(data, anode.right);
			}
		}
		return l;
	}

	public List<E> ancestors(E e) {
		int comp = e.compareTo(data);
		List<E> re = new ArrayList<>();
		if (comp == 0)
			return re;
		if (left != null) {
			if (left.contains(e)) {
				re.addAll(left.ancestors(e));
				re.add(data);
			}
		}
		if (right != null) {
			if (right.contains(e)) {
				re.addAll(right.ancestors(e));
				re.add(data);
			}
		}
		return re;
	}

	public void inorder(BNode<E> aNode) {
		if (aNode != null) {
			inorder(aNode.left);
			System.out.print(aNode.data + " ");
			inorder(aNode.right);
		}
	}

	public void preorder(BNode<E> aNode) {
		if (aNode != null) {
			System.out.print(aNode.data + " ");
			preorder(aNode.left);
			preorder(aNode.right);
		}
	}

	public void postorder(BNode<E> aNode) {
		if (aNode != null) {
			postorder(aNode.left);
			postorder(aNode.right);
			System.out.print(aNode.data + " ");
		}
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public BNode<E> getLeft() {
		return left;
	}

	public void setLeft(BNode<E> left) {
		this.left = left;
	}

	public BNode<E> getRight() {
		return right;
	}

	public void setRight(BNode<E> right) {
		this.right = right;
	}
}
