import java.util.Comparator;
import java.util.Iterator;

public class BinarySearchTree<T> implements BSTInterface<T> {
	protected BSTNode<T> root;
	protected Comparator<T> comp; //used for all comparisons
	protected boolean found;
	protected int n;
	
	public BinarySearchTree() //use natural order
	{
		n = 0;
		root = null;
		comp = new Comparator<T>() 
		{
			public int compare(T element1, T element2) 
			{
				return ((Comparable)element1).compareTo(element2);
			}
		};
	}
	public BinarySearchTree(Comparator<T> comp) // use Comparator comp for order
	{
		n = 0;
		root = null;
		this.comp = comp;
	}

	@Override
	public boolean add(T element) {
		// TODO Auto-generated method stub
		root = recAdd(element, root);
		return true;
	}
	
	private BSTNode<T> recAdd(T element, BSTNode<T> node)
	{
		if(node == null)
			node = new BSTNode<T>(element);
		else if(comp.compare(element, node.getInfo()) <= 0)
			node.setLeft(recAdd(element, node.getLeft()));
		else 
			node.setRight(recAdd(element, node.getRight()));
		return node;
	}

	@Override
	public T get(T target) {
		// TODO Auto-generated method stub
		
		return recGet(target,root);
	}
	
	private T recGet(T target, BSTNode<T> node) 
	{
		if(node == null)
			return null;
		else if(comp.compare(target, node.getInfo()) < 0)
			return recGet(target, node.getLeft());
		else if(comp.compare(target, node.getInfo()) > 0)
			return recGet(target, node.getRight());
		else
			return node.getInfo();
	}


	@Override
	public boolean contains(T target) {
		// TODO Auto-generated method stub
		//n = 0;
		return recContains(target, root);
	}
	
	private boolean recContains(T target, BSTNode<T> node) 
	{
		n++;
		if(node == null)
			return false;
		//if don't find the target and the value greater than the target, search the left subtree
		else if(comp.compare(target, node.getInfo()) < 0)
			return recContains(target, node.getLeft());
		// if the value less than the target, search the right subtree
		else if(comp.compare(target, node.getInfo()) > 0)
			return recContains(target, node.getRight());
		else
			return true;
	}


	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	@Override
	public boolean remove(T target) {
		// TODO Auto-generated method stub
		recRemove(target, root);
		return found;
	}
	private BSTNode<T> recRemove(T target, BSTNode<T> node)
	{
		if(node == null)
			found = false;
		else if (comp.compare(target, node.getInfo()) < 0)
			node.setLeft(recRemove(target,node.getLeft()));
		else if(comp.compare(target, node.getInfo()) > 0)
			node.setRight(recRemove(target,node.getRight()));
		else //if the target is found.
		{
			node = removeNode(node);
			found = true;
		}
		return node;
	}
	
	private BSTNode<T> removeNode(BSTNode<T> node)
	{
		T data;
		if(node.getLeft() == null) // if the tree do not has left subtree, just remove it and return right subtree
			return node.getRight();
		else if(node.getRight() == null)
			return node.getLeft();
		else 
		{// if the target has subtree
			data = getPredecessor(node.getLeft());// lefttree's right node
			node.setInfo(data);
			node.setLeft(recRemove(data, node.getLeft()));// then remove it 
			return node;
		}
	}
	
	private T getPredecessor(BSTNode<T> subtree) 
	{
		BSTNode<T> temp = subtree;
		while(temp.getRight() != null)
			temp = temp.getRight();
		return temp.getInfo();
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		//this tree is never full
		return false;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (root == null);
	}


	@Override
	public int size() {
		// TODO Auto-generated method stub
		System.out.println("The size of the tree is :" + iteSize(root) + " (using the iterative method ");
		System.out.println("the size of the tree is :" + recSize(root) + " (using the recursive method)");
		return iteSize(root);
	}
	
	//use recursive approach
	private int recSize(BSTNode<T> node)
	{
		if(node == null)
			return 0;
		else
			return 1 + recSize(node.getLeft()) + recSize(node.getRight());
	}
	
	//use Iterative approach
	private int iteSize(BSTNode<T> node) 
	{
		int count = 0;
		if(root != null) 
		{
			LinkedListStack<BSTNode<T>> nodeStack = new LinkedListStack<BSTNode<T>>();
			BSTNode<T> currNode;
			nodeStack.push(root);
			while(!nodeStack.isEmpty()) //pop the top value of the stack and push it's subNode into the Stack
			{
				currNode = nodeStack.peek().getInfo();
				nodeStack.pop();
				count++;
				if(currNode.getLeft() != null)
					nodeStack.push(currNode.getLeft());
				if(currNode.getRight() != null)
					nodeStack.push(currNode.getRight());
			}
		}
		return count;
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		
		return null;
	}


	@Override
	public T min() {
		// TODO Auto-generated method stub
		if(isEmpty())
			return null;
		else 
		{
			BSTNode<T> node = root;
			while(node.getLeft() != null) 
			{
				node = node.getLeft();//the min node is the left node of the whole tree
			}
			return node.getInfo();
		}
	}


	@Override
	public T max() {
		// TODO Auto-generated method stub
		if(isEmpty())
			return null;
		else 
		{
			BSTNode<T> node = root;
			while(node.getRight() != null)
				{
				node = node.getRight();
				}
			return node.getInfo();
		}
	}


	@Override
	public Iterator<T> getIterator(Traversal orderType) {
		// TODO Auto-generated method stub
		final LinkedQueue<T> infoQueue = new LinkedQueue<T>();
		if(orderType == Traversal.Preorder)
			try {
				preOrder(root, infoQueue);
			} catch (QueueOverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if(orderType == Traversal.Inorder)
			try {
				inOrder(root, infoQueue);
			} catch (QueueOverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if(orderType == Traversal.Postorder)
			try {
				postOrder(root, infoQueue);
			} catch (QueueOverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return new Iterator<T>() 
		{
			public boolean hasNext() 
			{
				return !infoQueue.isEmpty();
			}
			
			public T next() 
			{
				if(!hasNext())
					throw new IndexOutOfBoundsException("illegal invocation of next" + "in BinarySearchTree iterator. \n");
				try {
					return infoQueue.dequeue();
				} catch (QueueUnderflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
			
			public void remove() 
			{
				throw new UnsupportedOperationException("Unsupported remove attempted " + " on BinarySearchTree iterator. \n");
			}
		};
	}
	
	private void inOrder(BSTNode<T> node, LinkedQueue<T> q) throws QueueOverflowException 
	{
		if(node != null) 
		{
			inOrder(node.getLeft(), q);
			q.enqueue(node.getInfo());
			inOrder(node.getRight(), q);
		}
	}
	
	private void preOrder(BSTNode<T> node, LinkedQueue<T> q) throws QueueOverflowException 
	{
		if(node != null) 
		{
			q.enqueue(node.getInfo());
			preOrder(node.getLeft(),q);
			preOrder(node.getRight(), q);
		}
	}
	private void postOrder(BSTNode<T> node, LinkedQueue<T> q) throws QueueOverflowException 
	{
		if(node != null) 
		{
			postOrder(node.getLeft(), q);
			postOrder(node.getRight(), q);
			q.enqueue(node.getInfo());
		}
	}
	
	public int getMaxDepth(BSTNode<T> root) 
	{
		if(root == null)
			return 0;
		else 
		{
			int left =getMaxDepth(root.getLeft());
			int right = getMaxDepth(root.getRight());
			return 1 + Math.max(left, right);
		}
	}
	}
