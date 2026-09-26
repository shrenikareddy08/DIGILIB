package Exception;

public class LimitExcessException extends Exception 
{
	public void show()
	{
		System.out.println("Limit is only 20000");
	}

}
