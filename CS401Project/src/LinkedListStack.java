public class LinkedListStack<T> {
	LinkedList<T> list = new LinkedList();
	public LinkedListStack()
	{
	}
	
	public void push(T obj)
	{
		list.add(obj);
	}
	
	public LLNode<T> pop()
	{
		return list.delete();
	}
	
	public LLNode<T> peek()
	{
		return list.getFirst();
	}
	
	public boolean isEmpty() 
	{
		if (list.getFirst() == null)
		{	
			return true;
		}
		else 
			return false;
	}
}