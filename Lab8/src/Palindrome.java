import java.util.Scanner;

public class Palindrome {
	public static boolean test() throws QueueOverflowException, QueueUnderflowException 
	{
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		int length = str.length();
		char a[]=str.toCharArray();
		LinkedQueue<Character> l1 = new LinkedQueue();
		LinkedQueue<Character> l2 = new LinkedQueue();
		for(int i = 0; i < length; i++) 
		{
			l1.enqueue(a[i]);
		}
		for(int i = length - 1; i >= 0; i--) 
		{
			l2.enqueue(a[i]);
		}
		for(int i = 0; i < length; i++) 
		{
			if(l1.dequeue() != l2.dequeue())
				return false;
		}
		return true;
	}
	public static void main(String[] args) throws QueueOverflowException, QueueUnderflowException 
	{
		if(Palindrome.test()) {
			System.out.println("It is a palindrome");
		}else
			System.out.println("It is not a palindrome");
	}
}
