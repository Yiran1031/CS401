import java.util.Iterator;

public interface BSTInterface<T> extends CollectionInterface<T>, Iterable<T> {
	
	// Used to specify traversal order
	public enum Traversal{Inorder, Preorder, Postorder};
	
	//If this BST is empty, returns null;
	//otherwise return the smallest element of the tree
	T min();
	
	//If this BST is empty, returns null
	//otherwise returns the largest element of the tree
	T max();
	
	//Creates and returns an Iterator providing a traversal of a "snapshot"
	public Iterator<T> getIterator(Traversal orderType) throws QueueOverflowException;
}
