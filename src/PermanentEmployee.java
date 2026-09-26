import java.util.Scanner;
public class PermanentEmployee extends Employee {
	private double salary;
	private int incomeTax;
	public PermanentEmployee(int id,String name,double salary,int incomeTax)
	{
		super(id,name);
		this.salary =  salary;
		this.incomeTax = incomeTax;
		
		
	}
	public void printEmployee()
	{
		super.show();
		System.out.println("salary is"+this.salary);
		System.out.println("incomeTax is"+this.incomeTax);
		
	}
	
	

}
