
public class Demo {
	public static void main(String args[]) throws QueueOverflowException, QueueUnderflowException  
	{
		System.out.println("using LinkedList Queue");
		ReadFile r = new ReadFile("/myFile.txt");
		LinkedQueue list = r.readFile();
		Employee e1 = (Employee) list.peek();
		System.out.println("ID:" + e1.getId() + " Name:" + e1.getName());
		list.dequeue();
		list.dequeue();
		e1 = (Employee) list.peek();
		System.out.println("ID:" + e1.getId() + " Name:" + e1.getName());
		System.out.println("There are " + list.size() + " employee in the queue");
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.println("using Floating Front");
		ReadFile2 r2 = new ReadFile2("/myFile.txt");
		FloatingFront f = r2.readFile();
		Employee e2 = (Employee) f.peek();
		System.out.println("ID:" + e2.getId() + " Name:" + e2.getName());
		f.dequeue();
		f.dequeue();
		e2 = (Employee) f.peek();
		System.out.println("ID:" + e2.getId() + " Name:" + e2.getName());
		System.out.println("There are " + f.size() + " employee in the Floating Front array queue");
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.println("using Fixed Front");
		ReadFile3 r3 = new ReadFile3("/myFile.txt");
		FixedFront f2 = r3.readFile();
		Employee e3 = (Employee) f2.peek();
		System.out.println("ID:" + e3.getId() + " Name:" + e3.getName());
		f2.dequeue();
		f2.dequeue();
		e3 = (Employee) f2.peek();
		System.out.println("ID:" + e3.getId() + " Name:" + e3.getName());
		System.out.println("There are " + f2.size() + " employee in the Fixed Front array queue");
	} 
}
