import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	ArrayListStack<Employee> list = new ArrayListStack();
	private String l;
	
	public String getL() {
		return l;
	}

	public void setL(String l) {
		this.l = l;
	}

	public ReadFile() 
	{
		setL(null);
	}
	
	public ReadFile(String s) 
	{
		setL(s);
	}
	
	
	public ArrayListStack<Employee> readFile()
	{
		try {
			Scanner s = new Scanner(new File(l));	
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
					list.push(e);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}
}
