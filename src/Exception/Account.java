package Exception;

public class Account {
  private int acno;
  private String acName;
  private double bal;
  public Account(int acno,String acName,double bal) 
  
  {
    this.acno=acno;
    this.acName=acName;
    this.bal=bal;
    
  }
  public void showAccount()
  {
    System.out.println("acno is "+this.acno);
    System.out.println("ac holder name is "+this.acName);
    System.out.println("balance is "+this.bal);
  }
  public double withdraw(double amt) throws InsufficientException,InvalidDenominationException,LimitExcessException
  
  {
    if((amt%100)!=0)
    {
      InvalidDenominationException id = new InvalidDenominationException();
      throw id;
    }
    if (amt > 20000)
    {
    	LimitExcessException le = new LimitExcessException();
    	throw le;
    }
    if(amt>this.bal)
    {
      InsufficientException ie = new InsufficientException();
      throw ie;
    }
    else
    {
      this.bal=this.bal-amt;
      System.out.println("ready for cash");
      return this.bal;
    }
    
  }

}