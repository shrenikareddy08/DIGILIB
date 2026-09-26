package stringhandling;
import java.util.Scanner;
 class Palindrome {
	 public static void main(String[]args) {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Enter the string");
		 String s = sc.next();
		 String reverse = new StringBuilder(s).reverse().toString();
		 if (s.equals(reverse))
		 {
			 System.out.println("PALINDROME");
		 }
		 else
		 {
			 System.out.println("NOT PALINDROME");
		 }
		 
	 }
	

}
