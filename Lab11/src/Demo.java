import java.util.Iterator;

public class Demo {
	public static void main(String[] args) 
	{
		BinarySearchTree<Integer> bst = new BinarySearchTree();
		Iterator<Integer> iter;
		bst.add(25);
		bst.add(15);
		bst.add(10);
		bst.add(12);
		bst.add(4);
		bst.add(50);
		bst.add(22);
		bst.add(18);
		bst.add(24);
		bst.add(35);
		bst.add(31);
		bst.add(44);
		bst.add(70);
		bst.add(66);
		bst.add(90);
		System.out.println("the maximum depth is£º" + bst.getMaxDepth(bst.root));
		bst.size();
		System.out.println("Inorder:  ");
		iter = bst.getIterator(BSTInterface.Traversal.Inorder);
		while(iter.hasNext())
			System.out.print(iter.next()+",");
		
		System.out.println("\nPreOrder:  ");
		iter = bst.getIterator(BSTInterface.Traversal.Preorder);
		while(iter.hasNext())
			System.out.print(iter.next()+",");
		
		System.out.println("\nPostorder:  ");
		iter = bst.getIterator(BSTInterface.Traversal.Postorder);
		while(iter.hasNext())
			System.out.print(iter.next()+",");
		
	}
}
