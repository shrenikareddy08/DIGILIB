package Exception;

public class InvalidDenominationException extends Exception {
public void show()
{
  System.out.println("Invalid denomination, denomination should be multiple of 100");
}
}