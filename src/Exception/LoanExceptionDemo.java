package Exception;
import java.util.Scanner;
class LoanExceptionDemo {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter id and name");
	int id = sc.nextInt();
	String name = sc.next();
	Loan l1 = new Loan(id,name);
	try
	{
		l1.checkPanCard();
		l1.CibilScore();
	}
	catch (NoPanCardException np)
	{
		np.show();
	}
	catch (LowCibilScoreException lc)
	{
		lc.show();
	}
	finally 
	{
		System.out.println("thankyou");
	}
			

	}

}
