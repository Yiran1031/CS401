package lab9;

public class LinkedList<T> {
	protected LLNode<T> list;
	protected LLNode<T> location;
	protected LLNode<T> previous;
	protected LLNode<T>currentPos;
	protected int numElements;
	protected boolean found;
	
	public LinkedList() 
	{
		list = null;
	}
	
	public void add(T element) 
	{
		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(list);
		list  = newNode;
	}
	
	public void remove() 
	{
		if(isEmpty())
			{
			list = list.getLink();
			}
	}
	
	public boolean isFull() 
	{
		return false;
	}
	
	public boolean isEmpty() 
	{
		if(list == null) 
		{
			return true;
		}else
			return false;
	}
}
