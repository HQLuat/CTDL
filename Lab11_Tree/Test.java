package Lab11_Tree;

public class Test {
	public static void main(String[] args) {
		BST<Integer> bst = new BST<Integer>();
		bst.add(25);
		bst.add(15);
		bst.add(50);
		bst.add(10);
		bst.add(22);
		bst.add(35);
		bst.add(70);
		bst.add(4);
		bst.add(12);
		bst.add(18);
		bst.add(24);
		bst.add(31);
		bst.add(44);
		bst.add(66);
		bst.add(90);
		
		//Testing depth method
		System.out.print("Depth: ");
		System.out.println(bst.depth(10));
		System.out.println("---------------------------------------------------------");
		
		//Testing height method
		System.out.print("Height: ");
		System.out.println(bst.height());
		System.out.println("---------------------------------------------------------");
		
		//Testing size method
		System.out.print("Size: ");
		System.out.println(bst.size());
		System.out.println("---------------------------------------------------------");
		
		//Testing contains method
		System.out.print("Contains 50: ");
		System.out.println(bst.contains(50));
		System.out.println("---------------------------------------------------------");
		
		//Testing findMin method
		System.out.print("findMin: ");
		System.out.println(bst.findMin());
		System.out.println("---------------------------------------------------------");
		
		//Testing findMax method
		System.out.print("findMax: ");
		System.out.println(bst.findMax());
		System.out.println("---------------------------------------------------------");
		
		//Testing remove method
		System.out.print("remove: ");
		System.out.println(bst.remove(70));
		System.out.println("---------------------------------------------------------");
		
		//Testing descendants method
		System.out.print("Descendants of 15: ");
		System.out.println(bst.descendants(15));
		System.out.println("---------------------------------------------------------");
		
		//Testing ancestors method
		System.out.print("Ancestors of 10: ");
		System.out.println(bst.ancestors(10));
		System.out.println("---------------------------------------------------------");
		
		//Testing Tree Traversal Algorithms
		System.out.println("InOrder:");
		bst.inorder();
		System.out.println("---------------------------------------------------------");
		System.out.println("Pre-order:");
		bst.preorder();
		System.out.println("---------------------------------------------------------");
		System.out.println("Post-order:");
		bst.postorder();
	}
}
