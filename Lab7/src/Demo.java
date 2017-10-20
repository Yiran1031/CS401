
public class Demo {
	public static void main(String[] args) 
	{
		 double start1, end1,start2, end2;
		System.out.println("$ java Jacobsthal 10");
		start1 = System.currentTimeMillis();
		System.out.print("Recursive version:");
		for(int i = 0; i <=10; i++) 
		{
			System.out.print(Jacobsthal_recursive(i)+",");
		}
		end1 = System.currentTimeMillis() - start1; 

		System.out.println("");
		System.out.println("Time taken to execute recursive version:" + end1 +"msec\r\n");
		start1 = System.currentTimeMillis();
		System.out.print("Iterative version:");
		for(int i = 0; i <=64; i++) 
		{
			System.out.print(Jacobsthal_iterative(i)+",");
		}
		System.out.println("");
		end1 = System.currentTimeMillis() - start1; 
		System.out.println("Time taken to execute recursive version:" + end1 +"msec\r\n");
		
	} 
	public static long Jacobsthal_recursive(int n) 
	{
		long a;
		if(n == 0)
			{
			a = 0;
			return a;
			}
		else if(n == 1) 
		{
			a = 1;
			return a;
		}
		return a = Jacobsthal_recursive(n-1) + 2*Jacobsthal_recursive(n-2);
		
	}
	public static long Jacobsthal_iterative(int n) 
	{
		int i = 1;
		long a,b,c;
		c = 0;
		a = 1;
		b = 0;
		while(i <= n) 
		{
			if(i == 0) 
			{
				c = 0;
				//System.out.print(c+",");
				i++;
			}else if (i == 1) 
			{
				c = 1;
				//System.out.print(c+",");
				i++;
			}else {
				c = a + 2*b;
				b = a;
				a = c;
				i++;
				//System.out.print(c+",");
			}
		}
		return c;
	}
}
