import java.util.Scanner;

public class test {
	public static void main(String args[]) 
	{
		String n1, n2;
		int i1, i2;
		
		int x = 13;
		System.out.print(x/2);
		
		
		System.out.println("Please input the first employee's name");//input first employee's data
		Scanner s1 = new Scanner(System.in);
		n1 = s1.nextLine();
		System.out.println("Please input the first employee's id");
		Scanner s2 = new Scanner(System.in);
		i1 = s2.nextInt();
		Employee e1 = new Employee(i1, n1);
		
		System.out.println("");//print first employee's data
		System.out.println("id = " + e1.getId());
		System.out.println("name = " + e1.getName());
		System.out.println("");
		System.out.println("Please input the second employee's name");
		
		Scanner s3 = new Scanner(System.in);// input second one 
		n2 = s3.nextLine();
		System.out.println("Please input the second employee's id");
		Scanner s4 = new Scanner(System.in);
		i2 = s4.nextInt();
		Employee e2 = new Employee(i2,n2);
		
		System.out.println("");// print 
		System.out.println("id = " + e2.getId());
		System.out.println("name = " + e2.getName());	
		System.out.println("");
		System.out.println("compareing result(compareTo) :");
		
		if(e1.compareTo(e2) == 2) // compare 2 employee by compareTo method
		{
			System.out.println("they are different people");
		}else if (e1.compareTo(e2) == 1) 
		{
			System.out.println("They are different people, but they have same name, and  first employee's id more than the scond one");
		}else if (e1.compareTo(e2) == -1) 
		{
			System.out.println("They are different people, but they have same name, and  first employee's id less than the scond one");
		}else if (e1.compareTo(e2) == 0) 
		{
			System.out.println("They are same people");
		}
		
		System.out.println("");
		System.out.println("compareing result(compare) :");// compare 2 employee by compare method
		if(e1.compare(e1,e2) == 2) 
		{
			System.out.println("they are different people");
		}else if (e1.compare(e1,e2) == 1) 
		{
			System.out.println("They are different people, but they have same name, and  first employee's id more than the scond one");
		}else if (e1.compare(e1,e2) == -1) 
		{
			System.out.println("They are different people, but they have same name, and  first employee's id less than the scond one");
		}else if (e1.compare(e1,e2) == 0) 
		{
			System.out.println("They are same people");
		}
	}
}
