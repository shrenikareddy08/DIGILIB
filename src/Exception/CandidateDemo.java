package Exception;
import java.util.Scanner;
public class CandidateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter name,id,cgpa");
		String name = sc.next();
		int id = sc.nextInt();
		double cgpa = sc.nextDouble();
		Candidate c1 = new Candidate(name,id,cgpa);
		try 
		{
			c1.apply();
		}
		catch(LowCgpaException lc)
		{
			lc.show();
		}
catch(InvalidExperienceException ie)
		{
	ie.show();
		}
		finally
		{
			System.out.println("thankyou for applying");
		}
		
	}

}
