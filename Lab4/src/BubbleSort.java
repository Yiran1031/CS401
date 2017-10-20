import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSort {
	public static int size = 30;
	static ArrayList<Employee> list = new ArrayList();
	public static void main(String args[])
	{
		readFile();
		double start, end;
		start = System.currentTimeMillis(); 
		bubbleSort();
		end = System.currentTimeMillis() - start; 
		System.out.println(end);

	}
	
	
	public static void readFile()
	{
		try {
			Scanner s = new Scanner(new File("/myFile.txt"));	
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
					list.add(e);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static void bubbleSort()
	{
		int index = 0;
		int i,j;
		for(i = 0; i < 30; i++) 
		{
			for(j = i+1; j < 30; j++) 
			{
				if(list.get(i).getId() > list.get(j).getId())
				{
					swap(i,j);
				}
			}
		}
		for(int d = 0; d < 30; d++) 
		{
			System.out.println(list.get(d).getId()+" " +list.get(d).getName());
		}
	}
	
	
	public static void swap(int a, int b) 
	{
		Employee c = new Employee();
		c = list.get(a);
		list.set(a, list.get(b));
		list.set(b, c);

	}


}
