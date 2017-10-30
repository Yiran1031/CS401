package lab9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestArray {
	
	public static void main(String args[]) 
	{
		TestArray t = new TestArray();
		t.readFile();
	}
	public static CS401ArrayImpl<Employee> readFile() 
	{
		
		CS401ArrayImpl  arraylist = new CS401ArrayImpl(10);
		try {
			Scanner s = new Scanner(new File("C:\\Users\\41567\\Desktop\\code\\lab9\\src\\lab9\\emp.txt"));	
			String str[] = new String[2];
			while(s.hasNext())
			{
				//System.out.println(s.nextLine());
				Employee e = new Employee();
				str = s.nextLine().split(" ");
				int i = 0;
				while(i<= 1)
				{
					if(i%2 == 0)
					{
						//System.out.println(str[i]);
						e.setName(str[i]);
						i++;
					}
					if(i%2 == 1)
					{
						//System.out.println(str[i]);
						e.setId(Integer.parseInt(str[i]));
						i++;
					}
					//System.out.println(e.getName()+e.getId());
					arraylist.add(e);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		for(int a = 0; a < arraylist.size(); a++) 
		{
			Employee e = (Employee)arraylist.get(a);
			System.out.println("" + e.getId() + " " + e.getName() );
		}
		arraylist.remove(3);
		for(int a = 0; a < arraylist.size(); a++) 
		{
			Employee e = (Employee)arraylist.get(a);
			System.out.println("" + e.getId() + " " + e.getName() );
		}
		return arraylist;
	}
}
