package Exception;
import java.util.Scanner;
public class Candidate {
	private String name;
	private int id;
	private double cgpa;
	public Candidate(String name, int id,double cgpa)
	{
		this.name = name;
		this.id = id;
		this.cgpa= cgpa;
	}
public void showDetails()
{
	System.out.println("name is "+this.name);
	System.out.println("id is "+this.id);
	System.out.println("cgpa is "+this.cgpa);
}
public void apply() throws LowCgpaException,InvalidExperienceException
{
	if (this.cgpa < 6)
	{
		throw new LowCgpaException();
	}
	else
	{
		System.out.println("enter your experience");
		Scanner sc = new Scanner(System.in);
				int e = sc.nextInt();
		if (e>=2 && e<=5)
		{
			System.out.println("Job Confirmed");
		}
		
		else if (e>5)
		{
			System.out.println("Job experience does not match");
		}
		else
		{
			throw new InvalidExperienceException();
		}
		}
}
}
