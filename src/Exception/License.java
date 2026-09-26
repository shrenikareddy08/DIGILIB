package Exception;
import java.util.Scanner;
public class License {
private int age;
public License(int age)
{
	this.age = age;
}
public void showDetails()
{
	System.out.println("Age is " +this.age);
}
public void checkAge(int age ) throws InsufficientAgeException {
	if (age >= 18)
	{
		System.out.println("YES,ELIGIBLE");
	}
	else
	{
		InsufficientAgeException ia = new InsufficientAgeException();
	}
}
}
