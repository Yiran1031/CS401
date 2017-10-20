
public class Demo {
	public static void main(String args[]) throws StackUnderflowException 
	{
		ReadFile r = new ReadFile("/myFile.txt");
		ArrayListStack list = r.readFile();
		Employee e1 = (Employee) list.Peek();
		System.out.println("ID:" + e1.getId() + " Name:" + e1.getName());
		list.pop();
		list.pop();
		e1 = (Employee) list.Peek();
		System.out.println("ID:" + e1.getId() + " Name:" + e1.getName());
	}
}
