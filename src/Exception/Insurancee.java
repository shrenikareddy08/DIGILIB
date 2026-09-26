package Exception;
import java.util.Scanner;
public class Insurancee {
private int policyId;
private int age;
private String name;
public Insurancee(int policyId, int age,String name)
{
		this.policyId = policyId;
		this.age = age;
		this.name = name;
		
}
public void showInsurance()
{
	System.out.println("id is " +this.policyId);
	System.out.println("age is " +this.age);
	System.out.println("name is " +this.name);
	
}
public void insurance() throws InvalidAgeException,MedicalTestRejectionException
{
	if (age < 21)
	{
		 InvalidAgeException ia = new  InvalidAgeException();
		 throw ia;
	}
	else
	{
		System.out.println("enter test score");
		Scanner sc = new Scanner(System.in);
		int medicalscore = sc.nextInt();
	if (medicalscore < 60)
	{
		MedicalTestRejectionException mt = new MedicalTestRejectionException();
		throw mt;
	}
	else
	{
		System.out.println("CONGRATS,YOU RECIEVED INSURANCE");
	}
	}
}
}

