
public class LinkedList<T> {
	private LLNode<T> first;
	
	public LinkedList()
	{
		first = null;
	}
	
	public void add(T object)
	{
		LLNode<T> node = new LLNode(object);
		node.setLink(first);
		first = node;
	}
	
	public LLNode<T> delete()
	{
		LLNode<T> temp = first;
		first = temp.getLink();
		return temp;
	}
	
	public LLNode<T> getFirst()
	{
		return first;
	}
}