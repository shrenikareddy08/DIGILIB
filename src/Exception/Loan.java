package Exception;
import java.util.Scanner;
public class Loan {
	private int id;
	private String name;
	public Loan(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	public void showDetails()
	{
		System.out.println("Id is"+this.id);
		System.out.println("name is "+this.name);
	}
	public void checkPanCard() throws NoPanCardException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your choice of pancard availability 1.yes\n 2.no");
		int ch = sc.nextInt();
		if (ch == 1)
		{
			System.out.println("Yes,Pancard is available");
		}
		else
		{
			throw new NoPanCardException();
		}
		
	}
	public void CibilScore() throws LowCibilScoreException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your cibil score");
		int c = sc.nextInt();
		if (c< 500)
		{
			throw new LowCibilScoreException();
			}
		else if (c<600 && c>=500)
		{
			System.out.println("loan amt is 1lakh");
		}
		else if (c>=600 && c<700)
		{
			System.out.println("loan amt is 2lakh");
		}
		else if (c>=700 && c<800)
		{
			System.out.println("loan amt is 3lakh");
		}
		else
		{
			System.out.println("loan amt is 5lakh");
		}
	}
	
}
