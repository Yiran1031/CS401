import java.util.Scanner;

public class Demo {
	public static void main(String args[])
	{
		LinkedListStack<String> operator_stack = new LinkedListStack();
		//LinkedListStack<String> Postfix_String = new LinkedListStack();
		LinkedListStack<String> Evaluation_stack = new LinkedListStack();
		String Postfix_String = "";
		int result = 0;
		
		ReadFile r = new ReadFile();	
		LinkedListStack<Employee> list = new LinkedListStack();
		list = r.readFile();
		System.out.println(list.peek().getInfo().getName()+list.peek().getInfo().getId());
		list.pop();
		list.pop();
		System.out.println(list.peek().getInfo().getName()+list.peek().getInfo().getId());
		Scanner s  = new Scanner(System.in);
		String e = s.nextLine();
		//System.out.println(e);
		String[] ss = e.split("");
		for(int i = 0; i < ss.length; i++) 
		{
			
			//System.out.println(ss[i]);
			if(ss[i].equals("+") || ss[i].equals("-") || ss[i].equals("*") || ss[i].equals("/")) 
			{
				if(operator_stack.isEmpty())
					{
						operator_stack.push(ss[i]);
					}
				else if(!operator_stack.isEmpty()) 
				{
					if(ss[i].equals("*") || ss[i].equals("/")) 
					{
						if(operator_stack.peek().getInfo().equals("*") || operator_stack.peek().getInfo().equals("/")) 
						{
							/*do {
								//Postfix_String = Postfix_String + operator_stack.pop().getInfo();
								}
							while(!operator_stack.isEmpty());*/
							operator_stack.push(ss[i]);
						} 
						operator_stack.push(ss[i]);
					}
					else {
						do
							{
								Postfix_String = Postfix_String + operator_stack.pop().getInfo();		
							}
						while(!operator_stack.isEmpty());
						operator_stack.push(ss[i]);
					} 
					
				}
			}else
			{
				Postfix_String = Postfix_String + ss[i];
			}
			
			
		}
		if(!operator_stack.isEmpty()) 
		{
			do
			{
				Postfix_String = Postfix_String + operator_stack.pop().getInfo();		
			}while(!operator_stack.isEmpty());
		}
		System.out.println(Postfix_String);
		String[] ss2 = Postfix_String.split("");
		for(int i = 0; i < ss2.length; i++) 
		{
			
			if(ss2[i].equals("+") || ss2[i].equals("-") || ss2[i].equals("*") || ss2[i].equals("/")) 
			{
				int a = Integer.parseInt(Evaluation_stack.pop().getInfo());
				int b = Integer.parseInt(Evaluation_stack.pop().getInfo());
				if(ss2[i].equals("+"))
					result = a + b;
				if(ss2[i].equals("-"))
					result = b - a;
				if(ss2[i].equals("*"))
					result = a * b;
				if(ss2[i].equals("/"))
					result = b / a;
				Evaluation_stack.push(String.valueOf(result));
			}else 
			{
				Evaluation_stack.push(ss2[i]);
			}
			//System.out.println(ss2[i]);
		}
		System.out.println(Evaluation_stack.pop().getInfo());
	}
}
