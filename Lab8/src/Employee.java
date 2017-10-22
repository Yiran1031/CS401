import java.util.Comparator;

public class Employee implements Comparable<Employee>, Comparator<Employee>{
	private int id;
	private String name;
	
	// constructor
	public Employee() 
	{
		
	}
	
	public Employee(int id, String name) 
	{
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	
	//res has 4 value, 2 means they are totally different, 1 and -1 means they have the same name but different id, 0 means they are the same people.
	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		int res = 2;
		if(o1.getName().equals(o2.getName())) // compare 2 employee's name by equals method
		{
			if(o1.getId() == o2.getId()) 
			{
				res = 0;
			}else if(o1.getId() > o2.getId()) 
			{
				res = 1;
			}else if(o1.getId() < o2.getId()) 
			{
				res = -1;
			}
		}else
		{
			return res;
		}
		return res;
	}@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		int res = 2;
		if(this.getName().equals(o.getName())) 
		{
			if(this.getId() == o.getId()) 
			{
				res = 0;
			}else if(this.getId() > o.getId()) 
			{
				res = 1;
			}else if(this.getId() < o.getId()) 
			{
				res = -1;
			}
		}else
		{
			return res;
		}
		return res;
	}
	
}