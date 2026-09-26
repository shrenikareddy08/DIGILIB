import java.util.Scanner;
public class Employee {
	private int id;
	private String name;
	public Employee(int id,String name)
	{
		this.id = id;
		this.name = name;
	}
	public void show()
	{
		System.out.println("id is"+this.id);
		System.out.println("name is"+this.name);
	}

}
