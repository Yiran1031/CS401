package lab9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortedLinkedList<T> extends LinkedList<T> {
	private boolean isMin;
	protected LLNode<Employee> l;
	protected LLNode<Employee> p;
	public void add(Employee element) 
	{
		LLNode<T> newNode = new LLNode(element);
		if(list == null) 
		{
			// add element to an empty list
			list = newNode;
			newNode.setLink(list);
		}else 
		{
			findLoc(element);
			//add element to a non-empty list
			if(isMin)
			{
			
			((LLNode<Employee>)newNode).setLink(l);
			p.setLink((LLNode<Employee>)newNode);
			}else if(!isMin) 
			{
				newNode.setLink(list.getLink());//newNode link previous first node
				list.setLink(newNode);//Last node link newNode
				list = newNode;
			}
		}
		numElements++;	
	}
	
	public boolean remove(Object element) {
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
	
	//linkedlist never full
	public boolean is_Full() 
	{
		return false;
	}
	
	public SortedLinkedList<Employee> readFile()
	{
		SortedLinkedList<Employee> sortList = new SortedLinkedList();
		try {
			Scanner s = new Scanner(new File("C:\\Users\\41567\\Desktop\\code\\lab9\\src\\lab9\\emp.txt"));	
			String str[] = new String[2];
			while(s.hasNext())
			{

				Employee e = new Employee();
				str = s.nextLine().split(" ");
				int i = 0;
				while(i<= 1)
				{
					if(i%2 == 0)
					{
						e.setName(str[i]);
						i++;
					}
					if(i%2 == 1)
					{
						e.setId(Integer.parseInt(str[i]));
						i++;
					}
					sortList.add(e);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return sortList;
	}
	// Fint if there is a value more than target 
	protected void findLoc(Employee target) 
	{
		LLNode<Employee> min = null;
		boolean moreToSearch;
		l = (LLNode<Employee>)list;
		isMin = false;
		//find if the list is null
		moreToSearch = (l != null);
		while(moreToSearch && !isMin) 
		{
			//move search to the next node
			p = l;
			l = l.getLink();
			//check for if the new node less than the other node in the list
			if(l.getInfo().getId() > target.getId())
				isMin = true;
		//find if there are more node to search
			moreToSearch = (l != list);
		} 
	}
	public void printlist() 
	{
		l = (LLNode<Employee>)list;
		while(l != null) 
		{
			if(l.getLink() != (LLNode<Employee>)list) {
			System.out.println("" + l.getInfo().getId() + " " + l.getInfo().getName());
			l = l.getLink();}
			else 
			{
				System.out.println("" + l.getInfo().getId() + " " + l.getInfo().getName());
				l = null;
			}
		} 
	}
	public static void main(String[] args) 
	{
		SortedLinkedList<Employee> s = new SortedLinkedList();
		s = s.readFile();
		s.printlist();
	}
}
