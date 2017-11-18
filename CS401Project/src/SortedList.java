import java.util.Comparator;

public class SortedList {
	protected LLNode<Coupon> head;
	LinkedList<Coupon> ul;
	String key;
	int i;
	public SortedList() 
	{
		ul = null;
		head = null;
		i = 30;
	}
	
	public SortedList(LinkedList<Coupon> ul, String key, int i) 
	{
		head = null;
		this.ul = ul; 
		this.key = key;
		this.i = i;
	}
	
	
	public Coupon[] sorted(int i, String key) 
	{
		Coupon[] array = ul.addToArray(i);
		if(key.equals("Provider")) 
		{
			String[] str = new String[array.length];
			for(int n = 0; n < str.length; n++) 
			{
				if(array[n]!=null)
				str[n] = array[n].getProvider();
				//System.out.println("-------------------");
				//System.out.print(str[n]);
			}
			
			for(int m=0; m < array.length; m++) 
			{
				if(str[m]!=null) 
				{
					for(int n = m; n < array.length; n++) 
					{
						if(str[n]!=null) 
						{
							if(str[m].compareTo(str[n]) < 0) 
							{
								String t = str[m];
								str[m] = str[n];
								str[n] = t;
								Coupon temp = array[m];
								array[m] = array[n];
								array[n] = temp;
							}
						}
					}
				}
			}
		}else if(key.equals("Product")) 
		{
			String[] str = new String[array.length];
			for(int n = 0; n < str.length; n++) 
			{
				if(array[n]!=null)
				str[n] = array[n].getProduct();
				//System.out.println("-------------------");
				//System.out.print(str[n]);
			}
			
			for(int m=0; m < array.length; m++) 
			{
				if(str[m]!=null) 
				{
					for(int n = m; n < array.length; n++) 
					{
						if(str[n]!=null) 
						{
							if(str[m].compareTo(str[n]) < 0) 
							{
								String t = str[m];
								str[m] = str[n];
								str[n] = t;
								Coupon temp = array[m];
								array[m] = array[n];
								array[n] = temp;
							}
						}
					}
				}
			}
		}else if(key.equals("Price")) 
		{
			
		}
	
		/*for(int e = 0; e<array.length; e++) 
		{
			System.out.println(array[e]);
		}*/
		return array;
	}
	
	public void addToSL() 
	{
		
		Coupon[] c = this.sorted(i, key);
		for(int i = 0; i < c.length; i++) 
		{
			if(c[i] != null) 
			{
				add(c[i]);
			}
		}
	}
	
	public void add(Coupon object) 
	{
		LLNode<Coupon> node = new LLNode(object);
		node.setLink(head);
		head = node;	
	}
	
	public LLNode<Coupon> getHead()
	{
		return head;
	}
	
}
