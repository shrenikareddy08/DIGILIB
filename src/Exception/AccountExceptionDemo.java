package Exception;

import java.util.Scanner;

public class AccountExceptionDemo {

  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    System.out.println("enter acno,name,balance");
    int acno=sc.nextInt();
    String acname=sc.next();
    double bal=sc.nextDouble();
    
    Account a1=new Account(acno,acname,bal);
    System.out.println("a1 information is");
    a1.showAccount();
    try 
    {
    System.out.println("enter to withdraw");
    double amt=sc.nextDouble();
    double avbal=a1.withdraw(amt);
    System.out.println("After withdraw available balance is "+avbal);
    }
    catch(InsufficientException ie) 
    {
      ie.show();
    }
    catch(InvalidDenominationException id)
    {
      id.show();
    }
    catch (LimitExcessException le)
    {
    	le.show();
    }
    finally
    {
      System.out.println("thanks for using ATM");
    }
// finally block contains set of instructions which will get executed whether there is a exception or not
  }

}