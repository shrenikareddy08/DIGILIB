package Exception;
import java.util.Scanner;
public class LicenseExceptionDemo {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter age");
		int age = sc.nextInt();
		License l1 = new License(age);
		System.out.println("License info is: ");
		l1.showDetails();
		try
		{
			l1.checkAge(age);
	}
		catch (InsufficientAgeException ia)
		{
			ia.show();
			}
		finallyz
		{
			System.out.println("Thankyou for choosing licensechecker");
		}
		
	}

}
