package Exception;
import java.util.Scanner;
public class InsuranceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id,age,name");
			int policyId = sc.nextInt();
			int age = sc.nextInt();
			String name = sc.next();
			Insurancee i1= new Insurancee(policyId,age,name);
			System.out.println("info is");
			i1.showInsurance();
			try
			{
				i1.insurance();
			}
			catch(InvalidAgeException  ia)
			{
				ia.showInsurance();
			}
			catch(MedicalTestRejectionException mt)
			{
				mt.showInsurance();
			}
			finally
			{
				System.out.println("thankyou,see you!");
			}
			

	}

}
