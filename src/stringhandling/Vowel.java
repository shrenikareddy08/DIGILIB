package stringhandling;
import java.util.Scanner;
public class Vowel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string");
		String s1 = sc.next();
		String s2 = s1.toLowerCase();
		System.out.println(s2);
		int i;
		int vowelCount = 0;
		for  (i = 0; i <s2.length() ; i++)
		{
			if ((s2.charAt(i) == 'a') || (s2.charAt(i) == 'e') || (s2.charAt(i) == 'i') || (s2.charAt(i) == 'o') || (s2.charAt(i) == 'u'))
			{
				vowelCount++;
				
			}
		}
		System.out.println("vowelCount is : " +vowelCount);

	}

}
