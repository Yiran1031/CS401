import java.io.IOException;

public class LinkedList<T> {
	protected LLNode<T> first;
	//protected int length;
	
	public LinkedList()
	{
		first = null;
		//length = 30;
	}
	
	public LinkedList(int length) 
	{
		first = null;
		//this.length = length;
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
	
	public Coupon[] addToArray(int i) 
	{
		int n = 0;
		LLNode<Coupon> temp = (LLNode<Coupon>)first;
		Coupon[] arr = new Coupon[i];
		while(n < i && temp!=null) 
		{
			//System.out.println(temp.getInfo());
			arr[n] = temp.getInfo();
			temp = temp.getLink();
			n++;		
		}
		return arr;
	}	
}