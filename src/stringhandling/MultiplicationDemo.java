package stringhandling;
import java.util.Scanner;
public class MultiplicationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter 3 integers");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		Multiplication om = new Multiplication();
		int res1 = om.multiply(n1);
		System.out.println("1 number = " +res1);
		int res2 = om.multiply(n1,n2,n3);
		System.out.println("3 numbers" +res2);
		int res3 = om.multiply(n2, n3);
        System.out.println("2 numbers = " + res3);
        double res4 = om.multiply(1.83, 2.79);
        System.out.println("double numbers = " + res4);
		
		
		
		
	}

}
