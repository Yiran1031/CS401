package lab9;

public class LinkedList<T> implements ListInterface{
	protected LLNode<T> list;
	protected LLNode<T> location;
	protected LLNode<T> previous;
	protected LLNode<T>currentPos;
	protected int numElements;
	protected boolean found;
	
	public LinkedList() 
	{
		list = null;
		location = null;
		previous = null;
		currentPos = null;
		numElements = 0;
		found = false;
	}
	
	public void add(T element) 
	{
		LLNode<T> newNode = new LLNode(element);
		if(list == null) 
		{
			// add element to an empty list
			list = newNode;
			newNode.setLink(list);
		}else 
		{
			//add element to a non-empty list
			newNode.setLink(list.getLink());//newNode link previous first node
			list.setLink(newNode);//Last node link newNode
			list = newNode;
		}
		numElements++;
	}
	
	public void remove() 
	{
		if(isEmpty())
			{
			list = list.getLink();
			}
	}
	
	public boolean is_Full() 
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

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(Object element) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Object get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		// reset the value of currentPos
		if(list != null)
			currentPos = list.getLink();
	}

	@Override
	public T getNext() {
		// TODO Auto-generated method stub
		// return the current information and move currentPos to the next link
		T next = currentPos.getInfo();
		currentPos = currentPos.getLink();
		return null;
	}
	
	//override toString, make it can print all node in list
	public String toString() 
	{
		String listString = "List:\n";
		if(list != null) 
		{
			LLNode<T> prevNode = list;
			do 
			{
				listString = listString + " " + prevNode.getLink().getInfo() + "\n";
				prevNode = prevNode.getLink();
			}while(prevNode != list);
		}
		return listString;
	}
	protected void find(Object target) 
	{
		boolean moreToSearch;
		location = list;
		found = false;
		//find if the list is null
		moreToSearch = (location != null);
		while(moreToSearch && !found) 
		{
			//move search to the next node
			previous = location;
			location = location.getLink();
			//check for match
			if(location.getInfo().equals(target))
				found = true;
		//find if there are more node to search
			moreToSearch = (location != list);
		}
	}

	@Override
	public boolean remove(Object element) {
		// TODO Auto-generated method stub
		//removes an element e from this list such that e.equals(element)
		// and returns true; if no such element exists returns false;
		find(element);
		if(found) 
		{
			if(list == list.getLink())// if single element list
				list = null;
			else
				if(previous.getLink() == list)// if removing last node
					list = previous;
					previous.setLink(location.getLink()); // remove node
				numElements--;
		}
		return found;
	}
}
