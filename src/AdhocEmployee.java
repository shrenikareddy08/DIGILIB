public class AdhocEmployee extends Employee {
	private String jobName;
	private double fees;
	public AdhocEmployee(String jobName,double fees,int id, String name)
	{
		super(id,name);
		this.jobName =  jobName;
		this.fees =fees;
		
		
	}
	public void printEmployee()
	{
		super.show();
		System.out.println("job name is"+this.jobName);
		System.out.println("fees is"+this.fees);
		
	}
	
	

}
